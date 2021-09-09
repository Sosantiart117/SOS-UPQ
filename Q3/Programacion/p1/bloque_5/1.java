import java.util.*;
import java.util.concurrent.TimeUnit;

class b5_1 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		 // input 
		 System.out.print("Introudzca un tiempo en formato hh:mm:ss \n>> ");
		 String[] tiempo = scan.next().split(":");
		 int horas = Integer.parseInt(tiempo[0]);
		 int minutos = Integer.parseInt(tiempo[1]);
		 int segundos = Integer.parseInt(tiempo[2]);

		 int abs = (horas *3600) + (minutos * 60) + segundos;

		 int time;
		 for(int i = 1; i<=abs; i++){
			 time = abs - i;
			 horas = time/3600;
			 minutos = (time%3600)/60;
			 segundos = (time%3600)%60;
			 System.out.print("\nTiempo restante >> "+horas+":"+minutos+":"+segundos);
			 try {
				 TimeUnit.SECONDS.sleep(1);
			 } catch (InterruptedException e) {
         System.err.format("IOException: %s%n", e);
       }
		 }
	}
}
