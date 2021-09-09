import java.util.*;

class b3_3 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		System.out.print("Dame un numero: ");
		double num = scan.nextDouble();
		System.out.print("Es un numero " + (num%2==0 ? "par": "impar"));
	}
}
