import java.util.*;

class zodiaco {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		System.out.print("Dame du cumpleaños!\nDia: ");
		int dia = scan.nextInt();
		System.out.print("Mes: ");
		int mes = scan.nextInt();


		if((dia>31||dia<1)||(mes>12||mes<1)){
			System.out.println("Eso no es una fecha en la tierra");
			System.exit(1);
		}
		//zodiacos		
		//
		// desfase por dia:
		switch (mes){
			case 3:
			case 5:
			case 6:
				if(dia > 21) mes++;
				break;
			case 7:
			case 8:
			case 9:
			case 10:
				if(dia > 23) mes++;
				break;
			case 1:
			case 4:
				if(dia > 20) mes++;
				break;
			case 11:
			case 12:
				if(dia > 22) mes++;
				break;
			case 2:
				if(dia > 19) mes++;
				break;
		}
		if(mes > 12) mes = 0;

		//con arreglo
		// String[] zod = {
		// 	"Capricornio",
		// 	"Acuario",
		// 	"Piscis",
		// 	"Aries",
		// 	"Tauro",
		// 	"Géminis",
		// 	"Cáncer",
		// 	"Leo",
		// 	"Virgo",
		// 	"Libra",
		// 	"Escorpio",
		// 	"Sagitario"
		// };
		// System.out.print("\nTu signo es " + zod[mes]);

		//sin arreglo
		String zod = "";
		mes--;
		switch (mes){
			case 0:
				zod = "Capricornio";
				break;
			case 1:
				zod = "Acuario";
				break;
			case 2:
				zod = "Piscis";
				break;
			case 3:
				zod = "Aries";
				break;
			case 4:
				zod = "Tauro";
				break;
			case 5:
				zod = "Géminis";
				break;
			case 6:
				zod = "Cáncer";
				break;
			case 7:
				zod = "Leo";
				break;
			case 8:
				zod = "Virgo";
				break;
			case 9:
				zod = "Libra";
				break;
			case 10:
				zod = "Escorpio";
				break;
			case 11:
				zod = "Sagitario";
				break;
		}
		System.out.print("\nTu signo es " + zod);
	}
}
