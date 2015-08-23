package agile.java.chess;

import agile.java.chess.bak.Piece;
import agile.java.chess.pieces.Board;
import agile.java.util.StringUtil;
import junit.framework.TestCase;

public class BoardTest extends TestCase {

	private Board board;

	public void setUp() {
		board = new Board();
	}

	public void testCreate() {
		board.initialize();
		assertEquals(32, board.getPieceCount());

		String blankRank = StringUtil.appendNewline("........");
		assertEquals(
				StringUtil.appendNewline(Board.LINE_TOP)
						+ StringUtil.appendNewline("PPPPPPPP") + blankRank
						+ blankRank + blankRank + blankRank
						+ StringUtil.appendNewline("pppppppp")
						+ StringUtil.appendNewline(Board.LINE_BOTTOM),
				board.print());
	}

	public void testBlackAndWhiteCounter() {
		Piece.resetCounter();
		board.initialize();
		assertEquals(16, Piece.getWhiteCounter());
		assertEquals(16, Piece.getBlackCounter());

	}

}
