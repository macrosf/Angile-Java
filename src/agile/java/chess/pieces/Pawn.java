package agile.java.chess.pieces;

public class Pawn {
	public final static String WHITE_COLOR = "White";
	public final static String BLACK_COLOR = "Black";
	public final static String WHITE_PAWN_VALUE = "p";
	public final static String BLACK_PAWN_VALUE = "P";

	private String color;
	//private String value;

	// public Pawn(String color, String toString) {
	// setColor(color);
	// if (WHITE_COLOR.equals(color))
	// setValue(WHITE_PAWN_VALUE);
	// else
	// setValue(BLACK_PAWN_VALUE);
	// }

	/**
	 * construct pawn with a specified color
	 *
	 * @param color
	 */
	public Pawn(String color) {
		setColor(color);
	}

	/**
	 * construct pawn with a default color
	 */
	public Pawn() {
		setColor(WHITE_COLOR);
	}

	public String print() {

		if (WHITE_COLOR.equals(color))
			return WHITE_PAWN_VALUE;
		else
			return BLACK_PAWN_VALUE;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	private void setColor(String color) {
		this.color = color;
	}

}
