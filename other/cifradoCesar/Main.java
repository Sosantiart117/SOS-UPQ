import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);

	// Cesar de 5
	public static int cifer = 5;

	private static File inputFile;
	private static File outputFile;

	private static String fileName;

	private static String input;
	private static String output;

	private static boolean isDeCifered = false;
	private static boolean isCifered = false;

	public static void main(String[] args) {
		try {
			int op = args.length;
			if (op == 0)
				throw new Exception("No input....");
			input = readFile(args[0]);
			op = menu();
			switch (op) {
				case 1:
					output = cifer(input);
					break;
				case 2:
					output = deCifer(input);
					break;
			}
			System.out.print("Salida:\n\t> "+ output);
			System.out.println("\nGuardando..\n");
			save();
			System.out.println("Adios..");
		} catch (Exception e) {
			System.out.print("Mamo:\n\t" + e.getMessage());
		}
	}

	private static void save() throws IOException {
		String prefix = "";
		if (isCifered)
			prefix = "cif.";
		if (isDeCifered)
			prefix = "decif.";
		outputFile = new File(prefix + fileName);
		FileWriter outputWriter = new FileWriter(outputFile);
		outputWriter.write(output);
		outputWriter.close();
	}

	private static String cifer(String msg) {
		isCifered = true;
		String out = "";
		for (int i = 0; i < msg.length(); i++) {
			char letter = msg.charAt(i);
			letter = (char) (((int) letter) + cifer);
			out += letter;
		}
		return out;
	}

	private static String deCifer(String msg) {
		isDeCifered = true;
		String out = "";
		for (int i = 0; i < msg.length(); i++) {
			char letter = msg.charAt(i);
			letter = (char) (((int) letter) - cifer);
			out += letter;
		}
		return out;
	}

	private static int menu() {
		System.out.print("MENU:\n" + "1.- Cifer \n" + "2.- deCifer\n" + "* Salir\n" + "\n> ");
		return scan.nextInt();
	}

	private static String readFile(String fName) throws FileNotFoundException {
			input = "";
		fileName = fName;
		inputFile = new File(fName);
		Scanner scanFile = new Scanner(inputFile);
		while (scanFile.hasNextLine()){
			input += scanFile.nextLine();
		System.out.println(input);
		}
		scanFile.close();
		return input;
	}

}
