import java.util.*;

class b5_6 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		System.out.print("Dame 2 numeros:\n>>");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.print("\n>"+num1);
		do{
			if(num1 > num2) num1--;
			else num1++;
			System.out.printf("..%d", num1);
		}while(num1 != num2);
	}
}
