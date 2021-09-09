import java.util.*;

class b3_5 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		double pre, exa, ad;

		System.out.print("Para entrar a la universidad inserte sus promedios:\n(En forma decimal)");
		System.out.print("\nPreparatoria: ");
		pre = scan.nextDouble();
		System.out.print("Examen de Adminisón: ");
		exa = scan.nextDouble();

		// Pomedio
		ad = (exa + pre)/2;

		System.out.print(ad > 8.5 ? "Felicidades!!\n Admitido":"Lo siento...\n intenta en la proxima ronda");
	}
}
