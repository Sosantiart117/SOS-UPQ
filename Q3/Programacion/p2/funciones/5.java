import java.util.*;

class func5 {

	public static Scanner scan = new Scanner(System.in);

	static int lim = 999;

	public static void main(String[] args){

		//  Convierte a romano

		int num;
		do{
			System.out.printf("Dame un numero del 0 al %d: ",lim);
			num = scan.nextInt();
		}while(num<0||num>lim);

		// llamar diasMesion
		// Sin Parametro
		aRomano();
		// Parametro
		aRomano(num);
	}

	static void aRomano(){
		// escogemos el numero 117
		//
		int num = 117;
		int org = num;
		String romano="";
		do{
			if(num >= 1000){
				romano += "M";
				num-=1000;
			} else if(num >= 900){
				romano += "CM";
				num-=900;
			} else if(num>=500){
				romano += "D";
				num-=500;
			} else if(num>=400){
				romano += "CD";
				num-=400;
			} else if(num>=100){
				romano += "C";
				num-=100;
			} else if(num>=90){
				romano += "XC";
				num-=90;
			} else if(num>=50){
				romano += "L";
				num-=50;
			} else if(num>=40){
				romano += "XL";
				num-=40;
			} else if(num>=10){
				romano += "X";
				num-=10;
			} else if(num>=9){
				romano += "IX";
				num-=9;
			} else if(num>=5){
				romano += "V";
				num-=5;
			} else if(num>=4){
				romano += "IV";
				num-=4;
			} else if(num>=1){
				romano += "I";
				num-=1;
			}
			// System.out.printf("\nDEBUG num: %3d; rom: %s", num,romano);
		}while(num>0);
		System.out.printf("\nEl numero %d es %s en Romano", org, romano);
	}

	static String[] numerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	static int[] nNumerals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	static void aRomano(int num){
		int org = num;
		String romano="";
		do{
			for(int i=0; i<numerals.length;i++){
				if(num >= nNumerals[i]){
					romano += numerals[i];
					num -= nNumerals[i];
					break;
				}
			}
			// System.out.printf("\nDEBUG num: %3d; rom: %s", num,romano);
		}while(num>0);
		System.out.printf("\nEl numero %d es %s en Romano", org, romano);
	}

}

