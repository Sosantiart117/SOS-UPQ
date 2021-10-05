package hanoi;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoHanoi extends JFrame implements ActionListener{

	public static TorresHanoi HANOI;

	private int WINSIZE;

	private boolean PRESSED;
	private int LASTID;

	public JuegoHanoi(){
		this(7);
	}

	public JuegoHanoi(int lvl){
		this.WINSIZE = Main.WINSIZE;
		HANOI = new TorresHanoi(lvl);
		this.setTitle("TorresHanoi"); //Nombre de la ventana
		this.setSize(WINSIZE*16,WINSIZE*9); // x y 
		this.setLocationRelativeTo(null); //aparece en el centro del moitor
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Termina cuando cierre
		this.getContentPane().setBackground(Main.CBASE); //hacerle un color base
		this.setLayout(new BorderLayout(10,0));


		this.add(new PanelJuego(this),BorderLayout.CENTER);
		this.add(new PanelOpciones(this), BorderLayout.WEST);

		this.PRESSED = false;

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		switch(e.getActionCommand()){
			case"move":
				TorreButton torre = (TorreButton) e.getSource();
				if(!PRESSED){
					PRESSED = true;
					LASTID = torre.ID;
					break;
				}
				PRESSED = false;
				HANOI.move(LASTID, torre.ID);
				PanelJuego.updateTorres();
				break;
			case"difficulty":
				break;
		}

	}

}
