package agile.java.sis.search;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTest extends TestCase {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(SearchTest.class);
		suite.addTestSuite(ServerTest.class);
		return suite;
	}
}
