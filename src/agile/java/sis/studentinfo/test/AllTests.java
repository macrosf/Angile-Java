package agile.java.sis.studentinfo.test;

import junit.framework.TestCase;

public class AllTests extends TestCase {
	public static junit.framework.TestSuite suite() {
		junit.framework.TestSuite suite = new junit.framework.TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		suite.addTestSuite(SummerCourseSessionTest.class);
		suite.addTestSuite(PerformanceTest.class);
		suite.addTestSuite(StudentDirectoryTest.class);
		suite.addTestSuite(CourseTest.class);
		return suite;
	}

}
