package primerParcial;

import javax.swing.JOptionPane;

/** esta es la descripcion 
 * @author Santiago Orozco (Sosantiart11@github)
 * @company UPQ
 * @date 20 septiembre 2021
 * Ejericio para hacer un programa que con una 
 * base de datos estatica le de precio de compra
 * y listado 
 *
 */

public class CajaRegistradora {

	// "Base de datos" 
	private String NOMBRE = "Electronicos MR.ROBOT";
	private String[] CATALOGO = {
		"Teclado Generico",
		"Teclado Gamer",
		"Mouse Generico",
		"Mouse Gamer",
		"Monitor Generico",
		"Montior Color Verdadero",
		"Monitor Gamer"
	};
	private double[] PRECIOS = {
		398.99,
		1649.99,
		249.49,
		1249.99,
		4098.99,
		10128.99,
		9129.99
	};
	private int[] INVENTARIO = { 5,7,1,6,3,1,5 };
	private String STYLE = "<style>"+
		"table{width:100%;text-align:center;}"+
		"td{text-align:center}"+
		" .articulo{text-align:left;width:50%;padding-left:10px;}"+
		" .precio{text-align: right;width: 20%;}"+
		" .precio span{float:left;}"+
		"</style>";

	// variables 
	private double[] TOTALES ;
	private int[] CARRITO;
	private boolean PAGADO = false;
	

	public CajaRegistradora(){
		// inicializar en 0 arreglos vacios
		TOTALES = new double[CATALOGO.length];
		CARRITO = new int[CATALOGO.length];
	}


	public void Menu(){
		// Entry Point
		String menu = 
			"<html>"+STYLE+
			"<h1>Bienvenido a "+NOMBRE+"</h1>"+
			"<hr><ol>"+
			"<li>Comprar</li>"+
			"<li>Pagar</li>"+
			"<li>Salir</li>"+
			"</ol></html>";
		while(true){
			String input = JOptionPane.showInputDialog(menu);
			try{
				switch(Integer.parseInt(input)){
					case 1:
						Comprar();
						break;
					case 2:
						Pagar();
						if(PAGADO) return;
						continue;
					case 3:
						JOptionPane.showMessageDialog(
								null,
								"<html><h1>Gracias por comprar en "+
								NOMBRE+
								"</h1><h2>Vuevla Pronto!</h2></html>",
								"Gracias!",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					default:
						JOptionPane.showMessageDialog(
								null,
								"Introduzca una opcion valida",
								"ERROR",
								JOptionPane.ERROR_MESSAGE);
						continue;
				}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(
						null, 
						"<html><h1>Opcion invalida</h1>",
						"ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void Comprar(){
		boolean correct = false;
		String input = "";
		int articulo = 0;
		while(true){
			String ofrecimiento =
				"<html>"+STYLE+
				"<h2>Catalogo:</h2><hr>"+
				"<table>"+
				"<tr>"+
				"<th> # </th>"+
				"<th>Articulo</th>"+
				"<th>Cantidad</th>"+
				"<th>Precio</th>"+
				"</tr>";

			for(int i = 0; i< CATALOGO.length;i++)
				ofrecimiento +=
					"<tr>"+
					"<td>"+(i+1)+"</tb>"+
					"<td class=\"articulo\">"+CATALOGO[i]+"</tb>"+
					"<td class=\"cantidad\">"+Integer.toString(INVENTARIO[i])+"</tb>"+
					"<td class=\"precio\"><span>$</span>"+Double.toString(PRECIOS[i])+"</td>"+
					"</tr>";

			ofrecimiento += 
				"</table>"+
				"<hr><p>¿Que Articulo Deseas Comprar?"+
				"(# de articulo o 0 para volver al menu)</p>"+
				"</html>";

			input = JOptionPane.showInputDialog( 
					null, ofrecimiento, NOMBRE, JOptionPane.PLAIN_MESSAGE);
			
			try{
				articulo = Integer.parseInt(input);
				correct = articulo > 0 && articulo < CATALOGO.length;
				if(articulo == 0) return;
				articulo--;
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(
						null, 
						"<html><h1>Opcion invalida</h1>"+
						"<h2>usar NUMERO de producto</h2></html>",
						"ERROR",
						JOptionPane.ERROR_MESSAGE);
				continue;
			} 

			if(!correct){
				JOptionPane.showMessageDialog(
						null,
						"<html><h1>404: Articulo no Encontrado</h1></html>",
						"ERROR",
						JOptionPane.ERROR_MESSAGE);
				continue;
			}
			if(INVENTARIO[articulo] == 0 && CARRITO[articulo] == 0){
				JOptionPane.showMessageDialog(
						null,
						"<html><h1>Articulo agotado</h1>"+
						"<h2>Entendemos la molestia pero por el momento"+
						"no tenemos ese articulo </h2>"+
						"<p> regresando al catalogo...</p></html>",
						"NO HAY :c",
						JOptionPane.WARNING_MESSAGE);
				continue;
			}else if(INVENTARIO[articulo] == 0 && !(CARRITO[articulo] == 0)){
				JOptionPane.showMessageDialog(
						null,
						"<html><h1>No nos quedan mas</h1><h2>Lo sentimos...</h2>",
						"NO QUEDA MAS...",
						JOptionPane.WARNING_MESSAGE);
				continue;
			}
			AgregarArticulo(articulo);
		}
	}

	public void AgregarArticulo(int articulo){
		// pedir cantidad
		String cantidad = "";
		String mensaje = 
				"<html>"+STYLE+
				"<h2>¿Cuantos desea agregar?(0 para cancelar):</h2><hr>"+
				"<table>"+
				"<tr>"+
					"<th>Articulo</th>"+
					"<th>Cantidad</th>"+
					"<th>Precio</th><"+
				"/tr>"+
					"<tr>"+
					"<td>"+CATALOGO[articulo]+"</tb>"+
					"<td>"+Integer.toString(INVENTARIO[articulo])+"</tb>"+
					"<td>$"+Double.toString(PRECIOS[articulo])+"</td><"+
					"/tr>"+
				"</table>"+
				"</html>";
	
		while(true){
			cantidad = JOptionPane.showInputDialog(mensaje);
			try{
				int piezas = Integer.parseInt(cantidad);
				if(piezas < 0 || piezas > INVENTARIO[articulo]) 
					throw new Exception();
				else if (piezas == 0) return;
				CARRITO[articulo] += piezas;
				INVENTARIO[articulo]-= piezas;
				TOTALES[articulo] = CARRITO[articulo] * PRECIOS[articulo];
				JOptionPane.showMessageDialog( 
					null, 
					"<html><h1>Agregado al carrito exitosamente</h1>",
					"EXITO",
					JOptionPane.INFORMATION_MESSAGE);
				return;
			}catch (NumberFormatException e){
				JOptionPane.showMessageDialog( 
					null, 
					"<html><h1>Opcion invalida</h1>",
					"ERROR",
					JOptionPane.ERROR_MESSAGE);
			}catch(Exception e){
				JOptionPane.showMessageDialog( 
					null, 
					"<html><h1>Numero invalido</h1>",
					"ERROR",
					JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void Pagar(){
		if(isCarritoEmpty()){
				JOptionPane.showMessageDialog( 
					null, 
					"<html><h1>Compre algo antes de ir a pagar...</h1>",
					"CARRITO VACIO",
					JOptionPane.WARNING_MESSAGE);
				return;
		}

		String ticket =
			"<html>"+ STYLE +
			"<h2>"+NOMBRE+":</h2><hr>"+
			"<table>"+
			"<tr>"+
			"<th> # </th>"+
			"<th>Producto</th>"+
			"<th>Cantidad</th>"+
			"<th>Precio Unitario</th>"+
			"<th>Subtotal</th>"+
			"</tr>";

		int e = 0;
		double total = 0;
		for(int i = 0; i< CARRITO.length;i++){
			if(CARRITO[i] == 0) continue;
			ticket +=
				"<tr>"+
				"<td>"+(++e)+"</tb>"+
				"<td class=\"articulo\">"+CATALOGO[i]+"</tb>"+
				"<td class=\"cantidad\">"+Integer.toString(CARRITO[i])+"</tb>"+
				"<td class=\"precio\"><span>$</span>"+Double.toString(PRECIOS[i])+"</td>"+
				"<td class=\"precio\"><span>$</span>"+Double.toString(TOTALES[i])+"</td>"+
				"</tr>";
			total+=TOTALES[i];
		}

		ticket += 
			"</table><hr>"+
			"<h2>TOTAL: $"+total+"</h2>"+
			"</html>";

		JOptionPane.showMessageDialog( 
			null, 
			ticket,
			"Ticket",
			JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog( 
			null, 
			"<html><h1>Gracias por su compra</h1><h2>Vuelva Pronto</h2>",
			"GRACIAS POR SU COMPRA",
			JOptionPane.INFORMATION_MESSAGE);
		PAGADO = true;
	}

	public boolean isCarritoEmpty(){
		for(int i = 0; i<CARRITO.length;i++)
			if(CARRITO[i] != 0) return false;
		return true;
	}

}
