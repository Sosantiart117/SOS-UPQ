import java.util.*;

class b4_1 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// Factores de conversion al 28
		// fuente: https://www.xe.com/currencyconverter/convert/?Amount=1&From=MXN&To=USD
		double euros=0.04;
		double libras=0.04;
		double dolares=0.05;
		double peuros=24.34;
		double plibras=28.29;
		double pdolares=19.96;

		System.out.print("Selecciona que tipo de cambio de divisa requieres");
		System.out.print("\n1) Dolar a Peso");
		System.out.print("\n2) Peso a Dolar");
		System.out.print("\n3) Euro a Peso");
		System.out.print("\n4) Peso a Euro");
		System.out.print("\n5) Libras a peso");
		System.out.print("\n6) Peso a Libras");
		System.out.print("\n>> ");
		int conv = scan.nextInt();
		System.out.print("\nIntroduzca la cantidad a concertir");
		System.out.print("\n>> ");
		double dinero = scan.nextInt();

		switch (conv){
			case 1:
				 dinero *= pdolares;
				 break;
			case 2:
				 dinero *= dolares;
				 break;
			case 3:
				 dinero *= peuros;
				 break;
			case 4:
				 dinero *= euros;
				 break;
			case 5:
				 dinero *= plibras;
				 break;
			case 6:
				 dinero *= libras;
				 break;
		}

		System.out.print("Dinero convertido >> "+dinero);
	}
}
