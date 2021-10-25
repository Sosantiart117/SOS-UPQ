package rockola;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.DimensionUIResource;

public class RepMenu extends JFrame implements ActionListener{

	private JButton backB;
	private JPanel vista;
	private JLabel RepState;

	public RepMenu() {
    // Setframe
		this.setTitle("Rock-Ola:Reproductor"); //Nombre de la ventana
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
		JLabel title = new JLabel("Reproductor");
		MainMenu.styleLabel(title);
		title.setSize(new DimensionUIResource(600, 100));
		pane.add(title);

		return pane;
	}

	private JPanel makeControlPanel() {
		JPanel pane = new JPanel();
		pane.setBackground(MainMenu.CBASE);
		pane.setPreferredSize(new DimensionUIResource(600, 200));

		JPanel cpane = new JPanel();
		cpane.setLayout(new FlowLayout(1,5,20));
		cpane.setBackground(MainMenu.CBASE);

		// save
		JButton saveB = new JButton("Guardar");
		MainMenu.styleButton(saveB);
		saveB.addActionListener(this);
		saveB.setActionCommand("save");
		cpane.add(saveB);
		// load
		JButton loadB = new JButton("Cargar");
		MainMenu.styleButton(loadB);
		loadB.addActionListener(this);
		loadB.setActionCommand("load");
		cpane.add(loadB);
		// Puase
		JButton pauseB = new JButton("||");
		MainMenu.styleButton(pauseB);
		pauseB.addActionListener(this);
		pauseB.setActionCommand("pause");
		cpane.add(pauseB);
		// play 
		JButton playB = new JButton(">");
		MainMenu.styleButton(playB);
		playB.addActionListener(this);
		playB.setActionCommand("play");
		cpane.add(playB);
		// Next
		JButton nextB = new JButton(">>|");
		MainMenu.styleButton(nextB);
		nextB.addActionListener(this);
		nextB.setActionCommand("next");
		cpane.add(nextB);
		// rand
		JButton randB = new JButton("Alaetorio");
		MainMenu.styleButton(randB);
		randB.addActionListener(this);
		randB.setActionCommand("rand");
		cpane.add(randB);
		// empty
		JButton emptyB = new JButton("X");
		MainMenu.styleButton(emptyB);
		emptyB.addActionListener(this);
		emptyB.setActionCommand("empty");
		cpane.add(emptyB);

		JPanel repane = new JPanel();
		repane.setLayout(new FlowLayout(1,5,20));
		repane.setBackground(MainMenu.CBASE);
		RepState = new JLabel();
		MainMenu.styleLabel(RepState);
		RepState.setFont(MainMenu.FONT_NORMAL);
		updateRep(null);
		repane.add(RepState);
		repane.setPreferredSize(new DimensionUIResource(600,100));

		pane.add(repane,BorderLayout.NORTH);
		pane.add(cpane,BorderLayout.CENTER);
		

		return pane;
	}

	private JScrollPane makeMainPanel() {
		vista = new JPanel();
		vista.setBackground(MainMenu.CBASE);
		vista.setLayout(new GridLayout(0,1,50,20));

		ColaShow();

		JScrollPane scroll = new JScrollPane(vista);
		return scroll;
	}

	private void ColaShow() {
		vista.setVisible(false);
		vista.removeAll();
		for(int i = Main.rockola.ColaRep.size() -1; i>=0 ; i--){
			ColaButton cb = new ColaButton((Cancion)Main.rockola.ColaRep.toArray()[i]);
			cb.addActionListener(this);
			cb.place = Main.rockola.ColaRep.size()-i;
			vista.add(cb);
		}
		vista.setVisible(true);
	}

	private void updateRep(Cancion s){
		String base = "<html>Reproduciendo:<br>";
		if ( s == null )
			base += "</html>";
		else{
			base += "Artista:"+Main.rockola.getArtista(s.getArtits()).getNombre()+
				" | "+
				"Cancion:"+s.getNombre()+
			"</html>";
		}
		RepState.setText(base);
	}

	private class ColaButton extends JButton{
		public int place;
		public Cancion content;
		public ColaButton(Cancion s) {
			super(s.getNombre());
			MainMenu.styleButton(this);
			this.setSize(new DimensionUIResource(300, 100));
			this.setFont(MainMenu.FONT_BIG);
			this.setActionCommand("cola");
			this.content = s;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			switch(e.getActionCommand()){
				case "menu":
					this.dispose();
					new MainMenu();
					break;
				case "save":
					String namePlaylist = 
						JOptionPane.showInputDialog("Nombre de la playlist:");
					if(namePlaylist == null 
							|| namePlaylist.isEmpty()
							|| namePlaylist.isBlank()) {
						JOptionPane.showMessageDialog(null, "No se ha creado");
						break;
					}
					Main.rockola.savePlayList(namePlaylist);
					break;
				case "load":
					String pathPlaylist = 
						JOptionPane.showInputDialog("Ruta del archivo que tiene la Lista");
					if(pathPlaylist == null 
							|| pathPlaylist.isEmpty()
							|| pathPlaylist.isBlank()) {
						JOptionPane.showMessageDialog(null, "No se ha cargado");
						break;
					}
					Main.rockola.loadPlayList(pathPlaylist);
					break;
				case "pause":
					if(Main.rockola.Rep.isReproduciendo())
						if(! Main.rockola.Rep.pause())
							JOptionPane.showMessageDialog(
									this,
									"No tiene un archivo asociado\n");
					break;
				case "play":
					if(Main.rockola.Rep.isReproduciendo()) break;
					if(! Main.rockola.Rep.hasCancion()
							&& Main.rockola.ColaRep.isEmpty()){
						JOptionPane.showMessageDialog(
								this,
								"No hay nada en la cola");
						break;
					}
					if(! Main.rockola.Rep.hasCancion()){
						this.updateRep(Main.rockola.ColaRep.peek());
						Main.rockola.Rep.setCancion(Main.rockola.ColaRep.poll());
					}
					if(! Main.rockola.Rep.play())
						JOptionPane.showMessageDialog(
								this,
								"No tiene un archivo asociado\nReproduciendo");
					break;
				case "next":
					if(Main.rockola.ColaRep.isEmpty()){
						JOptionPane.showMessageDialog(
								this,
								"No hay nada en la cola");
						break;
					}
					int i = JOptionPane.showConfirmDialog(this,
							"<html><h2>La siguiente Cancion: \""+
							Main.rockola.ColaRep.peek().getNombre()+
							"\"<br> Desea Reproducirla</h2></html>",
							"Agregar a cola ?",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if(i==0){
						if(Main.rockola.Rep.hasCancion())
							Main.rockola.Rep.end();
						this.updateRep(Main.rockola.ColaRep.peek());
						Main.rockola.Rep.setCancion(Main.rockola.ColaRep.poll());
						if(! Main.rockola.Rep.play())
							JOptionPane.showMessageDialog(
									this,
									"No tiene un archivo asociado\nReproduciendo");
					}
					break;
				case "rand":
					Main.rockola.shuffleCola();
					break;
				case "empty":
					Main.rockola.ColaRep.clear();
					break;
				case "cola":
					ColaButton cb = (ColaButton) e.getSource();
					int sel = JOptionPane.showConfirmDialog(this,
							"¿Desea Borrar la Cancion de la lista?",
							"¿Borrar Cancion?",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if(sel==0){
						Main.rockola.ColaRep.remove(cb.content);
					}
				 break;
			}
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(this, "Archivo NO encontrado","Error",JOptionPane.WARNING_MESSAGE);
			ex.printStackTrace();
		} catch (IOException | LineUnavailableException ex){
			JOptionPane.showMessageDialog(this, "Orcurrio un erro","Error",JOptionPane.WARNING_MESSAGE);
			ex.printStackTrace();
		} catch (UnsupportedAudioFileException ex) {
			JOptionPane.showMessageDialog(this,
					"Formato de Sonido no Soportado(Solo wav)",
					"Error",
					JOptionPane.WARNING_MESSAGE);
			ex.printStackTrace();
		} finally {
			ColaShow();
		}
	}

}
