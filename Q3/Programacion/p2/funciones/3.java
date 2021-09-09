import java.util.*;

class func3 {

	public static Scanner scan = new Scanner(System.in);

	static int num;

	public static void main(String[] args){
		// Dame unidades y precio

		System.out.print("Numero de articulos: ");
		num = scan.nextInt();

		
		// cobrar
		double total=0;
		// Sin parametro
		for(int i=0; i<num;i++){
			System.out.printf("\nArticulo %d: \n",i+1);
			total += cobrar();
		}
		System.out.printf("Su costo total es: $%6.2f %n", total);

		//Con parametro;
		total =0;
		double unit, price;
		for(int i=0; i<num;i++){
			System.out.printf("\nArticulo %d: \n",i+1);
			System.out.print("Unidades: ");
			unit = scan.nextDouble();
			System.out.print("Precio: ");
			price = scan.nextDouble();
			total += cobrar(unit,price);
		}
		System.out.printf("Su costo total es: $%6.2f %n", total);
	}
	static double cobrar(){
		double costo , unit=0, price=0;
		System.out.print("Unidades: ");
		unit = scan.nextDouble();
		System.out.print("Precio: ");
		price = scan.nextDouble();
		double dis = 1;
		if(unit > 12) dis = .9;
		else if (unit > 6) dis = .96;
		costo = dis * unit * price;
		return costo;
	}
	static double cobrar(double unit, double price){
		double dis = 1;
		if(unit > 12) dis = .9;
		else if (unit > 6) dis = .96;
		return unit * price * dis;
	}
}
