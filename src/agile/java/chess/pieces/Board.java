package agile.java.chess.pieces;

import agile.java.util.StringUtil;

public class Board {

	// constants
	final static int BOARD_WIDTH = 8;
	final static int BOARD_HEIGHT = 8;
	public final static String LINE_TOP = "RNBQKBNR";
	public final static String LINE_BOTTOM = LINE_TOP.toLowerCase();
	final static String NULL_PIECE_PRINT = ".";

	//store all pieces
	private Piece[][] board = new Piece[BOARD_HEIGHT][BOARD_WIDTH];

	public void initialize() {
		for (int i = 0; i < BOARD_WIDTH; i++) {

			board[0][i] = Piece.create(Piece.BLACK_COLOR, LINE_TOP.substring(i, i+1));
			board[1][i] = Piece.create(Piece.BLACK_COLOR, "P");
			board[6][i] = Piece.create(Piece.WHITE_COLOR, "p");
			board[7][i] = Piece.create(Piece.WHITE_COLOR, LINE_BOTTOM.substring(i, i+1));

		}
	}

	public int getPieceCount() {
		int count = 0;
		for (Piece[] aLine : board) {
			for (Piece piece : aLine) {
				if (piece != null)
					count++;
			}
		}
		return count;
	}

	public String print() {

		StringBuilder builder = new StringBuilder();

		for (Piece[] aLine : board) {
			for (Piece piece : aLine) {
				if (piece != null)
					builder.append(piece.getName());
				else
					builder.append(NULL_PIECE_PRINT);
			}
			builder.append(StringUtil.NEW_LINE);
		}

		return builder.toString();
	}
}
