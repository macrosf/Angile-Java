package agile.java.util;

import agile.java.util.DateUtilTest;
import agile.java.util.StringUtilTest;
import junit.framework.TestCase;

public class AllTests extends TestCase {

	public static junit.framework.TestSuite suite() {
		junit.framework.TestSuite suite = new junit.framework.TestSuite();

		suite.addTestSuite(DateUtilTest.class);
		suite.addTestSuite(StringUtilTest.class);
		return suite;
	}

}
