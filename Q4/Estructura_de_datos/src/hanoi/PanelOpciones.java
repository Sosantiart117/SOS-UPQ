package hanoi;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.DimensionUIResource;

import java.awt.Color;
import java.awt.event.ActionListener;

public class PanelOpciones extends JPanel{

	private ActionListener ACT;
	private static JTextArea LOG;
	private static JLabel TMOVES;
	private static JLabel PMOVES;

	public PanelOpciones(ActionListener act){
		int size = Main.WINSIZE;

		this.ACT = act;

		// Basic View
		this.setLayout(null);
		this.setPreferredSize(new DimensionUIResource(4*Main.WINSIZE, 0));

		// contador
		TMOVES = new JLabel(Integer.toString(JuegoHanoi.HANOI.MOVES));
		Main.styleLabel(TMOVES);
		TMOVES.setBounds(size,size,size*2,size*2);
		TMOVES.setBorder(
			BorderFactory.createTitledBorder(
						BorderFactory.createRaisedSoftBevelBorder(),
						"Movimientos:",
						TitledBorder.LEFT,
						TitledBorder.BELOW_TOP,
						Main.FONT_NORMAL,
						Color.WHITE
					));
		this.add(TMOVES);
		// Minimos movimientos
		PMOVES = new JLabel("Min: "+JuegoHanoi.HANOI.IDEAL);
		Main.styleLabel(PMOVES);
		PMOVES.setFont(Main.FONT_NORMAL);
		PMOVES.setOpaque(false);
		PMOVES.setForeground(Main.CBASE);
		PMOVES.setBounds((size*3)/2, size/2, size, size/2);
		this.add(PMOVES);

		// Botones
		JButton redo = new JButton("Reiniciar");
		Main.styleButton(redo);
		redo.setActionCommand("restart");
		redo.addActionListener(this.ACT);
		// redo.setBounds(x, y, width, height);
		redo.setBounds(size,(size*7),size*2,size/2);
		this.add(redo);
		JButton out = new JButton("Salir");
		Main.styleButton(out);
		out.setActionCommand("out");
		out.addActionListener(this.ACT);
		out.setBounds((size+(size/2)),((size*7)+(size/2)+10),(size*2)-size,size/2);
		this.add(out);
		// moves log
		LOG = new JTextArea("Inicio:\n");
		LOG.setFocusable(false);
		LOG.setEditable(false);
		LOG.setFont(Main.FONT_NORMAL);
		LOG.setForeground(Color.WHITE);
		LOG.setBackground(Main.CBASE);
		JScrollPane logScroller = new JScrollPane(LOG);
		logScroller.setBounds(size, (size*3)+(size/2), size*2, (size*3));
		logScroller.setAutoscrolls(true);
		logScroller.setBorder(
			BorderFactory.createTitledBorder(
						BorderFactory.createRaisedSoftBevelBorder(),
						"Log",
						TitledBorder.RIGHT,
						TitledBorder.ABOVE_TOP,
						Main.FONT_NORMAL,
						Main.CBASE
					));
		this.add(logScroller);
		// Aux
		JButton help = new JButton("?");
		Main.styleButton(help);
		help.addActionListener(this.ACT);
		help.setActionCommand("rules");
		help.setBounds(10, 10, (size/2)+10, size/2);
		this.add(help);
		JButton sos = new JButton("©");
		Main.styleButton(sos);
		sos.addActionListener(this.ACT);
		sos.setActionCommand("credits");
		sos.setBounds((size*4)-((size/2)+20), 10, (size/2)+10, size/2);
		this.add(sos);
	}

	public static void update(){
		TMOVES.setText(Integer.toString(JuegoHanoi.HANOI.MOVES));
		if(JuegoHanoi.HANOI.hasWon()) LOG.append("Ganado!\n");
		PMOVES.setText("Min: "+JuegoHanoi.HANOI.IDEAL);
	}

	public static void addLog(String text){
		update();
		LOG.append(text);
		LOG.setCaretPosition(LOG.getDocument().getLength());
	}

	public static void addLog(int from, int to){
		String dir = "-->";
		if(from>to) dir= "<--";
		String log = 
			String.format(
					"%10s %s %s\n",
					Main.NTORRES[from],
					dir,
					Main.NTORRES[to]
				);
		LOG.append(log);
		LOG.setCaretPosition(LOG.getDocument().getLength());
	}

}
