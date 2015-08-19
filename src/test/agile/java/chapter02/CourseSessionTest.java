package test.agile.java.chapter02;

import junit.framework.TestCase;
import test.agile.java.chapter01.StudentTest;
import agile.java.chapter01.Student;
import agile.java.chapter02.CourseSession;

public class CourseSessionTest extends TestCase {
	public void testCreate() {
		CourseSession session = new CourseSession("ENGL", "101");
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());

		assertEquals(0, session.getNumberOfStudents());
	}

	public void testEnrollStudents() {
		CourseSession session = new CourseSession("ENGL", "101");

		Student student1 = new Student("Macros");
		session.enroll(student1);
		assertEquals(1, session.getNumberOfStudents());

		java.util.ArrayList<Student> allStudents = session.getAllStudents();
		assertEquals(1, allStudents.size());
		assertEquals(student1, allStudents.get(0));

	}

	public static junit.framework.TestSuite suite() {
		junit.framework.TestSuite suite =
				new junit.framework.TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		return suite;
	}
}
