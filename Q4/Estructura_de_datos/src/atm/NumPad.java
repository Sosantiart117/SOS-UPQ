package atm;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import java.awt.Color;
import java.awt.event.ActionListener;

public class NumPad extends JPanel{

	private ArrayList<NumKey> NumKeys;
	// nums vals:
	// Nums 0-9;  ok = 10, cancel = 11, del = 12

	public NumPad(ActionListener act) {
		super();
		this.setLayout(null);
		this.setPreferredSize(new DimensionUIResource(400, 300));
		this.setBackground(Main.Cmain);
		NumKeys = new ArrayList<NumKey>();
		for(int i=0; i < 13; i++)
			NumKeys.add(new NumKey(i,act));
		// diseño de la interfaz
		// NUmpad
		int x=0,y=0,left=125,top=25;
		for(int i = 1; i<10;i++){
			NumKey key = NumKeys.get(i);
			key.setBounds(
					left+((x++)*90),
					top+(y*60),
					80,50);
			this.add(key);
			if(x%3==0){
				x=0;
				y++;
			}
		}
		// cero
		NumKeys.get(0).setBounds(
					left+(1*90),
					top+(3*60),
					80,50);
		this.add(NumKeys.get(0));
		// ActButtons
		// Aceotar
		NumKeys.get(10).setText("OK");
		NumKeys.get(10).setForeground(Color.GREEN);
		NumKeys.get(10).setBounds(
					left+(2*90),
					top+(3*60),
					170,50);
		this.add(NumKeys.get(10));
		// Cancelar
		NumKeys.get(11).setText("X");
		NumKeys.get(11).setForeground(Color.RED);
		NumKeys.get(11).setBounds(
					left+(3*90),
					top+60,
					80,110);
		this.add(NumKeys.get(11));
		// Borrar
		NumKeys.get(12).setText("O");
		NumKeys.get(12).setForeground(Color.YELLOW);
		NumKeys.get(12).setBounds(
					left+(3*90),
					top,
					80,50);
		this.add(NumKeys.get(12));
	}

	public void enableNums(boolean ena,int[] keys){
		for(int x: keys){
			NumKey key = NumKeys.get(x);
			key.setEnabled(ena);
		}
	}

	public void enableNums(boolean ena,int id){
		NumKey key = NumKeys.get(id);
		key.setEnabled(ena);
	}

	public void enableNums(boolean ena){
		for(NumKey x: NumKeys)
			x.setEnabled(ena);
	}

}
