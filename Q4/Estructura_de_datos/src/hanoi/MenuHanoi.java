package hanoi;

import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHanoi implements ActionListener {

	private JFrame frame;
	public MenuHanoi(){

		frame = new JFrame();
		// técnico 
		frame.setTitle("TorresHanoi"); //Nombre de la ventana
		frame.setResizable(false); // tamaño fijo
		frame.setSize(500,500); // x y 
		frame.setLocationRelativeTo(null); //aparece en el centro del moitor
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina cuando cierre
		frame.getContentPane().setBackground(Main.CBASE); //hacerle un color base
		frame.setLayout(null);

		// ADD title
		JLabel title = new JLabel("<html>Torres<br>de<br>Hanoi<html>");
		title.setBorder(BorderFactory.createRaisedBevelBorder());
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setVerticalTextPosition(JLabel.TOP);
		title.setForeground(Color.WHITE);
		title.setFont(Main.FONT_BIG);
		title.setForeground(Color.WHITE);
		title.setIconTextGap(50);
		title.setBounds(150, 45, 200, 200);
		frame.add(title);

		// ADD Buttons
		// Incio
		JButton start = new JButton("Inicio");
		start.setActionCommand("start");
		start.setBounds(200,295,100,30);
		styleButton(start);
		frame.add(start);
		// Reglas
		JButton rules = new JButton("Reglas");
		rules.setActionCommand("rules");
		rules.setBounds(200,335,100,30);
		styleButton(rules);
		frame.add(rules);
		// Creditos
		JButton credits = new JButton("Creditos");
		credits.setActionCommand("credits");
		credits.setBounds(200,375,100,30);
		styleButton(credits);
		frame.add(credits);
		// Salir
		JButton end = new JButton("Salir");
		end.setActionCommand("end");
		end.setBounds(200,415,100,30);
		styleButton(end);
		frame.add(end);

		frame.setVisible(true);
	}

	private void styleButton(JButton button){
		button.addActionListener(this);
		Main.styleButton(button);
		button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
	}

	@Override
	public void actionPerformed(ActionEvent e){

		switch(e.getActionCommand()){
			case "start":
				new JuegoHanoi();
				frame.dispose();
				break;
			case "credits":
				JOptionPane.showMessageDialog(
						this.frame,
						"<html>"+
						"<style>*,body,html{text-align:center}</style>"+
						"<h1>Gracias!</h1><hr>"+
						"<p>Sos:Santiago Orozco S.<br>"+
						"Puedes encontrar mas en "+
						"<a>Github@Sosantiart117</a>"+
						"</p>"+
						"</html>");
				break;
			case "rules":
				JOptionPane.showMessageDialog(
						this.frame,
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
				break;
			case "end":
				frame.dispose();
				JOptionPane.showMessageDialog(
						null,
						"<html>"+
						"<style>*,body,html{text-align:center}</style>"+
						"<h2>Gracias por jugar:</h2><hr>"+
						"<p>Nos vemos pronto!</p>"+
						"</html>");
				System.exit(0);
				break;
		}
	}

}
