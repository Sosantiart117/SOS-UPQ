package atm;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public abstract class Captura extends AtmPanel{

		protected JLabel Campo;

		protected float Cantidad=0;

		public Captura(Atm cajero) {
				super(cajero);

				Campo = new JLabel();
				Campo.setFocusable(false);
				Campo.setOpaque(true);
				Campo.setFont(Main.FontBig);
				Campo.setForeground(Main.Cbase);
				Campo.setBackground(Main.Cmain);
				Campo.setHorizontalAlignment(JLabel.CENTER);
				Campo.setHorizontalTextPosition(JLabel.CENTER);
				Campo.setVerticalTextPosition(JLabel.TOP);
				Campo.setBorder(
					BorderFactory.createTitledBorder(
								BorderFactory.createRaisedSoftBevelBorder(),
								"Cantidad:",
								TitledBorder.LEFT,
								TitledBorder.BELOW_TOP,
								Main.FontNormal,
								Main.Cbase
							));
				Campo.setBounds(100, 200, 300, 100);
				this.add(Campo);
		}

		protected void capturar(int num){
				Cantidad *= 10;
				Cantidad += num;
				update();
		}

		protected void remove(){
				Cantidad -= (Cantidad%10);
				Cantidad /= 10;
				update();
		}

		@Override
		public void update() {
				Cajero.Pad.enableNums(true);
				Campo.setText(Main.df.format(Cantidad));
		}

}
