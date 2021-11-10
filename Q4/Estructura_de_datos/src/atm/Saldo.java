package atm;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class Saldo extends AtmPanel{

		private JLabel Saldo;

		public Saldo(Atm cajero) {
				super(cajero);
				setTitle("Saldo");

				Saldo = new JLabel();
				Saldo.setFocusable(false);
				Saldo.setOpaque(true);
				Saldo.setFont(Main.FontBig);
				Saldo.setForeground(Main.Cbase);
				Saldo.setBackground(Main.Cmain);
				Saldo.setHorizontalAlignment(JLabel.CENTER);
				Saldo.setHorizontalTextPosition(JLabel.CENTER);
				Saldo.setVerticalTextPosition(JLabel.TOP);
				Saldo.setBorder(
					BorderFactory.createTitledBorder(
								BorderFactory.createRaisedSoftBevelBorder(),
								"Saldo:",
								TitledBorder.LEFT,
								TitledBorder.BELOW_TOP,
								Main.FontNormal,
								Main.Cbase
							));
				Saldo.setBounds(100, 140, 300, 100);
				this.add(Saldo);
		}

		@Override
		public void setCommand(int cmd) {
				Cajero.changeScreen(1);
		}

		@Override
		public void update() {
				// Keys
				Cajero.Pad.enableNums(false);
				Cajero.Pad.enableNums(true,10);
				// Update Saldo
				Saldo.setText("$"+
								Main.df.format(Cajero.Usuario.getSaldo()));
		}

}
