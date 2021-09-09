import java.util.*;

class b4_2 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){

		System.out.print("Dame tu fecha de nacimiento!\nAño: ");
		int año = scan.nextInt();
		System.out.print("Mes: ");
		int mes = scan.nextInt();

		// calculo
		// No se tiene en cuenta el año lunar o el desface por el calendario gregoriano 
		// por lo que el "año chino" cambia en febrero

		int sig = año % 12;
		int el = año % 10;

		//ajuste de meses
		switch(mes){
			case 1:
			case 2:
				--sig;
				--el;
				break;
		}

		String signo="", elemento="";
		// signo 
		switch (sig){
			case 0:
				signo = "Mono";
				break;
			case 1:
				signo = "Gallo";
				break;
			case 2:
				signo = "Perro";
				break;
			case 3:
				signo = "Cerdo";
				break;
			case 4:
				signo = "Rata";
				break;
			case 5:
				signo = "Buey";
				break;
			case 6:
				signo = "Tigre";
				break;
			case 7:
				signo = "Conejo";
				break;
			case 8:
				signo = "Dragón";
				break;
			case 9:
				signo = "Serpiente";
				break;
			case 10:
				signo = "Caballo";
				break;
			case 11:
				signo = "Cabra";
				break;
		}
		// Elemento
		switch(el){
			case 0: 
			case 1:
				elemento="Metal";
				break;
			case 2: 
			case 3:
				elemento="Agua";
				break;
			case 4:
			case 5:
				elemento="Madera";
				break;
			case 6:
			case 7:
				elemento="Fuego";
				break;
			case 8:
			case 9:
				elemento="Tierra";
				break;
		}

		System.out.print("Tu Horoscopo Chino es: "+signo+" "+elemento);

	}
}
