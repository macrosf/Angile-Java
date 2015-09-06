package agile.java.util;

import junit.framework.TestCase;

public class AllTests extends TestCase {

	public static junit.framework.TestSuite suite() {
		junit.framework.TestSuite suite = new junit.framework.TestSuite();

		suite.addTestSuite(DateUtilTest.class);
		suite.addTestSuite(StringUtilTest.class);
		suite.addTestSuite(PasswordGeneratorTest.class);
		return suite;
	}

}
