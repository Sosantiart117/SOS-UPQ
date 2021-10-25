package rockola;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.DimensionUIResource;

public class BibMenu extends JFrame implements ActionListener{

	private JButton backB;
	private JButton addB;
	private JButton rmB;
	private JLabel title;
	private JPanel vista;
	private Artista context;

	public BibMenu() {
    // Setframe
		this.setTitle("Rock-Ola:Biblioteca"); //Nombre de la ventana
		this.setResizable(false); // tamaño fijo
		this.setSize(600,800); // x y 
		this.setLocationRelativeTo(null); //aparece en el centro del moitor
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina cuando cierre
		this.getContentPane().setBackground(MainMenu.CBASE); //hacerle un color base
		// Nort navigation pane
		this.add(makeNavPane(),BorderLayout.NORTH);
		// Negative sapace cheat
		JPanel rSpace = new JPanel();
		rSpace.setPreferredSize(new DimensionUIResource(100, 100));
		rSpace.setBackground(MainMenu.CBASE);
		this.add(rSpace,BorderLayout.EAST);
		JPanel lSpace = new JPanel();
		lSpace.setPreferredSize(new DimensionUIResource(100, 100));
		lSpace.setBackground(MainMenu.CBASE);
		this.add(lSpace,BorderLayout.WEST);
		// Controls
		this.add(makeControlPanel(),BorderLayout.SOUTH);
		// Main Panel
		this.add(makeMainPanel(),BorderLayout.CENTER);
		this.setVisible(true);
	}

	private JPanel makeNavPane() {

		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(1,100,10));
		pane.setBackground(MainMenu.CBASE);

		// Boton de regreso
		backB = new JButton("<");
		MainMenu.styleButton(backB);
		backB.setSize(new DimensionUIResource(100, 50));
		backB.setActionCommand("menu");
		backB.addActionListener(this);
		pane.add(backB);
		
		// Title
		title = new JLabel("Biblioteca");
		MainMenu.styleLabel(title);
		title.setSize(new DimensionUIResource(600, 100));
		pane.add(title);

		return pane;
	}

	private JPanel makeControlPanel() {
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(1,100,10));
		pane.setBackground(MainMenu.CBASE);

		// Add Button
		addB = new JButton("+");
		MainMenu.styleButton(addB);
		addB.addActionListener(this);
		addB.setActionCommand("adda");
		pane.add(addB);
		// Remove Button 
		rmB = new JButton("-");
		MainMenu.styleButton(rmB);
		rmB.addActionListener(this);
		rmB.setActionCommand("rma");
		pane.add(rmB);

		return pane;
	}

	private JScrollPane makeMainPanel() {
		vista = new JPanel();
		vista.setBackground(MainMenu.CBASE);
		vista.setLayout(new GridLayout(0,1,50,20));

		showArtists();

		JScrollPane scroll = new JScrollPane(vista);
		return scroll;
	}

	private class BibButton extends JButton{
		public BibButton(String name) {
			super(name);
			MainMenu.styleButton(this);
			this.setSize(new DimensionUIResource(300, 100));
			this.setFont(MainMenu.FONT_BIG);
		}
	}

	private class aButton extends BibButton{

		public Artista content;

		public aButton(Artista a) {
			super(a.getNombre());
			this.content = a;
			this.setActionCommand("artista");
		}
	}

	private class sButton extends BibButton{

		public Cancion content;

		public sButton(Cancion s) {
			super(s.getNombre());
			this.content = s;
			this.setActionCommand("song");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "menu":
				this.dispose();
				new MainMenu();
				break;
			case "showArtists":
				showArtists();
				backB.setActionCommand("menu");
				addB.setActionCommand("adda");
				rmB.setActionCommand("rma");
				title.setText("Biblioteca");
				break;
			case "artista":
				aButton ab = (aButton) e.getSource();
				context = Main.rockola.getArtista(ab.content.getID());
				title.setText(context.getNombre());
				showSongs(context);
				backB.setActionCommand("showArtists");
				addB.setActionCommand("adds");
				rmB.setActionCommand("rms");
				break;
			case "song":
				sButton sb = (sButton) e.getSource();
				Cancion s = Main.rockola.getCancion(sb.content.getID());
				int i = JOptionPane.showConfirmDialog(this,
						"<html><h2>¿Desea agregar \""+
						s.getNombre()+
						"\" a la cola?</h2></html>",
						"Agregar a cola ?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(i==0){
					Main.rockola.addCola(s);
					JOptionPane.showMessageDialog(this, "<html><h2>Se agrego con exito");
				} else {
					JOptionPane.showMessageDialog(this, "<html><h2>No se agrego!");
				}
				break;
			case "adda":
				addArtist();
				break;
			case "adds":
				addSong(context);
				break;
			case "rma":
				int ra = JOptionPane.showConfirmDialog(this,
						"<html><h2>¿Quiere Borrar un Artista?</h2></html>",
						"¿Borrar?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(ra==0 && Main.rockola.getArtistas().size() != 0){
					String[] opt = new String[Main.rockola.getArtistas().size()];
					int rai = 0;
					for(Artista x: Main.rockola.getArtistas())
						opt[rai++] = x.getNombre();
					JComboBox<String> opts = new JComboBox<String>(opt);
					JOptionPane.showConfirmDialog(
							this,
							opts,
							"Artista a Borrar",
							JOptionPane.DEFAULT_OPTION);
					int rma = opts.getSelectedIndex();
					Main.rockola.removeArtista(rma);
				} 
				showArtists();
				break;
			case "rms":
				int rs = JOptionPane.showConfirmDialog(this,
						"<html><h2>¿Quiere Borrar una Cancion?</h2></html>",
						"¿Borrar?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(rs==0 && context.getSongs().size() != 0){
					String[] opt = new String[context.getSongs().size()];
					for(int rsi = 0; rsi < opt.length; rsi++ )
						opt[rsi] =
							Main.rockola.getCancion(context.getSong(rsi)).getNombre();
					JComboBox<String> opts = new JComboBox<String>(opt);
					JOptionPane.showConfirmDialog(
							this,
							opts,
							"Cancion a Borrar",
							JOptionPane.DEFAULT_OPTION);
					int rms = opts.getSelectedIndex();
					Main.rockola.removeCancion(rms);
					context.cleanSongs();
				}
				showSongs(context);
				break;
		}
	}

	private void addArtist() {
		int i = JOptionPane.showConfirmDialog(this,
				"<html><h2>¿Desea agregar un Artista?</h2></html>",
				"¿Agregar Artista?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if(i==0){
			String name = JOptionPane.showInputDialog(this,
					"<html><h2>¿Nombre del artista?</h2></html>",
					"¿Nombre?",
					JOptionPane.QUESTION_MESSAGE);
			Main.rockola.addArtista(name);
			showArtists();
			JOptionPane.showMessageDialog(this, "<html><h2>Se agrego con exito");
		} else {
			JOptionPane.showMessageDialog(this, "<html><h2>No se agrego!");
		}
	}

	private void addSong(Artista a) {
		int i = JOptionPane.showConfirmDialog(this,
				"<html><h2>¿Desea agregar una Cancion?</h2></html>",
				"¿Agregar Cancion?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if(i==0){
			String name = JOptionPane.showInputDialog(this,
					"<html><h2>¿Nombre de la cancion?</h2></html>",
					"¿Nombre?",
					JOptionPane.QUESTION_MESSAGE);
			a.addSong(
				Main.rockola.addSong(name, a.getID(),
						Main.rockola.getCanciones().size()));
			showSongs(a);
			JOptionPane.showMessageDialog(this, "<html><h2>Se agrego con exito");
		} else {
			JOptionPane.showMessageDialog(this, "<html><h2>No se agrego!");
		}
	}

	private void showSongs(Artista a) {
		vista.setVisible(false);
		vista.removeAll();
		for(Integer i: a.getSongs()){
			Cancion s = Main.rockola.getCancion(i);
			sButton sB = new sButton(s);
			sB.addActionListener(this);
			vista.add(sB);
		}
		vista.setVisible(true);
	}

	private void showArtists(){
		vista.setVisible(false);
		vista.removeAll();
		for(Artista a: Main.rockola.getArtistas()){
			aButton artista = new aButton(a);
			artista.addActionListener(this);
			vista.add(artista);
		}
		vista.setVisible(true);
	}


}
