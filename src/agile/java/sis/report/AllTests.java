package agile.java.sis.report;

import junit.framework.TestCase;

public class AllTests extends TestCase {

	public static junit.framework.TestSuite suite() {
		junit.framework.TestSuite suite = new junit.framework.TestSuite();

		suite.addTestSuite(RosterReporterTest.class);
		return suite;
	}

}
