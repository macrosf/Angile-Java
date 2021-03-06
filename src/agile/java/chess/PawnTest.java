package agile.java.chess;

import agile.java.chess.pieces.Pawn;

public class PawnTest extends junit.framework.TestCase {

	//chapter 01
	//
	public void testCreate()
	{
		Pawn p = new Pawn(Pawn.WHITE_COLOR);

		assertEquals(Pawn.WHITE_COLOR, p.getColor());
	}

	//chapter 02
	public void testCreate2() {
		Pawn p = new Pawn();

		assertEquals(Pawn.WHITE_COLOR, p.getColor());
	}

	//chapter 03
	public void testString() {
		assertEquals("123456", "12"+"34"+"56");
		assertEquals("ABCD", "AB".concat("CD"));
	}

	//chapter 03 parctice
	public void testPrint() {

		Pawn p1 = new Pawn(Pawn.WHITE_COLOR);
		Pawn p2 = new Pawn(Pawn.BLACK_COLOR);

		assertEquals("p", p1.print());
		assertEquals("P", p2.print());
	}

}
