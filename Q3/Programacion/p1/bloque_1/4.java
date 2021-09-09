import java.util.*;

class metrosA {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// Factores de conversion de  los metros
		double yardas=1.0936;
		double pulgadas=39.3701;
		double pies=3.2808;
		double millas=0.00062137;

		
		System.out.println("Introudce una cantidad en metros");
		float metros = scan.nextFloat();

		yardas= metros * yardas;
		System.out.println("Yardas\t:" + yardas);

		pulgadas= metros * pulgadas;
		System.out.println("Pulgadas:" + pulgadas);

		pies= metros * pies;
		System.out.println("Pies\t:" + pies);

		millas= metros * millas;
		System.out.println("Millas\t:" + millas);
	}
}
