package agile.java.chess.bak;

import junit.framework.TestCase;

public class Piece01Test extends TestCase {

	public void testCreate() {
		Piece piece = Piece.create("white", "P");
		assertEquals("white", piece.getColor());
		assertEquals("P", piece.getName());
	}

}
