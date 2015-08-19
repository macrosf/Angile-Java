package agile.java.chess.pieces;

import java.util.ArrayList;

public class Board {
	//private ArrayList<Pawn> pawns;

	private ArrayList<ArrayList<Pawn>> pawns;

	/**
	 * construct board with an empty pawn list
	 */
	public Board() {
		//setPawns(new ArrayList<Pawn>());
		initialize();
	}

	public int getSize() {
		return pawns.size();
	}

	public ArrayList<ArrayList<Pawn>> getPawns() {
		return pawns;
	}

	private void initialize() {

		pawns = new ArrayList<ArrayList<Pawn>>(8);

		for(int i=0; i<8; i++) {
			ArrayList<Pawn> aLine = new ArrayList<Pawn>(8);

			if (i==1) {
				for (int j=0; j<8; j++) {
					aLine.add(new Pawn(Pawn.WHITE_COLOR));
				}
			}
			else if (i==6) {
				for (int j=0; j<8; j++) {
					aLine.add(new Pawn(Pawn.BLACK_COLOR));
				}
			}

			pawns.add(aLine);
		}
	}

	public int getPawnsNumber() {
		int count = 0;
		for	(ArrayList<Pawn> aLine : pawns) {
			for (Pawn pawn : aLine) {
				if (pawn != null) count++;
			}
		}
		return count;
	}
//	public void add(Pawn pawn) {
//		pawns.add(pawn);
//	}
//
//	public Pawn get(int i) {
//		return pawns.get(i);
//	}
//	/**
//	 * @param pawns the pawns to set
//	 */
//	public void setPawns(ArrayList<Pawn> pawns) {
//		this.pawns = pawns;
//	}
}
