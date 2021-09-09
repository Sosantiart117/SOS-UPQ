import java.util.*;

class ex8 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		int i=1,res=0;
		while(i!=99){
			res+=i;
				i++;
		}
		System.out.printf("El resultado de la suma de los enteros de 1 a 99 es:\n>> %d", res);
	}
}
