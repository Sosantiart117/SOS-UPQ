import java.util.*;

class b3_1 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){

		// Calificaciones
		float[] parciales = new float[3];
		System.out.println("Ingresa tus calificaciones (Separado por tabs o espacios)");
		System.out.print("Parcial: |1\t|2\t|3\n\t ");
		parciales[0] = scan.nextFloat();
		parciales[1] = scan.nextFloat();
		parciales[2] = scan.nextFloat();
		 
		// Promedio
		float promedio=0;
		for(int i=0; i < 3; i++) promedio+=parciales[i];
		promedio=promedio/3;
		
		// Resultado
		for(int i=0; i < 3; i++) System.out.print("Parcial "+i+":\t"+parciales[i] + "\n");
		System.out.print("             -----------\nPromedio Final: "+promedio+"\t" );
		System.out.print(promedio > 6.9 ? "Aprobado!": "Reprobado");
	}
}
