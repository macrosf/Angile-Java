package agile.java.sis.studentinfo;

import agile.java.sis.studentinfo.test.CourseSessionTest;
import agile.java.sis.studentinfo.test.PerformanceTest;
import agile.java.sis.studentinfo.test.StudentTest;
import agile.java.sis.studentinfo.test.SummerCourseSessionTest;
import junit.framework.TestCase;

public class AllTests extends TestCase {
	public static junit.framework.TestSuite suite() {
		junit.framework.TestSuite suite = new junit.framework.TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		suite.addTestSuite(SummerCourseSessionTest.class);
		suite.addTestSuite(PerformanceTest.class);
		return suite;
	}

}
