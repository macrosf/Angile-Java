package agile.java.chess.pieces;

import java.util.Arrays;
import java.util.List;

import agile.java.chess.pieces.Piece.Color;
import agile.java.chess.pieces.Piece.Type;
import agile.java.util.StringUtil;

public class Board {

	//----constants----
	final static int BOARD_WIDTH = 8;
	final static int BOARD_HEIGHT = 8;
	public final static String LINE_TOP = "RNBQKBNR";
	public final static String LINE_BOTTOM = LINE_TOP.toLowerCase();
	final static String NULL_PIECE_PRINT = ".";
	private static final List<Piece.Type> initTypeList 	= Arrays.<Piece.Type>asList(
				Piece.Type.ROOK,
				Piece.Type.KNIGHT,
				Piece.Type.BISHOP,
				Piece.Type.QUEEN,
				Piece.Type.KING,
				Piece.Type.BISHOP,
				Piece.Type.KNIGHT,
				Piece.Type.ROOK);

	//----attributes----
	private Piece[][] board = new Piece[BOARD_HEIGHT][BOARD_WIDTH];

	//----methods----
	public void initialize() {
		for (int i = 0; i < BOARD_WIDTH; i++) {
//			board[0][i] = Piece.create(Piece.BLACK_COLOR, LINE_TOP.substring(i, i+1));
//			board[1][i] = Piece.create(Piece.BLACK_COLOR, "P");
//			board[6][i] = Piece.create(Piece.WHITE_COLOR, "p");
//			board[7][i] = Piece.create(Piece.WHITE_COLOR, LINE_BOTTOM.substring(i, i+1));
			board[0][i] = Piece.createPiece(Color.BLACK, initTypeList.get(i));
			board[1][i] = Piece.createBlackPawn();
			board[6][i] = Piece.createWhitePawn();
			board[7][i] = Piece.createPiece(Color.WHITE, initTypeList.get(i));
		}
	}

	public int getPieceCount(Color color) {
		int count = 0;
		for (Piece[] aLine : board) {
			for (Piece piece : aLine) {
				if (piece != null)
					switch(color) {
					case ANY_COLOR:
						count++;
						break;
					default:
						if (piece.getColor() == color )
							count++;
					}
			}
		}
		return count;
	}

	public String print() {

		StringBuilder builder = new StringBuilder();

		for (Piece[] aLine : board) {
			for (Piece piece : aLine) {
				if (piece != null)
					//builder.append(piece.getName());
					builder.append(piece.getRepresentation());
				else
					builder.append(NULL_PIECE_PRINT);
			}
			builder.append(StringUtil.NEWLINE);
		}

		return builder.toString();
	}

	public int getCountForSpecificPiece(Color color, Type type) {

		int count = 0;
		for (Piece[] aLine : board) {
			for (Piece piece : aLine)
				if (piece != null
						&& piece.getColor()==color
						&& piece.getType()==type)
						count++;
			}
		return count;

	}

	public Piece getPieceAtPos(String pos) {
		if (pos==null || pos.length()!=2)
			return null;

		Character ch = pos.toLowerCase().charAt(0);
		int posY = Character.getNumericValue(ch) - Character.getNumericValue('a');

		if (posY<0 || posY>BOARD_WIDTH-1)
			return null;

		ch = pos.charAt(1);
		int posX = Character.getNumericValue(ch) - Character.getNumericValue('1');
		if (posX<0 || posX>BOARD_HEIGHT-1)
			return null;

		return board[BOARD_HEIGHT - posX -1][posY];
	}
}
