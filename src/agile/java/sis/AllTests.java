package agile.java.sis;

import junit.framework.TestCase;

public class AllTests extends TestCase{

	public static junit.framework.TestSuite suite() {
		junit.framework.TestSuite suite =
				new junit.framework.TestSuite();
//		suite.addTestSuite(StudentTest.class);
//		suite.addTestSuite(CourseSessionTest.class);
//		suite.addTestSuite(RosterReporterTest.class);
		suite.addTest(agile.java.sis.report.AllTests.suite());
		suite.addTest(agile.java.sis.studentinfo.AllTests.suite());
		suite.addTestSuite(DateUtilTest.class);
		return suite;
	}

}
