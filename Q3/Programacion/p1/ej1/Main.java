import java.util.Scanner;

public class Main{
	// Crea un metodo para usar la clase de Scanner
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int edad=0;
		double nota=0.0;
		String nombre="";

		System.out.println("Ingrese Edad");
		edad = s.nextInt();
		System.out.println("Ingrese nota");
		nota = s.nextDouble();
		s.nextLine();
		System.out.println("Ingrese nombre");
		nombre = s.nextLine();

		System.out.println("Su edad es:" + edad +" Su nota:" + nota + " y su nombre:" + nombre);
	}
}
