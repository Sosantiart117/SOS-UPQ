// import java.util.Scanner;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;


public class exam {

    public static void main(String[] args){ //metodo main
        String foo = "Este texto es algo para el examen";
        try{
            char cha = caracterEn(foo,12);
            System.out.printf("El caracter %d, en el la cadena:\""+foo+"\" es %c\n", 12,cha);
            // esto nos genera un error
            cha = caracterEn(foo,52);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        
    }

    public static char caracterEn(String texto, int indice) throws Exception{
        if(indice > 0 && indice < texto.length()){
            return texto.charAt(indice);
        } else {
            throw new Exception("Indice "+indice+" no es valido");
        }
    }
}

