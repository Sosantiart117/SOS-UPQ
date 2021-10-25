package rockola;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

	public static Color CBASE = new Color(0x5F5F5F);
	public static Font FONT_BIG = new Font("Arial",Font.BOLD,40);
	public static Font FONT_NORMAL = new Font("Arial",Font.BOLD,16);

	public MainMenu() {
    // Setframe
		this.setTitle("Rock-Ola"); //Nombre de la ventana
		this.setResizable(false); // tamaño fijo
		this.setSize(500,500); // x y 
		this.setLocationRelativeTo(null); //aparece en el centro del moitor
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina cuando cierre
		this.getContentPane().setBackground(MainMenu.CBASE); //hacerle un color base
		this.setLayout(null);
    // Title
		String style = "<style>"+
			".ola{color: #000; text-align: right}"+
			"</style>";
    JLabel title = new JLabel("<html>"+style+"<h1>Rock</h1><hr><h1 class=\"ola\">Ola</h1>");
		title.setBorder(BorderFactory.createRaisedBevelBorder());
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setVerticalTextPosition(JLabel.TOP);
		title.setForeground(Color.WHITE);
		title.setFont(FONT_BIG);
		title.setForeground(Color.WHITE);
		title.setIconTextGap(50);
		title.setBounds(150, 45, 200, 200);
    this.add(title);
		// Incio
		JButton rep = new JButton("Musica");
		rep.setActionCommand("rep");
		rep.setBounds(200,295,100,30);
		styleButton(rep);
		this.add(rep);
		// Reglas
		JButton bib = new JButton("Biblioteca");
		bib.setActionCommand("bib");
		bib.setBounds(200,335,100,30);
		this.styleButton(bib);
		this.add(bib);
		// Creditos
		JButton credits = new JButton("Creditos");
		credits.setActionCommand("cred");
		credits.setBounds(200,375,100,30);
		this.styleButton(credits);
		this.add(credits);
		// Salir
		JButton end = new JButton("Salir");
		end.setActionCommand("end");
		end.setBounds(200,415,100,30);
		this.styleButton(end);
		this.add(end);

		this.setVisible(true);
	}

	public static void styleButton(AbstractButton button){
		button.setFont(FONT_NORMAL);
		button.setBackground(CBASE);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
	}

	public static void styleLabel(JLabel etiqueta){
		etiqueta.setFocusable(false);
		etiqueta.setOpaque(true);
		etiqueta.setFont(FONT_BIG);
		etiqueta.setBackground(CBASE);
		etiqueta.setForeground(Color.WHITE);
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		etiqueta.setHorizontalTextPosition(JLabel.CENTER);
		etiqueta.setVerticalTextPosition(JLabel.CENTER);
	}
	private void styleButton(JButton button){
		button.addActionListener(this);
		MainMenu.styleButton((AbstractButton)button);
		button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "rep":
				new RepMenu();
				this.dispose();
				break;
			case "bib":
				new BibMenu();
				this.dispose();
				break;
			case "cred":
				JOptionPane.showMessageDialog(
						this,
						"<html>"+
						"<style>*,body,html{text-align:center}</style>"+
						"<h1>Gracias!</h1><hr>"+
						"<p>Sos:Santiago Orozco S.<br>"+
						"Puedes encontrar mas en "+
						"<a>Github@Sosantiart117</a>"+
						"</p>"+
						"</html>");
				break;
			case "end":
				this.dispose();
				JOptionPane.showMessageDialog(
						null,
						"<html>"+
						"<style>*,body,html{text-align:center}</style>"+
						"<h2>Gracias</h2><hr>"+
						"<p>Nos vemos pronto!</p>"+
						"</html>");
				System.exit(0);
				break;
		}
		
	}

}
