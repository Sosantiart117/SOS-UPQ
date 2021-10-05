package hanoi;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import java.awt.event.ActionListener;

public class PanelOpciones extends JPanel{

	private ActionListener ACT;

	public PanelOpciones(ActionListener act){
		this.ACT = act;

		// Basic View
		this.setPreferredSize(new DimensionUIResource(4*Main.WINSIZE, 0));

		// contador
		
	}

}
