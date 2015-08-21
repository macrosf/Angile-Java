package agile.java.util;

public class StringUtil {

	public final static String NEW_LINE = System.getProperty("line.separator");

	public static String appendNewline(String aLine) {
		return aLine + NEW_LINE;
	}
	private StringUtil(){}


}
