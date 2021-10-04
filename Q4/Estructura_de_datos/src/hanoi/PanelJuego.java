package hanoi;

import javax.swing.JPanel;

import java.awt.event.ActionListener;

public class PanelJuego extends JPanel{

	private ActionListener ACT;

	public PanelJuego(ActionListener act){
		this.ACT = act;
	}

}
