package angile.java.chess.pieces;

import java.util.ArrayList;

public class Board {
	private ArrayList<Pawn> pawns;
	
	/**
	 * construct board with an empty pawn list
	 */
	public Board() {
		setPawns(new ArrayList<Pawn>());
	}

	public int getSize() {
		return pawns.size();
	}
	
	public void add(Pawn pawn) {
		pawns.add(pawn);
	}	

	public Pawn get(int i) {
		return pawns.get(i);
	}
	/**
	 * @param pawns the pawns to set
	 */
	public void setPawns(ArrayList<Pawn> pawns) {
		this.pawns = pawns;
	}
}
