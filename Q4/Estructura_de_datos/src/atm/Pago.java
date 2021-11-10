package atm;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Pago extends Captura{

		private JComboBox<String> Servicios;

		public Pago(Atm cajero) {
				super(cajero);

				setTitle("Pagos de Servicios");

				Servicios = new JComboBox<String>(Cajero.Servicios);
				Servicios.setFocusable(false);
				Servicios.setFont(Main.FontNormal);
				Servicios.setForeground(Main.Cmain);
				Servicios.setBackground(Main.Cbase);
				Servicios.setBounds(100, 150, 300, 50);
				this.add(Servicios);

		}

		@Override
		public void setCommand(int cmd) {
			switch(cmd){
					case 10:
							pagar();
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

		private void pagar() {
				float comision = interes();
				float pago = Cantidad * comision;
				if(!Cajero.Usuario.removeSaldo(pago)){
						JOptionPane.showMessageDialog( 
										this, "Saldo Insuficiente","Error",
										JOptionPane.ERROR_MESSAGE);
						Cantidad = Cajero.Usuario.getSaldo();
						update();
						return;
				}
				String serv = (String) Servicios.getSelectedItem();
				JOptionPane.showMessageDialog( 
								this, "Pago por: $"
								+Main.df.format(Cantidad)+" en "
								+serv+ " Con el interes del "
								+Main.df.format((comision-1)*100)+"% "+
								"Por un total de: $"
								+Main.df.format(pago));
				Cajero.newMove(serv, pago, "Pago");
				Login log = (Login) Cajero.getScreen(0);
				log.save();
				Cantidad = 0;
				setCommand(11);
		}

		private float interes(){
				return (float)(1.02 + (Math.random() * 0.10));
		}

}
