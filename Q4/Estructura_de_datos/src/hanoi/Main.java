package hanoi;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;

public class Main{

	public static Color CBASE = new Color(0x5F5F5F);
	public static Font FONT_BIG = new Font("Arial",Font.BOLD,40);
	public static Font FONT_NORMAL = new Font("Arial",Font.BOLD,16);
	public static int WINSIZE = 80;
	public static String[] NTORRES = {"A","B","C"};

	public static void main(String[] args){
			// TorresHanoi.main(new String[0]);
			new MenuHanoi();
	}

	public static void styleButton(AbstractButton button){
		button.setFont(Main.FONT_NORMAL);
		button.setBackground(Main.CBASE);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
	}

	public static void styleLabel(JLabel etiqueta){
		etiqueta.setFocusable(false);
		etiqueta.setOpaque(true);
		etiqueta.setFont(Main.FONT_BIG);
		etiqueta.setBackground(Main.CBASE);
		etiqueta.setForeground(Color.WHITE);
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		etiqueta.setHorizontalTextPosition(JLabel.CENTER);
		etiqueta.setVerticalTextPosition(JLabel.CENTER);
	}

	public static void rules(JFrame parent){
		JOptionPane.showMessageDialog(
				parent,
				"<html>"+
				"<style>*,body,html{text-align:center}</style>"+
				"<h2>Reglas:</h2><hr>"+
				"<ul>"+
				"<li>Tienes que pasar todos los discos de A -> C</li>"+
				"<li><strong>Unicamente</strong>puedes mover "+
				"<strong>1</strong> disco a la vez</li>"+
				"<li>Un disco <strong>NUNCA</strong>"+
				" puede quedar sobre un disco mas pequeño</li>"+
				"<li>Solo puedes tomar el disco de arriba</li>"+
				"</ul>"+
				"</html>");
	}
	public static void credits(JFrame parent){
		JOptionPane.showMessageDialog(
				parent,
				"<html>"+
				"<style>*,body,html{text-align:center}</style>"+
				"<h1>Gracias!</h1><hr>"+
				"<p>Sos:Santiago Orozco S.<br>"+
				"Puedes encontrar mas en "+
				"<a>Github@Sosantiart117</a>"+
				"</p>"+
				"</html>");
	}
	public static void exit(){
		JOptionPane.showMessageDialog(
				null,
				"<html>"+
				"<style>*,body,html{text-align:center}</style>"+
				"<h2>Gracias por jugar:</h2><hr>"+
				"<p>Nos vemos pronto!</p>"+
				"</html>");
		System.exit(0);
	}
	public static int getDificulty(){
		String[] difs = {"Facil(3)   [default]", "Medio(5)","Dificl(7)"};
		Object dif = JOptionPane.showInputDialog(
				null,
				"Escoge Dificultad:",
				"Dificultades",
				JOptionPane.INFORMATION_MESSAGE,
				null,
				difs,
				difs[0]);
		if(dif == null) return 3;
		return (Arrays.asList(difs).indexOf(dif.toString())*2)+3;
	}

}
