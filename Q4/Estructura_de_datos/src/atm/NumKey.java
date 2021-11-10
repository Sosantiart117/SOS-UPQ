package atm;

import javax.swing.JButton;

import java.awt.event.ActionListener;

public class NumKey extends JButton{

	public int Value;

	public NumKey(int val, ActionListener act){
		super();
		Value = val;
		this.setFocusable(false);
		this.setText(String.valueOf(Value));
		this.setActionCommand("numKey");
		this.addActionListener(act);
		this.setFont(Main.FontBig);
		this.setBackground(Main.Cbase);
		this.setForeground(Main.Cmain);
	}

}
