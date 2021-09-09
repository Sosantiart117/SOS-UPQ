import java.util.*;

class  temperaturas{
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){

		System.out.println("Introudce una cantidad en ºC");
		float celsius = scan.nextFloat();

		double kelvin = celsius +274.15;
		System.out.println("K:" + kelvin);

		double farenheit = (celsius * 1.8) + 32;
		System.out.println("ºF:" + farenheit);
	}
}
