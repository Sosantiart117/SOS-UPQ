import java.util.*;

class salario {
	public static Scanner scan = new Scanner(System.in);
	//
	// VARS
	// Se toma el mes de 30 días
	static int mes = 30;
	static int horario = 8;
	// 15 días de aguinaldo 
	static double diasAguinaldo = 15;
	// Porcentaje de Prima vacacional 25%
	static double pPrimaVa = .25;
	static double diasLaborados = 365;
	static double smgv = 123.22;

	public static void main(String[] args){


		// inicio

		System.out.print("Este programa calcula el monto a pagar a un trabajador:\n");

		// INPUT
		
		// Salario diario 
		System.out.print("Introduzca su monto de salario diario:\n>> ");
		double diario = scan.nextDouble();
		
		// horas extras
		System.out.print("Introduzca cuantas horas extas:\n(Poner 0 si no hay)\n>> ");
		double extras = scan.nextDouble();

		// adicionales mensuales
		System.out.print("Introduzca prestaciones adicionales:\n>> ");
		double adicionales = scan.nextDouble();

		// Prima Vacional
		// fuente: https://www.occ.com.mx/blog/calcular-prima-vacacional-que-es/
		System.out.print("Introduzca años de servicio:\n(Poner 0 en caso de ser menor a 1)\n>> ");
		int servicio = scan.nextInt();
		if(servicio < 1){
			System.out.print("Introduzca cuantos días laboraria este año:\n>> ");
			diasLaborados = scan.nextDouble();
		}

		// Retrasos
		// fuente: https://laverdadnoticias.com/economia/Ley-Federal-del-Trabajo-Descuentos-de-salario-por-retrasos-20200920-0184.html
		System.out.print("Introduzca el monto de retrasos:\n(teniendo en cuenta que 4 retrasos generan un descuento de medio día)\n>> ");
		int retrasos = scan.nextInt();

		// Faltas
		System.out.print("Introduzca días que falto:\n>> ");
		int faltas = scan.nextInt();

		// OPS

		//prima vacacional
		double primaVacacional = 0;
		int d = 0;
		if(servicio > 24) d = 22;
		else if (servicio > 19) d = 20;
		else if (servicio > 14) d = 18;
		else if (servicio > 9) d = 16;
		else if (servicio > 4) d = 14;
		else if (servicio == 4) d = 12;
		else if (servicio == 3) d = 10;
		else if (servicio == 2) d = 8;
		else if (servicio == 1) d = 6;
		
		primaVacacional = (d * pPrimaVa);
		double fprimaVacacional = primaVacacional/365;
		primaVacacional *= diario;

		//aguinaldo 
		double faguinaldo = diasAguinaldo / 365; 
		double aguinaldo = (faguinaldo * diasLaborados)*diario;

		// horas extras
		// fuente: https://laverdadnoticias.com/politica/Ley-Federal-del-Trabajo-Horas-extras-y-como-se-pagan-20200821-0203.html
		double hora = diario / horario;
 		extras *= hora;
		if (extras > 9) extras *= 2;

		//salario
		//fuente: https://snogari.com/index.php/tutoriales-manuales/imss/item/979-salario-base-de-cotizacion-y-factor-de-integracion
		double salario = diario * mes;
		salario += extras + adicionales;
		// salario base de cotizacion
		double fi = faguinaldo + fprimaVacacional;
		double sbc = (diario * ++fi) + (adicionales/30);

		// retrasos y faltas
		// faltas
		double descuentos;
		 descuentos = faltas * diario;
		// retrasos
		descuentos += (retrasos/4)*(.5*diario);

		// Impuestos
		// ISR
		// Teniendo en cuenta retencion mensual y el ejercicio 2021
		// fuentes: https://www.elcontribuyente.mx/2021/01/tablas-isr-2021/#reteperiodicas5
		// fuentes: https://www.milenio.com/negocios/finanzas-personales/isr-que-es-cuando-aplica-y-como-se-calcula
		double fijo=0, pExedente=.0192, lInf=0;
		if(salario > 324845.02 ){
			lInf=324845.02;
			fijo = 101876.9;
			pExedente = .35;
		}else if ( salario > 198281.68 ){
			lInf=198281.68;
			fijo = 28245.36;
			pExedente = .34;
		}else if ( salario > 81211.26 ){
			lInf= 81211.26 ;
			fijo = 19582.83;
			pExedente = .32;
		}else if ( salario > 42537.59 ){
			lInf= 42537.59 ;
			fijo = 7980.73;
			pExedente = .30;
		}else if ( salario > 26988.51 ){
			lInf= 26988.51 ;
			fijo = 4323.58;
			pExedente = 23.52;
		}else if ( salario > 13381.48 ){
			lInf= 13381.48 ;
			fijo = 1417.12;
			pExedente = .2136;
		}else if ( salario > 11176.63 ){
			lInf= 11176.63 ;
			fijo = 1022.01;
			pExedente = .1792;
		}else if ( salario > 9614.67 ){
			lInf= 9614.67 ;
			fijo = 772.1;
			pExedente = .16;
		}else if ( salario > 5470.93 ){
			lInf= 5470.93 ;
			fijo = 321.26;
			pExedente = .1088;
		}else if ( salario > 644.59 ){
			lInf= 644.59 ;
			fijo = 12.38;
			pExedente = .064;
		}
		double isr = ((salario - lInf)*pExedente) + fijo;

		// IMSS
		double imss=0;
		// Fuente: https://www.toptrabajos.com/blog/mx/descuentos-al-salario/
		// excedente de 3SMGV
		if(sbc > (3*smgv)) imss += (sbc - (3*smgv))*.004;
		// gastos médicos
		imss += sbc * .00375;
		// Prestaciones en dinero
		imss += sbc * .0025;
		// invalidez y vida
		imss += sbc * .00625;
		// Edad avanzada y vejes (la mitad porque es pago bimestral)
		imss += (sbc * .01125)/2;
		// ajuste mensual
		imss *= mes;

		// Final
		double total = salario - isr - imss - descuentos;
		
		// OUTPUT

		System.out.println("Después de la mágia del dinero, la matemática y el gobierno.\nSu salarío será: "+total+" pesos mensuales");
		System.out.println("Tu aguinaldo será: "+aguinaldo+"\nTu prima Vacional es: "+ primaVacacional);
		// joder cuanto te quitan...
	}
}
