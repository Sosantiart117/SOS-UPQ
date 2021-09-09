import java.util.*;

class b5_3{
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		int suma=0;
		for(int i = 1; i<101;++i){
			suma+=i*i;
		}
		System.out.printf("La suma es: %d", suma);
	}
}
