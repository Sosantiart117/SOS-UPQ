import java.util.*;

class func4 {

	public static Scanner scan = new Scanner(System.in);

	static int num;

	static int[] dMeses = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static String[] nMeses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };

	public static void main(String[] args){
		//  Dame el numero de dias del mes

		do{
			System.out.print("Dame un numero del 1 al 12: ");
			num = scan.nextInt();
		}while(num<1||num>12);

		// llamar diasMesion
		// Sin Parametro
		diasMes();
		// Parametro
		System.out.print("\nEscogiste "+nMeses[num-1]+":\n");
		diasMes(num);
	}

	static void diasMes(){
		System.out.print("el 7o mes es mi favorito\n");
		diasMes(7);
	}
	static void diasMes(int mes){
		System.out.printf("El mes %s tiene %2d dias\n", nMeses[mes-1],dMeses[mes-1]);
	}
}
