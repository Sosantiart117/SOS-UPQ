import java.util.*;

class b5_9 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		for(int i=0; i<6;i++){
			System.out.print("\n******         ");
			for(int j = 0; j<(6-i);j++) System.out.print(" ");
			for(int j = 0; j<i;j++) System.out.print("*");
			for(int j = 0; j<(i+1);j++) System.out.print("*");
			for(int j = 0; j<i;j++) System.out.print(" ");
			for(int j = 0; j<(6-i);j++) System.out.print(" ");
			for(int j = 0; j<(6-i);j++) System.out.print("*");
		}
	}
}
