package hanoi;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class PanelJuego extends JPanel{

	private ActionListener ACT;
	private static TorreButton[] TORRES;
	public int A=0, B=1,C=2;

	public PanelJuego(ActionListener act){
		this.ACT = act;
		TORRES = initTorres();
		this.setLayout(new GridLayout(1,3,50,50));
		for(int i = 0; i< TORRES.length;i++)
			this.add(TORRES[i]);
	}

	public static void updateTorres(){
		for(int i=0; i<3;i++){
			TORRES[i].updateTorre();
			TORRES[i].setSelected(false);
		}
	}

	private TorreButton[] initTorres(){
		TorreButton[] torres = new TorreButton[3];
		for(int i=0; i<3;i++){
			torres[i] = new TorreButton(this.ACT, i);
		}
		return torres;
	}

}
