package atm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Deposito extends Captura{

		public Deposito(Atm cajero) {
				super(cajero);

				setTitle("Depositos");

				JLabel warn = new JLabel("Max: $3000.0");
				warn.setFocusable(false);
				warn.setFont(Main.FontNormal);
				warn.setForeground(Main.Cmain);
				warn.setHorizontalAlignment(JLabel.CENTER);
				warn.setHorizontalTextPosition(JLabel.CENTER);
				warn.setVerticalTextPosition(JLabel.TOP);
				warn.setBounds(100, 150, 300, 50);
				this.add(warn);

		}

		@Override
		public void setCommand(int cmd) {
			switch(cmd){
					case 10:
							depositar();
							break;
					case 11:
							Cajero.changeScreen(1);
							break;
					case 12:
							remove();
							break;
					default:
							capturar(cmd);
							break;
			}
		}

		private void depositar() {
				if(Cantidad > 3000){
						JOptionPane.showMessageDialog(
										this, "Supero el monto maximo","Error",JOptionPane.ERROR_MESSAGE);
						Cantidad = 3000;
						update();
						return;
				}
				JOptionPane.showMessageDialog( this, "Deposito correcto por: $"+Cantidad);
				Cajero.Usuario.addSaldo(Cantidad);
				Cajero.newMove("Cajero", Cantidad, "Deposito");
				Login log = (Login) Cajero.getScreen(0);
				log.save();
				Cantidad = 0;
				setCommand(11);
		}

}
