package agile.java.chapter09;

import junit.framework.TestCase;

public class StringEquals extends TestCase {
	public void testStringEquals() {
		//page 309
		String a = "we have the techonology";
		String b = "we have the techonology";
		assertTrue(a.equals(b));
		assertTrue(a==b);
		
		//page 310
		String c = "we have";
		c +=" the techonology";
		assertTrue(a.equals(c));
		assertFalse(a == c);
	}
}
