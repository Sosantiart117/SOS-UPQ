package atm;

public class Menu extends AtmPanel{

	public Menu(Atm cajero) {
		super(cajero);

		String[] ops = {"Retirar","Depositar",
				"Consultar Saldo","Consultar Movimeintos",
				"Salir"};
		setOps(ops);
		
	}

	@Override
	public void setCommand(int cmd) {
			switch(cmd){
					case 1:
						retirar();
						break;
					case 2:
						depositar();
						break;
					case 3:
						saldo();
						break;
					case 4:
						movimientos();
						break;
					case 5:
						salir();
						break;
			}
	}

	@Override
	public void update() {
		setTitle("Menu: "+Cajero.Usuario.getName());
		// keys
		Cajero.Pad.enableNums(false);
		int[] enaKeys = {1,2,3,4,5};
		Cajero.Pad.enableNums(true,enaKeys);
	}

	private void retirar(){
		Cajero.changeScreen(4);
	}

	private void depositar(){
		Cajero.changeScreen(5);
	}

	private void pagar(){
		Cajero.changeScreen(6);

	}

	private void saldo(){
		Cajero.changeScreen(2);

	}

	private void movimientos(){
		Cajero.changeScreen(3);

	}

	private void salir(){
		Login log = (Login) Cajero.getScreen(0);
		log.logout();
	}


}
