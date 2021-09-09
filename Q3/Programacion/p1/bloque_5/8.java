import java.util.*;

class b5_8 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// implementacon del algoritmo
		// fuente: https://cs.uwaterloo.ca/~alopez-o/math-faq/node73.html
		System.out.print("Dame una fecha en formato DD/MM/YYYY:\n>> ");
		String[] fecha = scan.next().split("/");
		int dia = Integer.parseInt(fecha[0]);
		int nMes = Integer.parseInt(fecha[1]);
		int año = Integer.parseInt(fecha[2]);

		String mes="";
		switch(nMes){
			case 1:
				mes="Enero";
				break;
			case 2:
				mes="Febrero";
				break;
			case 3:
				mes="Marzo";
				break;
			case 4:
				mes="Abril";
				break;
			case 5:
				mes="Mayo";
				break;
			case 6:
				mes="Junio";
				break;
			case 7:
				mes="Julio";
				break;
			case 8:
				mes="Agosto";
				break;
			case 9:
				mes="Septiembre";
				break;
			case 10:
				mes="Octubre";
				break;
			case 11:
				mes="Noviembre";
				break;
			case 12:
				mes="Diciembre";
				break;
		}
		int siglo = año/100;
		int nAño = año%100;
		//ajuste de meses para febrero
		if(nMes==1||nMes==2) nAño--;
		nMes-=2;
		switch(nMes){
			case 0: 
				nMes=12;
				break;
			case -1:
				nMes=11;
				break;
		}

		// calculo
		int fMes = (int)Math.floor(2.6*nMes-0.2);
		int fAño= (int)Math.floor(nAño/4);
		int fSiglo= (int)Math.floor(siglo/4);

		int nSemana = (dia + fMes - (2*siglo) + nAño + fAño + fSiglo)%7;

		String semana="";
		switch(nSemana){
			case 0:
				semana="Domingo";
				break;
			case 1:
				semana="Lunes";
				break;
			case 2:
				semana="Martes";
				break;
			case 3:
				semana="Miercoles";
				break;
			case 4:
				semana="Jueves";
				break;
			case 5:
				semana="Viernes";
				break;
			case 6:
				semana="Sábado";
				break;
		}

		System.out.printf("%nEl día %d de %s del %d es %s", dia,mes,año,semana);
	}
}
