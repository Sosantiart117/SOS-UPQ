import java.util.*;

class b3_4{
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		
		double descuento = 1,ins=100, men=150;
		System.out.print("Usted se esta inscribiendo en la alberca olímpica\n");
		System.out.print("\n¿Es alumno de la universidad?(s/N)\n>> ");
		if(scan.next().equalsIgnoreCase("s")) descuento = .50;
		System.out.print("\nInscripción: "+(ins * descuento));
		System.out.print("\nMensualidad: "+(men * descuento));
	}
}
