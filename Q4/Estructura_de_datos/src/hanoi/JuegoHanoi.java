package hanoi;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoHanoi extends JFrame implements ActionListener{

	public static TorresHanoi HANOI;

	private int WINSIZE;

	private boolean PRESSED;
	private int LASTID;
	private int LVL;
	private PanelJuego JUEGO;

	public JuegoHanoi(){
		this(7);
	}

	public JuegoHanoi(int lvl){
		this.WINSIZE = Main.WINSIZE;
		this.LVL = lvl;
		HANOI = new TorresHanoi(this.LVL);
		this.setTitle("TorresHanoi"); //Nombre de la ventana
		this.setSize(WINSIZE*16,WINSIZE*9); // x y 
		this.setLocationRelativeTo(null); //aparece en el centro del moitor
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Termina cuando cierre
		this.getContentPane().setBackground(Main.CBASE); //hacerle un color base
		this.setLayout(new BorderLayout(10,0));

		this.JUEGO = new PanelJuego(this);
		this.add(this.JUEGO, BorderLayout.CENTER);
		this.add(new PanelOpciones(this), BorderLayout.WEST);

		this.PRESSED = false;

		this.setVisible(true);
	}

	private void win(){
		JUEGO.won();
		JOptionPane.showMessageDialog(this, "<html><h1>Has Ganado!</h1></html>");
	}

	private void restart(){
		this.remove(this.JUEGO);
		this.LVL = Main.getDificulty();
		HANOI = new TorresHanoi(this.LVL);
		PanelOpciones.addLog("Reinicio\n");
		this.JUEGO = new PanelJuego(this);
		this.add(this.JUEGO, BorderLayout.CENTER);
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
				if(HANOI.move(LASTID, torre.ID))
					PanelOpciones.addLog(LASTID,torre.ID);
				PanelJuego.updateTorres();
				PanelOpciones.update();
				if(HANOI.hasWon()) win();
				break;
			case "restart":
				restart();
				break;
			case "out":
				this.dispose();
				Main.exit();
				break;
			case "rules":
				Main.rules(this);
				break;
			case "credits":
				Main.credits(this);
				break;
		}

	}

}
