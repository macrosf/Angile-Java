package angile.java.sis;

import angile.java.sis.report.RosterReporterTest;
import angile.java.sis.studentinfo.CourseSessionTest;
import angile.java.sis.studentinfo.StudentTest;
import junit.framework.TestCase;

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
