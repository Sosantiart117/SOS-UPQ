import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static File file;

    public static void main(String[] args){ //metodo main
        // opcion de lista
        if(args.length != 0) listarCaracteres();
        // resto de programa
        String ruta, contenido;
        while(true){
            try{ 
                do{
                    // Pedir por teclado la ruta del documento
                    System.out.print("Introducir la ruta para el archivo\n> ");
                    ruta = scan.nextLine();
                    // checa problemas en la ruta
                } while(!checarRuta(ruta));
                // Pedir por teclado el contenido para el documento
                System.out.print("Introducir contenido para el archivo\n> ");
                contenido = scan.nextLine();
                // Invertir el texto
                contenido = invertir(contenido);
                escribir(contenido); // Escribir el archivo
            } catch (Exception e){
                System.err.println(e.getMessage());
            }finally{
                System.out.print("¿Volver a iniciar? (s/N)\n> ");
                if(!scan.nextLine().equalsIgnoreCase("s")) break;
            }
        }
        System.out.println("Final del programa\nGracias vuelva pronto");
    }


    private static String invertir(String content){
        int cha;
        String contenido="";
        for(int i = 0; i<content.length(); i++){
            cha = content.charAt(i);
            // System.out.println(cha); // DEBUG ver codigos letras
            if(isCap(cha)) cha+=32; // Si es mayus, se minimiza
            else if(isLow(cha)) cha-=32; // si es minus, se Capitaliza
            contenido+=(char)cha; // y todos los demas caracteres se quedan igual
        }
        // Mostrar la inversion
        System.out.println("Texto invertido:\n"+contenido);
        return contenido;
    }

    private static boolean isCap(int letra){
        if(letra > 64 && letra < 91         // Alfabeto normal
          || letra > 191 && letra < 215     // Letras A's, Æ, Ç, E's, I's, Ñ, y O's
          || letra > 215 && letra < 221)    // Ø, U's
           return true;
        return false; // Cualquier otra cosa
    }

    private static boolean isLow(int letra){
        if(letra > 96 && letra < 123        // Alfabeto normal
            || letra > 223 && letra < 247   // letras a's,æ,ç e's, i's, ñ, y o's
            || letra > 247 && letra < 253)  // ø, u's
            return true;    
        return false; // Cualquier otra cosa
    }

    private static void escribir(String contenido) throws IOException{
        // Crear archivo
        FileWriter fw = new FileWriter(file.getPath());
        fw.write(contenido);
        fw.close();
        System.out.println("Contenido guardado exitosamente!");
    }

    private static boolean checarRuta(String ruta) throws IOException{
        file = new File(ruta);
        // Checar si la ruta existe  
        if(!file.getAbsoluteFile().getParentFile().exists()){
            System.out.print("El Directorio "+file.getParent()
                    +" no existe!\n¿Desea crearlo?:(n/S)\n> ");
            if(!scan.nextLine().equalsIgnoreCase("n")){
                if(file.getParentFile().mkdirs()){
                    System.out.println("Directorio(s) creados");
                }else{
                    throw new IOException("No se pudo crear Directorio");
                }
            }else{
                System.out.println("Cambie la ruta a un directorio que existe");
                return false;
            }
        }
        return true;
    }

    // OPcional fuera del programa
    private static void listarCaracteres(){
        // Muestras los caracteres "UNICODE extendido"
        for(int i=0; i<256; i++)
            System.out.println((char)i+":"+i);
        // termina el program
        System.exit(0);
    }
}

