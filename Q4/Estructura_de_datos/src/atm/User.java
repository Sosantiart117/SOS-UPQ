package atm;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

	final private String UserName;
	final private int Pin;
	private float Saldo;
	private ArrayList<Move> Moves;

	public User(String userName, int pin){
		this(userName, pin, 0);
	}
	 
	public User(String userName, int pin, float saldo) {
		UserName = userName;
		Pin = pin;
		Saldo = saldo;
		Moves = new ArrayList<Move>();
	}

	public boolean validate(int pin){
		return pin == Pin;
	}

	public String getName(){
		return UserName;
	}

	public void addMove(Move move){
		Moves.add(move);
	}

	public ArrayList<Move> getMoves(){
		return Moves;
	}

	public void addSaldo(float depo){
		Saldo += depo;
	}

	public boolean removeSaldo(float ret){
		if(ret > Saldo)
			return false;
		else{
			Saldo -= ret;
			return true;
		}
	}

	public float getSaldo(){
		return Saldo;
	}

}
