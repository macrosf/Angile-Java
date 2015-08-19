package agile.java.chess;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(BoardTest.class);
		suite.addTestSuite(PawnTest.class);
		suite.addTestSuite(CharacterTest.class);

		return suite;
	}
}
