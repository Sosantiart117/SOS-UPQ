package atm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

public class Login extends AtmPanel{

	private ArrayList<User> Users;
	private JComboBox<String> SelUsers;

	public Login(Atm cajero){
		// Pre SetUp
		super(cajero);
		SelUsers = new JComboBox<String>();
		load();
		// SetUp Panel
		this.setTitle("Login");
		// String[] ops = {"Login","Nuevo Usuario","Salir"};
		String[] ops = {"Login","Nuevo Usuario","Salir"};
		this.setOps(ops);

		// Selector
		SelUsers.setSelectedItem(null);
		SelUsers.setFocusable(false);
		SelUsers.setBounds(100, 140, 300, 85);
		SelUsers.setFont(Main.FontNormal);
		SelUsers.setForeground(Main.Cmain);
		SelUsers.setBorder(
			BorderFactory.createTitledBorder(
						BorderFactory.createRaisedSoftBevelBorder(),
						"Usuarios:",
						TitledBorder.LEFT,
						TitledBorder.BELOW_TOP,
						Main.FontNormal,
						Main.Cmain
					));
		SelUsers.setBackground(Main.Cbase);
		for(User x: Users)
			SelUsers.addItem(x.getName());
		this.add(SelUsers);
	}

	@Override
	public void setCommand(int cmd) {
		switch(cmd){
			case 1:
				login();
				break;
			case 2:
				newUser();
				break;
			case 3:
				Cajero.salir();
				break;
		}
	}

	@Override
	public void update(){
		load();
		// update Users
		SelUsers.removeAllItems();
		for(User x: Users)
			SelUsers.addItem(x.getName());
		// Keys
		Cajero.Pad.enableNums(false);
		int[] enaKeys = {1,2,3};
		Cajero.Pad.enableNums(true,enaKeys);
	}

	public void save(){
		try{
			FileOutputStream saveFile = new FileOutputStream("Users.ser");
			ObjectOutputStream out = new ObjectOutputStream(saveFile);
			out.writeObject(Users);
			out.close();
			saveFile.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void logout(){
		// Cerrar la app
		this.save();
		Cajero.Usuario = null;
		Cajero.changeScreen(0);
		Cajero.Pad.enableNums(false);
		int[] nums = {1,2,3};
		Cajero.Pad.enableNums(true,nums);
	}

	private void login(){
		if(Users.isEmpty()) newUser();
			Cajero.Usuario = Users.get(SelUsers.getSelectedIndex());
			// PIN Interface
			Cajero.changeScreen(7);
	}

	private void load(){
		try{
			// Check if file
			File f = new  File("./Users.ser");
			if(f.isFile()){
				FileInputStream fileIn = new FileInputStream("./Users.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				Users = (ArrayList<User>) in.readObject();
				in.close();
				fileIn.close();
			} else {
				Users = new ArrayList<User>();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void newUser(){
		for(int i = 0;i<2;i++){ // 3 intentos
			try{
				// dame datos
				String name = JOptionPane.showInputDialog("Como se llama el usuario?");
				if(name==null) break;
				String sInt = JOptionPane.showInputDialog("Cual es tu pin de seguridad");
				if(sInt==null) break;
				String sNum = JOptionPane.showInputDialog("Repite tu pin de seguridad");
				if(sNum==null) break;
				int pin = Integer.parseInt(sInt);
				if(pin != Integer.parseInt(sNum)) 
					throw new Exception("No Coinciden los Pines");
				// Confirma datos
				int val = JOptionPane.showConfirmDialog(this,
						"Seguro que quieres crear usuario: "+name+"\nCon PIN:"+pin,
						"Confirmacion",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if(val ==0){
					Users.add(new User(name,pin));
					JOptionPane.showMessageDialog(this, "Usuario creado");
					break;
				} else {
					JOptionPane.showMessageDialog(this, "Usuario no creado");
					break;
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(
						this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		save();
		update();
	}

}
