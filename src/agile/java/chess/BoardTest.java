package agile.java.chess;

import junit.framework.TestCase;
import agile.java.chess.pieces.Board;
import agile.java.chess.pieces.Piece;
import agile.java.chess.pieces.Piece.Color;
import agile.java.chess.pieces.Piece.Type;
import agile.java.util.StringUtil;

public class BoardTest extends TestCase {

	private Board board;

	public void setUp() {
		board = new Board();
	}

	public void testCreate() {
		board.initialize();
		assertEquals(32, board.getPieceCount(Color.ANY_COLOR));

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
//		Piece.resetCounter();
		board.initialize();
//		assertEquals(16, Piece.getWhiteCounter());
//		assertEquals(16, Piece.getBlackCounter());
		assertEquals(16, board.getPieceCount(Color.WHITE));
		assertEquals(16, board.getPieceCount(Color.BLACK));
	}

	public void testGetCountForSpecificPiece() {
		board.initialize();
		assertEquals(8, board.getCountForSpecificPiece(Color.WHITE, Type.PAWM));
		assertEquals(8, board.getCountForSpecificPiece(Color.BLACK, Type.PAWM));

		assertEquals(2, board.getCountForSpecificPiece(Color.WHITE, Type.ROOK));
		assertEquals(2, board.getCountForSpecificPiece(Color.BLACK, Type.ROOK));

		assertEquals(2, board.getCountForSpecificPiece(Color.WHITE, Type.KNIGHT));
		assertEquals(2, board.getCountForSpecificPiece(Color.BLACK, Type.KNIGHT));

		assertEquals(2, board.getCountForSpecificPiece(Color.WHITE, Type.BISHOP));
		assertEquals(2, board.getCountForSpecificPiece(Color.BLACK, Type.BISHOP));

		assertEquals(1, board.getCountForSpecificPiece(Color.WHITE, Type.QUEEN));
		assertEquals(1, board.getCountForSpecificPiece(Color.BLACK, Type.QUEEN));

		assertEquals(1, board.getCountForSpecificPiece(Color.WHITE, Type.KING));
		assertEquals(1, board.getCountForSpecificPiece(Color.BLACK, Type.KING));
	}

	public void testGetPieceAtPos() {
		board.initialize();
		Piece piece = board.getPieceAtPos("a8");
		assertTrue(piece!=null);
		assertEquals(Color.BLACK, piece.getColor());
		assertEquals(Type.ROOK, piece.getType());

		piece = board.getPieceAtPos("e1");
		assertTrue(piece!=null);
		assertEquals(Color.WHITE, piece.getColor());
		assertEquals(Type.KING, piece.getType());

	}
}
