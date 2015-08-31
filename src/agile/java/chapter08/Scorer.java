package agile.java.chapter08;

public class Scorer {
	boolean isValid(String input) {
		try{
			Integer.parseInt(input);
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}
	}
}
