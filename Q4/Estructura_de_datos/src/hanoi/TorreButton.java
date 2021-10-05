package hanoi;

import javax.swing.JToggleButton;

import java.awt.event.ActionListener;

public class TorreButton extends JToggleButton{

	public int ID;
	private int[] TORRE;

	public TorreButton(ActionListener act,int id){
		super();
		// Style
		this.setFocusable(false);
		Main.styleButton(this);
		this.setFont(Main.FONT_BIG);
		// Functioning
		this.ID = id;
		this.updateTorre();
		this.addActionListener(act);
		this.setActionCommand("move");
	}

	public void updateTorre(){
		TORRE = JuegoHanoi.HANOI.getTower(this.ID);
		this.setText(makeTorreText());
	}

	private String makeTorreText(){
		String torre = 
			"<html>"+
			"<style>"+
			"p{"+
			"text-align:center;"+
			"display:block;"+
			"}"+
			"</style>";
		for(int i = TORRE.length-1; i >= 0;i--){
			torre+="<p>["+makeDisco(TORRE[i])+"]</p>";
		}
		torre+="</html>";
		return torre;
	}
	private String makeDisco(int size){
		String disco = "";
		for(int i=0;i<size;i++)
			disco+="=";
		return disco;
	}

}
