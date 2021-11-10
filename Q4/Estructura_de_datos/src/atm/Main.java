package atm;

import java.awt.Font;
import java.text.DecimalFormat;
import java.awt.Color;

public class Main {


  public static final DecimalFormat df = new DecimalFormat("0.00");
	public static Color Cbase = new Color(0x5F5F5F);
	public static Color Cmain = new Color(0xCACACA);
	public static Font FontBig = new Font("Arial",Font.BOLD,40);
	public static Font FontNormal = new Font("Arial",Font.BOLD,16);

	public static void main(String[] arg){
		new Atm();
	}
}
