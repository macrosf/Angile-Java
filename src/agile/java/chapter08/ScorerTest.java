package agile.java.chapter08;

import junit.framework.TestCase;

public class ScorerTest extends TestCase {
	public void testIsValid() {
		Scorer scorer = new Scorer();
		assertTrue(scorer.isValid("75"));
		assertFalse(scorer.isValid("adb"));
	}
}
