package agile.java.chess.pieces;

public class Piece {
	
	private String color;
	private String name;
	public static Piece create(String color, String name) {
		return new Piece(color, name);
	}
	
	private Piece(String color, String name) {
		setColor(color);
		setName(name);
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
	private void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}
}
