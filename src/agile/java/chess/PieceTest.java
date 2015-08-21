package agile.java.chess;

import agile.java.chess.pieces.Piece;
import junit.framework.TestCase;

public class PieceTest extends TestCase {
	
	public void testCreate() {
		Piece piece = Piece.create("white", "soldier");
		assertEquals("white", piece.getColor());
		assertEquals("soldier", piece.getName());
	}
}
