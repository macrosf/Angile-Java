package agile.java.chess.bak;

public class Piece {

	private String color;
	private String name;
	static String WHITE_COLOR = "white";
	static String BLACK_COLOR = "black";

	private static int whiteCounter = 0;
	private static int blackCounter = 0;

	private Piece(String color, String name) {
		setColor(color);
		setName(name);
	}

	public static Piece create(String color, String name) {

		if (WHITE_COLOR.equals(color))
			setWhiteCounter(getWhiteCounter() + 1);
		else if(BLACK_COLOR.equals(color))
			setBlackCounter(getBlackCounter() + 1);

		return new Piece(color, name);
	}

	public static void resetCounter() {
		setWhiteCounter(0);
		setBlackCounter(0);
	}

	public void resetCounters() {
		setWhiteCounter(0);
		setBlackCounter(0);
	}


	//--------------
	// getter/setter
	public String getColor() {
		return color;
	}

	private void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public static int getWhiteCounter() {
		return whiteCounter;
	}

	private static void setWhiteCounter(int whiteCounter) {
		Piece.whiteCounter = whiteCounter;
	}

	public static int getBlackCounter() {
		return blackCounter;
	}

	private static void setBlackCounter(int blackCounter) {
		Piece.blackCounter = blackCounter;
	}
}
