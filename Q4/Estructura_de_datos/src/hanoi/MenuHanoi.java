package hanoi;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
				new JuegoHanoi(Main.getDificulty());
				frame.dispose();
				break;
			case "credits":
				Main.credits(this.frame);
				break;
			case "rules":
				Main.rules(this.frame);
				break;
			case "end":
				frame.dispose();
				Main.exit();
				break;
		}
	}

}
