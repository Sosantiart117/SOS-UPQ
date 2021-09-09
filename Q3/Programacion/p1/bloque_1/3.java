import java.util.*;
import java.lang.Math;

class Geometria{
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		System.out.print("Cuantos lados tiene la figura\n(0 para un circulo):");
		int nLados = scan.nextInt();
		
		Figura fig = new Figura();
		switch(nLados){
			case 0: 
				fig = new Circulo();
				break;			
			case 3: 
				fig = new Triangulo();
				break;			
			case 4: 
				fig = new Cuadrilatero();
				break;			
			default: 
				System.out.println("No se hacer esa figura");
				System.exit(0);
				break;
		}
		System.out.print("\nTu figura es un " + fig.name +"\nSu perimetro es:\t"+fig.perimetro+"\ny su area es:\t\t"+fig.area);

		System.out.println("\nGracias por usar el pograma de Sos");
	}
}


class Figura {
	public float base, altura, perimetro, area;
	public float[] lados;
	public String name;
		Figura(){
			this.base = 0;
			this.altura = 0;
		};

	//Obtener los lados;
	protected static float[] getLados(int n){
		float[] lados = new float[n];
		for(int i=0; i<n;i++){
			System.out.print("\nLado"+(n==1?"":" "+(i+1))+":");
			lados[i] = scan.nextFloat();
		}
		return lados;
	}
	
	// Perimetro
	protected float perimetro(float[] lados){
		float per = 0;
		for(int i = 0; i < lados.length; i++){
			per+=lados[i];
		}
		return per;
	}

	// Area
	protected float area(float lado1, float lado2) {
		return lado1 *lado2;
	};
	//scanner para figuras
	public static Scanner scan = new Scanner(System.in);
}

class Circulo extends Figura {
	
	public float circumferencia,radio;

	Circulo(){
		this.name ="Circulo";
		this.radio = getRadio();
		this.perimetro = (float) circumferencia(radio);
		this.area = super.area( (float) Math.PI, radio*radio);
	}
	//geter para Radio
	private float getRadio(){
		System.out.print("\n¿Cual es el radio de tu circulo?:");
		return scan.nextFloat();
	}
	//metodo para la circumferencia
	private double circumferencia(float radio ){
		return ( radio * 2 ) * Math.PI;
	};
}


class Triangulo extends Figura {

	private int tipo;

	Triangulo(){
		super();
		tipoTriangulo();
		this.perimetro = perimetro(this.lados);
		perimetro();
		this.base = lados[0];
		this.area = area();
	}

	private void tipoTriangulo(){
		System.out.print("\n¿Cuantos lados distintos tiene el triangulo (0-2)?:");
		// tipo 0 1	2
		// Equilatero, Isoceles, Escaleno, respectivamente
		this.tipo=scan.nextInt();
		if(this.tipo == 1) System.out.print("\n(Empezar por el lado que no se repite)\n");
		else if(this.tipo == 2) System.out.print("\n(En orden ascendente)\n");
		this.lados = getLados(1+this.tipo);
	}

	private void perimetro(){
		switch(this.tipo){
			case 0: 
				this.name = "Triangulo Equilatero";
				this.perimetro = this.perimetro *3;
				break;
			case 1: 
				this.name = "Triangulo Isoceles";
				this.perimetro = this.perimetro + lados[0];
				break;
			case 2:
				this.name = "Triangulo Escaleno";
				break;
		}
	}

	private float area(){
		float aux;
		switch(this.tipo){
			case 0: 
			case 1: 
				aux = this.base/2;
				this.altura = (float) Math.sqrt((this.base*this.base)-(aux*aux));
				area = (aux*this.altura);
				break;
			case 2:
				this.altura = this.lados[1];
				area = (this.altura*this.base)/2;
				break;
		}
		return area;
	}
}

class Cuadrilatero extends Figura {

	public boolean esCuadrado;

	Cuadrilatero(){
		super();
		esCuadrado = esCuadrado();
		this.name = esCuadrado ? "Cuadrado":"Cuadrilatero";
		lados = getLados(esCuadrado?1:2);
		this.base = lados[0];
		this.altura = lados[esCuadrado?0:1];
		this.perimetro = esCuadrado ? this.base *4 : perimetro(this.base,this.altura);
		this.area = area(this.base,this.altura);
	}

	private boolean esCuadrado(){
		System.out.print("\n¿Es un cuadrado?(s/N)\n>> ");
		String x = scan.next();
		return x.equalsIgnoreCase("s");
	}
	// Metodo para el perimetro de los cuadrilateros
	private float perimetro(float lado1, float lado2) {
		return (2*lado1)+(2*lado2);
	}
}
