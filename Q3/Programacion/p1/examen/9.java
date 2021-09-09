import java.util.*;

class ex9 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		System.out.print("Dame un numero: ");
		int num = scan.nextInt();
		do{
			if(num%2==0) num/=2;
			else num = (num*3)+1;
			System.out.printf("\nNumero: %d",num);
		} while (num!=1);
	}
}
