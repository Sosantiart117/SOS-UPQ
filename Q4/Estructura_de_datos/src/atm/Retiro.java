package atm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Retiro extends Captura{

		private boolean Capture;

		public Retiro(Atm cajero) {
				super(cajero);

				setTitle("Retiros");

				String[] ops = { "$100","$200",
					"$300","$500","$1000","$2000",
						"$5000","Otra Cantidad"};
				setOps(ops);

				JLabel warn = new JLabel("Max: $5000.0");
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
							retirar();
							break;
					case 11:
							Capture = false;
							Cantidad = 0;
							Cajero.changeScreen(1);
							break;
					case 12:
							remove();
							break;
					default:
						if(Capture){
							capturar(cmd);
						}else{
							switch(cmd){
								case 1:
									Cantidad = 100;
									break;
								case 2:
									Cantidad = 200;
									break;
								case 3:
									Cantidad = 300;
									break;
								case 4:
									Cantidad = 500;
									break;
								case 5:
									Cantidad = 1000;
									break;
								case 6:
									Cantidad = 2000;
									break;
								case 7:
									Cantidad = 5000;
									break;
								case 8:
									Capture = true;
									update();
									break;
							}
							if(Cantidad != 0)
								retirar();
						}
						break;
			}
		}

		@Override
		public void update() {
				Cajero.Pad.enableNums(true);
				if(Capture){
					Campo.setVisible(true);
					Campo.setText(Main.df.format(Cantidad));
					Ops.setVisible(false);
				}else{
					int[] keys = {0,9,10,12};
					Cajero.Pad.enableNums(false,keys);
					Campo.setVisible(false);
					Ops.setVisible(true);
				}
		}

		private void retirar() {
				Capture = false;
					if(Cantidad > 5000){
						JOptionPane.showMessageDialog( 
										this, "Supero el retiro maximo","Error",
										JOptionPane.ERROR_MESSAGE);
						Cantidad = 5000;
						Capture = true;
						update();
						return;
				}else if(!Cajero.Usuario.removeSaldo(Cantidad)){
						JOptionPane.showMessageDialog( 
										this, "Saldo Insuficiente","Error",
										JOptionPane.ERROR_MESSAGE);
						Cantidad = 0;
						update();
						return;
				}else 
				JOptionPane.showMessageDialog( this, 
								"Retiro Exitosos por: $"
								+Main.df.format(Cantidad));
				Cajero.newMove("Cajero", Cantidad, "Retiro");
				Login log = (Login) Cajero.getScreen(0);
				log.save();
				Cantidad = 0;
				setCommand(11);
		}

}
