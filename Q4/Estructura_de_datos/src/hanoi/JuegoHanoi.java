package hanoi;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoHanoi extends JFrame implements ActionListener{

	private int WINSIZE = 80;

	public JuegoHanoi(){
		this.setTitle("TorresHanoi"); //Nombre de la ventana
		this.setSize(WINSIZE*16,WINSIZE*10); // x y 
		this.setLocationRelativeTo(null); //aparece en el centro del moitor
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Termina cuando cierre
		this.getContentPane().setBackground(Main.CBASE); //hacerle un color base
		this.setLayout(new BorderLayout(10,0));

		this.add(new PanelJuego(this),BorderLayout.CENTER);
		this.add(new PanelOpciones(this), BorderLayout.WEST);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){

	}

}
