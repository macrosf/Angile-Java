package agile.java.chess;

import java.util.ArrayList;

import junit.framework.TestCase;
import agile.java.chess.pieces.Board;
import agile.java.chess.pieces.Pawn;

public class BoardTest extends TestCase {
	private Board board;
	final String NEW_LINE = System.getProperty("line.separator");

	public void setUp() {
		board = new Board();
	}

	public void testLineSeparator() {
		assertEquals("\r\n", NEW_LINE);
	}

	public void testSize() {
		//Board b = new Board();
		assertEquals(8, board.getSize());
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

	public void testCreate() {
		ArrayList<String> boardMap = new ArrayList<String>(board.getSize());

		StringBuilder buffer = new StringBuilder();
		for (ArrayList<Pawn> aLine : board.getPawns()) {

			if (aLine.size() == 0)
				boardMap.add("........");
			else {
				for(Pawn pawn : aLine) {
					if (pawn != null)
						buffer.append(pawn.print());
					else
						buffer.append(Pawn.NO_COLOR_PAWN_VALUE);
				}
				//buffer.append(NEW_LINE);
				boardMap.add(buffer.toString());
			}
			buffer.delete(0, buffer.length());
		}

		for (int i=0; i<board.getSize(); i++) {
			if (i == 6)
				assertEquals("PPPPPPPP", boardMap.get(i));
			else if (i == 1)
				assertEquals("pppppppp", boardMap.get(i));
			else
				assertEquals("........", boardMap.get(i));
		}

//		for (int i=0; i<board.getSize(); i++) {
//			System.out.println(boardMap.get(i));
//		}
	}
}
