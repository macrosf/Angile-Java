package agile.java.util;

public class StringUtil {

	public final static String NEWLINE = System.getProperty("line.separator");

	public static String appendNewline(String aLine) {
		return aLine + NEWLINE;
	}
	
	//page 414
	public static int occurrences(String string, String substring) {
		int occurrences = 0;
		int length = substring.length();
		final boolean ignoreCase = true;
		for (int i = 0; i < string.length() - substring.length() + 1; i++) 
			//solution 1: ignore case
			if (string.regionMatches(ignoreCase, i, substring, 0, length))
			
			//solution 2: case sensitive
			//if (string.substring(i, i+length).matches(substring))
			
			//solution 3: case insensitive
			//if (string.substring(i, i+length).compareToIgnoreCase(substring) == 0)
				occurrences++;
		return occurrences;
	}
}
