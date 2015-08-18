package test.angile.java.chaptor03;

import junit.framework.TestCase;
import test.angile.java.chapter01.StudentTest;

public class AllTests extends TestCase{

	public static junit.framework.TestSuite suite() {
		junit.framework.TestSuite suite =
				new junit.framework.TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		suite.addTestSuite(RosterReporterTest.class);
		suite.addTestSuite(DateUtilTest.class);
		return suite;
	}

}
