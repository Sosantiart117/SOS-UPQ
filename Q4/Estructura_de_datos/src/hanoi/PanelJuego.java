package hanoi;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.plaf.DimensionUIResource;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class PanelJuego extends JPanel{

	private ActionListener ACT;
	private static TorreButton[] TORRES;

	public PanelJuego(ActionListener act){
		this.ACT = act;
		this.setLayout(new BorderLayout());
		TORRES = initTorres();
		JPanel tPanel = new JPanel(new GridLayout(1,3,10,10));
		for(int i = 0; i< TORRES.length;i++)
			tPanel.add(TORRES[i],i);
		JPanel nPanel= new JPanel(new GridLayout(1,3,10,10));
		for(int i = 0; i< TORRES.length;i++)
			nPanel.add(makeTLabel(TORRES[i].ID),i);
		this.add(tPanel,BorderLayout.CENTER);
		this.add(nPanel,BorderLayout.NORTH);
		this.add(new JPanel(),BorderLayout.SOUTH);
	}

	public static void updateTorres(){
		for(int i=0; i<3;i++){
			TORRES[i].updateTorre();
			try{
				Thread.sleep(40);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
			TORRES[i].setSelected(false);
		}
	}
	public void won(){
		for(int i=0;i<3;i++)
			TORRES[i].setEnabled(false);
	}

	private JLabel makeTLabel(int i){
		JLabel etiqueta = new JLabel(Main.NTORRES[i]);
		Main.styleLabel(etiqueta);
		etiqueta.setPreferredSize(new DimensionUIResource(0,Main.WINSIZE));
		etiqueta.setBorder(BorderFactory.createRaisedBevelBorder());
		return etiqueta;
	}

	private TorreButton[] initTorres(){
		TorreButton[] torres = new TorreButton[3];
		for(int i=0; i<3;i++){
			torres[i] = new TorreButton(this.ACT, i);
		}
		return torres;
	}

}
