package agile.java.sis;

import junit.framework.TestCase;

public class AllTests extends TestCase {

	public static junit.framework.TestSuite suite() {
		junit.framework.TestSuite suite = new junit.framework.TestSuite();

		suite.addTest(agile.java.sis.report.test.AllTests.suite());
		suite.addTest(agile.java.sis.studentinfo.test.AllTests.suite());
		suite.addTest(agile.java.sis.search.AllTest.suite());
		
		return suite;
	}

}
