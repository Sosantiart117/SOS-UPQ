package atm;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Movimientos extends AtmPanel{

		private JTextArea Moves;
		private int Count;

		public Movimientos(Atm cajero) {
				super(cajero);
				Moves = new JTextArea();
				Moves.setFocusable(false);
				Moves.setEditable(false);
				Moves.setFont(Main.FontNormal);
				Moves.setForeground(Main.Cmain);
				Moves.setBackground(Main.Cbase);
				JScrollPane scroller = new JScrollPane(Moves);
				scroller.setBounds(25,125,450,250);
				scroller.setAutoscrolls(true);
				scroller.setBorder(
					BorderFactory.createTitledBorder(
								BorderFactory.createRaisedSoftBevelBorder(),
								"%3s:%-13s...$%10s...%-30s\n".formatted(
										"#.","Tipo","Cantidad","Lugar"),
								TitledBorder.RIGHT,
								TitledBorder.ABOVE_TOP,
								Main.FontNormal,
								Main.Cbase
							));
				this.add(scroller);
		}

		@Override
		public void setCommand(int cmd) {
				update();
				Cajero.changeScreen(1);
		}

		@Override
		public void update() {
				// Keys
				Cajero.Pad.enableNums(false);
				Cajero.Pad.enableNums(true,10);
				// Moves
				Count = 1;
				Moves.setText("");
				for(Move x: Cajero.Usuario.getMoves())
						Moves.append(makeMoveString(x));
		}

		private String makeMoveString(Move x) {
			return "%03d:%-8s\t$%10s\t%-30s\n".formatted(
										Count++,x.getTipo(),
										Main.df.format(x.getCantidad()),x.getLugar());

		}

}
