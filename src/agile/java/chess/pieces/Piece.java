package agile.java.chess.pieces;

import java.util.HashMap;
import java.util.Map;

public class Piece {
	//---constants----
	public enum Color  {WHITE, BLACK, NO_COLOR};
	public enum Type {PAWM, ROOK, KNIGHT, BISHOP, QUEEN, KING, NO_PIECE};
	public final static Character PAWN_REPRESENTATION = 'P';
	public final static Character ROOK_REPRESENTATION = 'R';
	public final static Character KNIGHT_REPRESENTATION = 'K';
	public final static Character BISHOP_REPRESENTATION = 'B';
	public final static Character QUEEN_REPRESENTATION = 'Q';
	public final static Character KING_REPRESENTATION = 'K';
	public final static Character NOPIECE_REPRESENTATION = '.';
	public final static Map<Type, Character> typeToRepresentation 
		= new HashMap<Type, Character>();
	static {
		typeToRepresentation.put(Type.PAWM, PAWN_REPRESENTATION);
		typeToRepresentation.put(Type.ROOK, ROOK_REPRESENTATION);
		typeToRepresentation.put(Type.KNIGHT, KNIGHT_REPRESENTATION);
		typeToRepresentation.put(Type.BISHOP, BISHOP_REPRESENTATION);
		typeToRepresentation.put(Type.QUEEN, QUEEN_REPRESENTATION);
		typeToRepresentation.put(Type.KING, KING_REPRESENTATION);
		typeToRepresentation.put(Type.NO_PIECE, NOPIECE_REPRESENTATION);
	}
	//---attributes----
	private Color color;
	private Type type;

	//--- static creators----
	private Piece(Color color, Type type){
		setColor(color);
		setType(type);
	};
	
	public static Piece createWhitePawn() {
		return new Piece(Color.WHITE, Type.PAWM);
	}

	public static Piece createBlackPawn() {
		return new Piece(Color.BLACK, Type.PAWM);
	}	
	
	public static Piece createWhiteRook() {
		return new Piece(Color.WHITE, Type.ROOK);
	}	
	
	public static Piece createBlackRook() {
		return new Piece(Color.BLACK, Type.ROOK);
	}		
	
	public static Piece createWhiteKnight() {
		return new Piece(Color.WHITE, Type.KNIGHT);
	}	
	
	public static Piece createBlackKnight() {
		return new Piece(Color.BLACK, Type.KNIGHT);
	}		
	
	public static Piece createWhiteBishop() {
		return new Piece(Color.WHITE, Type.BISHOP);
	}	
	
	public static Piece createBlackBishop() {
		return new Piece(Color.BLACK, Type.BISHOP);
	}		
	
	public static Piece createWhiteQueen() {
		return new Piece(Color.WHITE, Type.QUEEN);
	}	
	
	public static Piece createBlackQueen() {
		return new Piece(Color.BLACK, Type.QUEEN);
	}		
	
	public static Piece createWhiteKing() {
		return new Piece(Color.WHITE, Type.KING);
	}	
	
	public static Piece createBlackKing() {
		return new Piece(Color.BLACK, Type.KING);
	}		
	
	public static Piece noPiece() {
		return new Piece(Color.NO_COLOR, Type.NO_PIECE);
	}	
		
	//-----getter-------
	public boolean isWhite() {
		if (color == Color.WHITE) 
			return true;
		else 
			return false;
	}
	
	public boolean isBlack() {
		if (color == Color.BLACK) 
			return true;
		else 
			return false;
	}
	
	public char getRepresentation() {
		Character representation = typeToRepresentation.get(this.type).charValue();
		
		if (isWhite())
			representation = Character.toLowerCase(representation);
		
		return representation.charValue();	
	}
	//-----getter/setter (POJO)-------
	public Color getColor() {
		return color;
	}

	
	private void setColor(Color color) {
		this.color = color;
	}

	public Type getType() {
		return type;
	}

	private void setType(Type type) {
		this.type = type;
	}
}
