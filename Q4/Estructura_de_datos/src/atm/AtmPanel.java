package atm;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class AtmPanel extends JPanel{

	protected Atm Cajero;
	protected JLabel Ops;
	private JLabel Title;
	// private int Command;

	public AtmPanel(Atm cajero) {
		Cajero = cajero;

		this.setBackground(Main.Cbase); //hacerle un color base
		this.setLayout(null);
    // Title
    Title = new JLabel();
		Title.setBorder(BorderFactory.createRaisedBevelBorder());
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setHorizontalTextPosition(JLabel.CENTER);
		Title.setVerticalTextPosition(JLabel.TOP);
		Title.setForeground(Main.Cmain);
		Title.setFont(Main.FontBig);
		Title.setForeground(Main.Cmain);
		Title.setIconTextGap(50);
		Title.setBounds(75, 20, 350, 95);
    this.add(Title);
	}

	protected void setTitle(String title){
		String style = "<style>"+
			"html{width:200px}.text{color: #000; text-align: right}"+
			"</style>";
		Title.setText("<html>"+style+"<h1>ATM</h1><hr><h1 class=\"text\">"+title+"</h1>");
	}

	protected void setOps(String[] ops){
		// Operacione
		String menu = "<html>"+
			"<style>"+
			"html{width:350px;padding:25px}"+
			"td{width:150px}"+
			"</style>"+
			"<table><tr>";
		int i = 1;
		for(String op: ops){
			menu += "<td>"+(i++)+".- "+op+"</td>";
			if(i%2==1) menu += "</tr><tr>";
		}
		menu += "</tr></table></html>";
    Ops = new JLabel(menu);
		Ops.setBorder(BorderFactory.createDashedBorder(Main.Cmain));
		Ops.setForeground(Main.Cmain);
		Ops.setFont(Main.FontNormal);
		Ops.setForeground(Main.Cmain);
		Ops.setIconTextGap(50);
		Ops.setBounds(75, 250, 350, 155);
		this.add(Ops);
	}

	abstract public void setCommand(int cmd);
	abstract public void update();

}
