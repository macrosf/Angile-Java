package angile.java.chess.pieces;

public class Pawn {
	public final static String WHITE_COLOR = "White";
	public final static String BLACK_COLOR = "Black";
	
	private String color;

	/**
	 * construct pawn with a specified color
	 * @param color
	 */
	public Pawn(String color){
		this.color = color;
	}
	
	/**
	 * construct pawn with a default color
	 */
	public Pawn() {
		this.color = WHITE_COLOR;
	}
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
}
