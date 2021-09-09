import java.io.*;

public class ej2 {
	public static void main(String[] args) {
		Lector lectura = new Lector();
		lectura.leer();
	}
}

class Lector{
	public void leer(){
		try{
			FileReader lector = new FileReader("./../files/file.txt");
			int cha;
			do{
				cha=lector.read();
				char letra= (char) cha;
				System.out.print(letra);
			}while(cha != -1);
			lector.close();
		} catch (IOException e){
			System.out.println("No se ha encontrado el archivo");
		}
	}
}
