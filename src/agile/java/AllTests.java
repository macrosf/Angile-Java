package agile.java;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(agile.java.chess.AllTests.suite());
		suite.addTest(agile.java.sis.AllTests.suite());
		suite.addTest(agile.java.util.AllTests.suite());
		return suite;
	}
}
