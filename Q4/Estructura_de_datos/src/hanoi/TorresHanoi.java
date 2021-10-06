package hanoi;

import java.util.Stack;

/*
 * @author Santiago Orozco (Sosantiart11@github)
 * @company UPQ
 * @date 02 Octubre 2021
 *
 */

public class TorresHanoi{

	/* El juego tiene 3 Torres
	 * Tiene reglas:
	 * - Solo puedes mover un disco a la vez
	 * - Solo puedes mover un disco menor sobre uno mayor
	 * - Solo se puede agarrar el disco de hasta arriba
	 *
	 */
	private Stack<Integer>[] TORRES;
	public int SIZE, MOVES, IDEAL;

	public TorresHanoi(){
		this(7);
	}

	@SuppressWarnings("unchecked")
	public TorresHanoi(int size){
		this.SIZE = size;
		// vacia todo
		this.MOVES = 0;
		this.TORRES = (Stack<Integer>[]) new Stack<?>[3];
		this.TORRES[0] = new Stack<Integer>();
		this.TORRES[1] = new Stack<Integer>();
		this.TORRES[2] = new Stack<Integer>();
		// Llena la primer torre 
		for(int i = this.SIZE; i>0; i-- )
			this.TORRES[0].push(i);
		this.IDEAL = (int) Math.pow(2, this.SIZE) - 1;
	}

	public boolean move(int from, int to){
		return move(TORRES[from], TORRES[to]);
	}

	public int[] getTower(int torre){
		return getTower(TORRES[torre]);
	}

	public boolean hasWon(){
		return TORRES[2].size() == SIZE;
	}

	private boolean move(Stack<Integer> orig, Stack<Integer> dest){
		if(!isValidMove(orig, dest)) return false;
		dest.push(orig.pop());
		MOVES++;
		return true;
	}

	private int[] getTower(Stack<Integer> torre){
		// Returns the array form of a stack
		int[] state = new int[SIZE];
		for(int i = 0; i<SIZE; i++){
			if(torre.empty() || torre.size()-1<i) state[i] = 0;
			else state[i] = torre.elementAt(i);
		}
		return state;
	}

	private boolean isValidMove(Stack<Integer> orig, Stack<Integer> dest){
		// edge cases
		if(orig.empty()) return false;
		if(dest.empty()) return true;
		// real test  
		return orig.peek() < dest.peek();
	}

}
