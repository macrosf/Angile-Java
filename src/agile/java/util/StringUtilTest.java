package agile.java.util;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase {
	public void testNewLine() {
		assertEquals(StringUtil.NEWLINE, "\r\n");
	}
	
	//page 414
	private static final String TEXT = "this IS it, isn't it";
	public void testOccurrencesOne() {
		assertEquals(1, StringUtil.occurrences(TEXT, "his"));
	}
	
	public void testOccurrencesNone() {
		assertEquals(0, StringUtil.occurrences(TEXT, "smelt"));
	}
	
	public void testOccurrencesMany() {
		assertEquals(3, StringUtil.occurrences(TEXT, "is"));
		assertEquals(2, StringUtil.occurrences(TEXT, "it"));
	}
	
	public void testOccurrencesSearchStringTooLarge() {
		assertEquals(0, StringUtil.occurrences(TEXT, TEXT + "sdfas"));
	}
}
