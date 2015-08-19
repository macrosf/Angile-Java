package agile.java.chess;

import junit.framework.TestCase;
import agile.java.chess.pieces.Board;

public class BoardTest extends TestCase {
	private Board board;

	public void setUp() {
		board = new Board();
	}

	public void testSize() {
		//Board b = new Board();
		assertEquals(0, board.getSize());
	}

//	public void testAddPawn() {
//		Pawn blackPawn = new Pawn(Pawn.BLACK_COLOR);
//		board.add(blackPawn);
//		assertEquals(1, board.getSize());
//
//		Pawn whitePawn = new Pawn(Pawn.WHITE_COLOR);
//		board.add(whitePawn);
//		assertEquals(2, board.getSize());
//
//		assertEquals(blackPawn, board.get(0));
//		assertEquals(whitePawn, board.get(1));
//	}

	//chapter 03 practise
	public void testIntialize() {
		assertEquals(16, board.getPawnsNumber());
	}

//	public void testCreate() {
//		for ()
//	}
}
