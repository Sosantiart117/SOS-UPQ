package atm;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Atm extends JFrame implements ActionListener{

	public User Usuario;
	public NumPad Pad;

	private AtmPanel ActiveWindow;
	private ArrayList<AtmPanel> Screens;

	// Es estatico se podría hacer dinamico pero es una lista "ficticia"
	final public String[] Servicios = {
		"Telcel",
		"Movistar",
		"Infinitum",
		"Telmex",
		"Walmart",
		"Chedraui",
		"Tarjeta de Credito",
		"SAT",
		"Agua",
		"Gas",
		"Electricidad",
		"Predial",
		"Tenencia",
		"Membresias Innecesarias",
		"Seguros que no Pediste"
	};

	public Atm(){
		// pre setUp
		Usuario = null;
		// Incializa las ventanas
		Screens = new ArrayList<AtmPanel>();
		// lista de Screen 
		Screens.add(new Login(this)); 			// 0
		Screens.add(new Menu(this)); 				// 1
		Screens.add(new Saldo(this));     	// 2
		Screens.add(new Movimientos(this)); // 3
		Screens.add(new Retiro(this)); 			// 4
		Screens.add(new Deposito(this));  	// 5
		Screens.add(new Pago(this)); 				// 6 
		Screens.add(new Pin(this)); 				// 7
		
		// JFrame Setup
		this.setTitle("ATM"); //Nombre de la ventana
		this.setResizable(false); // tamaño fijo
		this.setSize(600,800); // x y 
		this.setLocationRelativeTo(null); //aparece en el centro del moitor
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina cuando cierre
		this.getContentPane().setBackground(Main.Cbase); //hacerle un color base

		// Space hack
		JPanel left = new JPanel();
		left.setBackground(Main.Cmain);
		left.setPreferredSize(new DimensionUIResource(50, 0));
		this.add(left,BorderLayout.WEST);
		JPanel right = new JPanel();
		right.setBackground(Main.Cmain);
		right.setPreferredSize(new DimensionUIResource(50, 0));
		this.add(right,BorderLayout.EAST);
		JPanel top = new JPanel();
		top.setBackground(Main.Cmain);
		top.setPreferredSize(new DimensionUIResource(0, 50));
		this.add(top,BorderLayout.NORTH);

		// Content
		// Start with login
		ActiveWindow = Screens.get(0);
		this.add(ActiveWindow,BorderLayout.CENTER);

		// Pad
		this.Pad = new NumPad(this);
		this.add(Pad,BorderLayout.SOUTH);
		// initial state
		int[] keys = {0,4,5,6,7,8,9,10,11,12};
		Pad.enableNums(false,keys);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NumKey key = (NumKey) e.getSource();
		ActiveWindow.setCommand(key.Value);
	}

	public void changeScreen(int screen){
		ActiveWindow.setVisible(false);
		this.remove(ActiveWindow);
		ActiveWindow = Screens.get(screen);
		ActiveWindow.update();
		ActiveWindow.setVisible(true);
		this.add(ActiveWindow,BorderLayout.CENTER);
	}

	public AtmPanel getScreen(int screen){
		return Screens.get(screen);
	}

	public void newMove(String lugar, float cantidad,String tipo){
		Move mov = new Move(tipo, lugar, cantidad);
		Usuario.addMove(mov);
	}

	public void salir(){
		this.dispose();
		JOptionPane.showMessageDialog(null, "Gracias por usar");
		System.exit(0);
	}

}
