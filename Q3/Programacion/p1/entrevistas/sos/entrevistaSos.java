import java.util.Scanner;

class entrevistaSos {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("BIenvenido a la entrevista de Sos;\nSolo seran unas pocas preguntas:\n");

		System.out.println("¿Nombre o como te gusta que te digan?");
		String nombre = scan.nextLine();

		System.out.println("¿Alguna serie que me recomiendes?");
		String serie = scan.nextLine();

		System.out.println("¿Comida favorita?");
		String comida = scan.nextLine();

		System.out.println("¿Artista favorito?");
		String artista = scan.nextLine();

		System.out.println("¿Un lugar al que llevarías alguien que no es de Qrto.?");
		String lugar = scan.nextLine();

		System.out.println(nombre + " espero conocerte pronto, en precencial me refiero, para poder ir a "+lugar+" que sabes que soy nuevo acá.");
		System.out.println("Tambien me gustaría ir por " + comida + " y esuchar " + artista);
		System.out.println("Mientras, te hare caso y veré " + serie + "\n\nEn fin. Gracias por responder mi cuetionario");
	}
}
