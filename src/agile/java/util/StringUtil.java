package agile.java.util;

public class StringUtil {

	public final static String NEWLINE = System.getProperty("line.separator");

	public static String appendNewline(String aLine) {
		return aLine + NEWLINE;
	}
	private StringUtil(){}


}
