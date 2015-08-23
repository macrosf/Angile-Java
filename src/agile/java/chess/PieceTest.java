package agile.java.chess;

import junit.framework.TestCase;
import agile.java.chess.pieces.*;

public class PieceTest extends TestCase {
	public void testCreate() {
		verifyCreation(
				Piece.createWhitePawn(), Piece.createBlackPawn(),
				Piece.Type.PAWM, Piece.PAWN_REPRESENTATION);		
		
		verifyCreation(
				Piece.createWhiteRook(), Piece.createBlackRook(),
				Piece.Type.ROOK, Piece.ROOK_REPRESENTATION);		
		verifyCreation(
				Piece.createWhiteKnight(), Piece.createBlackKnight(),
				Piece.Type.KNIGHT, Piece.KNIGHT_REPRESENTATION);		
		verifyCreation(
				Piece.createWhiteBishop(), Piece.createBlackBishop(),
				Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATION);		
		verifyCreation(
				Piece.createWhiteQueen(), Piece.createBlackQueen(),
				Piece.Type.QUEEN, Piece.QUEEN_REPRESENTATION);		
	}

	private void verifyCreation(Piece whitePiece, Piece blackPiece, 
			Piece.Type type, char representation) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());
		assertEquals(Character.toLowerCase(representation), whitePiece.getRepresentation());
		
		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
		assertEquals(representation, blackPiece.getRepresentation());
	}
	
}
