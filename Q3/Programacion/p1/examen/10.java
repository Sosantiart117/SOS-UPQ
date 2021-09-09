import java.util.*;

class ex10 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		System.out.print("Dame un numero: ");
		int num = scan.nextInt();
		for(int i=0; i<1;i=0){
			if(num%2==0) num/=2;
			else num = (num*3)+1;
			System.out.printf("\nNumero: %d",num);
			if (num==1) break;
		} 
	}
}
