package test.angile.java.chaptor03;

import junit.framework.TestCase;
import angile.java.chapter01.Student;
import angile.java.chaptor03.CourseSession;

public class CourseSessionTest extends TestCase {

	private CourseSession session;

	public void setUp() {
		session = new CourseSession("English", "101");
	}

	public void testRosterReport() {
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));

		String rosterReport = session.getRosterReport();

		assertEquals(
				CourseSession.ROSTER_REPORT_HEADER  +
				"A\r\nB\r\n" +
				CourseSession.ROSTER_REPORT_FOOTER + "2", rosterReport);
	}
}
