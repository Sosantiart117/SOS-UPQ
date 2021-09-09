import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ej1 {
	public static void create(){
		// Creamos los objetos con las rutas
		File folder = new File("../files/");
		File file = new File("../files/file.txt");
		try{
			// Booleanos de las operaciones
			boolean isFolderCreated = folder.mkdir();
			boolean isFileCreated = file.createNewFile();
			
			FileWriter escritor = new FileWriter(file);
			escritor.write("Primer Archivo manejado en java!!");
			escritor.close();

			if(isFolderCreated && isFileCreated){
				System.out.println("EXITO! Archivo Creado");
			}else{
				System.out.println("El archivo ya existe");
			}
		}catch(IOException err){
			System.out.println("Error:"+ err);
		}
	}

	public static void read(){
		// Creamos el objeto con la ruta 
		File file = new File("../files/file.txt");
		try{
			// Scanner para "leer" el archivo
			Scanner lector = new Scanner(file);
			// Mientras tenga mas lineas, lee...
			while(lector.hasNextLine()){
				String data = lector.nextLine();
				System.out.println(data);
			}
			// Para controlar el "leak" de el lector
			lector.close();
		}catch(FileNotFoundException err){
			System.out.println("Excepcion al abrir archivo "+err);
		}
	}

	public static void delete(){
		// Creamos el objeto con la ruta 
		File file = new File("../files/file.txt");
		if(file.delete()){
			System.out.println("Archivo borrado con exito");
		}else{
			System.out.println("No se pudo borrar el archivo");
		}
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("Menu: (Trabaja con el archivo \"file.txt\")");
		System.out.println("1) Crear ");
		System.out.println("2) Leer ");
		System.out.println("3) Borrar");
		System.out.print("> ");
		int opt = scan.nextInt();
		
		switch(opt){
			case 1: 
				create();
				break;
			case 2: 
				read();
				break;
			case 3: 
				delete();
				break;
		}
		
		scan.close();
	}
}
