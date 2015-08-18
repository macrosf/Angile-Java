package test.angile.java.chapter02;

import junit.framework.TestCase;
import test.angile.java.chapter01.StudentTest;

public class AllTests extends TestCase{
	public static junit.framework.TestSuite suite() {
		junit.framework.TestSuite suite =
				new junit.framework.TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		return suite;
	}

}
