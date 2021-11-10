package atm;

import java.io.Serializable;

public class Move implements Serializable{

	final private String Tipo;
	final private String Lugar;
	final private float Cantidad;

	public Move(String tipo, String lugar, float cantidad) {
		Tipo = tipo;
		Lugar = lugar;
		Cantidad = cantidad;
	}
	
 public String getTipo() {
		return Tipo;
	}
	public String getLugar() {
		return Lugar;
	}
	public float getCantidad() {
		return Cantidad;
	}

}
