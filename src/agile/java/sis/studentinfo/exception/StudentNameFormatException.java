package agile.java.sis.studentinfo.exception;

public class StudentNameFormatException extends IllegalArgumentException {

	private static final long serialVersionUID = -6958538796693816652L;
	
	public StudentNameFormatException(String message) {
		super(message);
	}
}
