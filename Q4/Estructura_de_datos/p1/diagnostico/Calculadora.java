import java.util.Scanner;
import java.util.Arrays;

// @author 
// Santiago Orozco (Sos)

public class Calculadora {

	private static Scanner IN = new Scanner(System.in);
	private static int NOPS = 5;
	private static int[] ARR1 = new int[NOPS];// 1 = primer numero
	private static int[] ARR2 = new int[NOPS];// 2 = operacion
	private static int[] ARR3 = new int[NOPS];// 3 = segundo numero
	private static int[] ARR4 = new int[NOPS];// 4 = resultado
	
	private static String[] OPS = {"+","-","*","/"};

	public static void main(String[] args){

		// saludar es importante
		System.out.println(
				"Bienvenido a la calculadora de diagnostico\n"+
				"Para este te requermios Numero operacion y otro numero\n"+
				"( Division si resuido )");
		for(int i = 0; i < NOPS; i++){
		// get
			// Vuelta
			System.out.printf("Operacion No.%d:\n",i);
			ARR1[i] = getNum();
			ARR2[i] = getOp();
			ARR3[i] = getNum();
			ARR4[i] = doOp(ARR2[i], ARR1[i], ARR3[i]);
			System.out.println();
		}
		// show
		for(int i = 0; i < NOPS; i++){
			// show
			System.out.printf(
					"No%d:\t %3d %s %3d = %3d\n",
					i,
					ARR1[i],
					OPS[ARR2[i]],
					ARR3[i],
					ARR4[i]
				);
		}
	}
	// gets
	private static int getNum(){
		System.out.printf("Dame un numero\t\t\t:");
		int num = IN.nextInt();
		return num;
	}
	private static int getOp(){
		System.out.printf("Dame una operacion (+,-,*,/)\t:");
		String op = IN.next();
		return Arrays.asList(OPS).indexOf(op);
	}
	// operaciones
	private static int doOp(int op, int num1, int num2){
		switch (op){
			case 0: // suma
				return num1 + num2;
			case 1: // resta
				return num1 - num2;
			case 2: // producto
				return num1 * num2;
			case 3: // div
				return num1 / num2;
			default:
				return 0;
		}
	}
} 
