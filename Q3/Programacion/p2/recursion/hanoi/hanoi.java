// Creado por el poderosisimo SOS
// @Sosantiart117 Github

import java.util.*;

class Hanoi{
	public static Scanner scan = new Scanner(System.in);

	public static int lim;
	public static boolean slow=true;

	public static int[][] torres;
	public static String[] nTorres = {"A","B","C"};

	public static void main(String[] args){
		// slowmode
		if(args.length != 0)
			slow = false;
		// Dame un numero de discos
		System.out.print("Cuantos discos quieres usar para las torres de  hanoi\n>> ");
		lim = scan.nextInt();
		scan.nextLine();
		// numero de movimientos
		System.out.printf("El numero de movimientos será: %d%n", nMovs(lim));

		torres = new int[lim][3];
		start();
		show();
		hanoi(lim,0,1,2);
	}


// recursion
// Torres de hanoi
// Algoritmo para resolver el juego conocido como torres de hanoi

	public static void hanoi(int discos, int from, int aux, int to){
		// CASO BASE 
		// no puedes mover cero discos
		if(discos == 0) return;
		// mueve todos los discos a la 
		// posicion auxiliar antes de 
		// mover el ultimo disco
		hanoi(discos-1,from,to,aux);
		// mueve el ultimo disco
		move(from,to);
		// mueve todos los disco 
		// anteriores del auxiliar
		// a la nueva posicion
		hanoi(discos-1,aux,from,to);
		
	}


	public static void move(int from, int to){
		int disk=0;
		// agarro el disco
		for(int i=lim-1;i>=0;i--){
			if(torres[i][from] != 0){
				disk = torres[i][from];
				torres[i][from]= 0;
				break;
			}
		}
		// pongo el disco
		for(int i=lim-1;i>=0;i--){
			if(torres[i][to] != 0){
				torres[i+1][to] = disk;
				show(from, to);
				show();
				return;
			}
		}
		torres[0][to] = disk;
		show(from, to);
		show();
	}

// No mv

	public static int nMovs(int mvs){
		if(mvs == 1) return 1;
		return (2*nMovs(mvs-1)) +1;
	}
	
// presentacion
	public static void show(){

		for(int t = 0; t<3;  t++)
			printd(0);
		System.out.println();
		
		// toma la torre y muestra en que estado esta 
		// 3 torres
		for(int i = lim-1; i>=0;  i--){
			for(int t = 0; t<3;  t++){
				printd(torres[i][t]);
			}
			System.out.println();
		}
		
		for(int t = 0; t<3;  t++){
			// base espacios
			printc("-");
			// pilar
			System.out.print(nTorres[t]);
			// espacios
			printc("-");
			System.out.print(" ");
		}
		System.out.println();
		// Espero al usuario en modo slow
		if(slow) {
			System.out.print("< Enter para continuar >");
			scan.nextLine();
		}
	}

	public static void show(int from, int to){
		int spacer = 22;
		if(spacer < (lim*6)+5)
			spacer = (lim*6)+5;

		printc("#",spacer);
		System.out.println();
		printc(" ",(spacer-22)/2+1);
		System.out.printf("Mover disco de %s a %s", nTorres[from],nTorres[to]);
		System.out.println();
		printc("#",spacer);
		System.out.println();
	}
	public static void show(String msg){
		int spacer = 23;
		if(spacer < (lim*6)+5)
			spacer = (lim*6)+5;

		printc("#",spacer);
		System.out.println();
		printc(" ",(spacer-22)/2);
		System.out.print(msg);
		System.out.println();
		printc("#",spacer);
		System.out.println();
	}

	public static void printc(String spa){
		printc(spa, lim);
	}

	public static void printc(String spa,int times){
		for(int i = 0; i<times; i++ ){
			System.out.print(spa);
		}
	}

	public static void printd(int disk){
		int wSpace = lim - disk;
		printc(" ",wSpace);
		printc("*",disk);
		System.out.print("|");
		printc("*",disk);
		printc(" ",wSpace+1);
	}

	public static void start(){
		show("Estado Inicial");
		for(int i = 0; i<lim;  i++){
			torres[i][0]=lim-i;
		}
	}
}

