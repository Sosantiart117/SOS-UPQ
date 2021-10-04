package hanoi;

import javax.swing.JPanel;

import java.awt.event.ActionListener;

public class PanelOpciones extends JPanel{

	private ActionListener ACT;

	public PanelOpciones(ActionListener act){
		this.ACT = act;
	}

}
