package hanoi;

import javax.swing.AbstractButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

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

}
