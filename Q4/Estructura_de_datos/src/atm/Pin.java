package atm;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Pin extends AtmPanel{

	private int Pin;
	private ArrayList<JLabel> Digits;
	private int Index;

	public Pin(Atm cajero) {
		super(cajero);
		// data
		Pin = 0;
		Index = 0;
		// Panel
		this.setTitle("PIN");
		Digits = new ArrayList<JLabel>();

		for(int i=0; i<4; i++)
			Digits.add(new JLabel());

		int n = 0;
		for(JLabel x: Digits){
			x.setFocusable(false);
			x.setOpaque(true);
			x.setFont(Main.FontBig);
			x.setForeground(Main.Cbase);
			x.setBackground(Main.Cmain);
			x.setHorizontalAlignment(JLabel.CENTER);
			x.setHorizontalTextPosition(JLabel.CENTER);
			x.setVerticalTextPosition(JLabel.TOP);
			x.setBounds(100+((n++)*80),200,60,100);
			this.add(x);
		}
	}

	public int getPin(){
		return Pin;
	}

	@Override
	public void setCommand(int cmd) {
		switch(cmd){
			case 11:
				Cajero.changeScreen(0);
				break;
			case 12:
				remNum();
				break;
			default:
				addNum(cmd);
				break;
		}
	}

	@Override
	public void update() {
		// Keys
		Cajero.Pad.enableNums(true);
		Cajero.Pad.enableNums(false,10);
		// draw *
		int i = 0;
		for(JLabel x: Digits){
				if(i++ < Index)
						x.setText("*");
				else
						x.setText("");;
				x.setFont(Main.FontBig);
		}
	}


	private void remNum() {
		if(Pin != 0){
			// Pin -= (Pin%10);
			Pin /= 10;
		}
		if(--Index <= 0){
			Index = 0;
		}
		update();
	}

	private void addNum(int num) {
		if(Pin!=0)
			Pin*=10;
		Pin+=num;
		Index++;
		update();
		if(Index == 4){
			if(Cajero.Usuario.validate(Pin)){
				JOptionPane.showMessageDialog(
						this, "Bienvenido: "+Cajero.Usuario.getName());
				Cajero.changeScreen(1);
				Index = 0;
				Pin = 0;
			} else {
				JOptionPane.showMessageDialog(
						this, "Pin Incorrecto", "Pin Incorrecto",
						JOptionPane.ERROR_MESSAGE);
				Cajero.changeScreen(0);
				Index = 0;
				Pin = 0;

			}
		}
	}

}
