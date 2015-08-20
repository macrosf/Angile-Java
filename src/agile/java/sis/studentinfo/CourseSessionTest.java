package agile.java.sis.studentinfo;

import java.util.Date;

import junit.framework.TestCase;
import agile.java.sis.DateUtil;

public class CourseSessionTest extends TestCase {

	private CourseSession session;

	private CourseSession createCourseSession() {
		//return new CourseSession("English", "102", DateUtil.createDate(2003,1,6));
		return CourseSession.create("English", "102", DateUtil.createDate(2003,1,6));
	}
	public void setUp() {
		//session = new CourseSession("English", "101", DateUtil.createDate(2003,1,6));
		session = createCourseSession();
	}

//	public void testRosterReport() {
//		session.enroll(new Student("A"));
//		session.enroll(new Student("B"));
//
//		String rosterReport = session.getRosterReport();
//
//		assertEquals(
//				RosterReporter.ROSTER_REPORT_HEADER  +
//				"A\r\nB\r\n" +
//				RosterReporter.ROSTER_REPORT_FOOTER + "2", rosterReport);
//	}

	public void testCourseDates() {
		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDates());
	}

	public void testCount() {
		//CourseSession.count = 0;
		CourseSession.resetCount();
		createCourseSession();
		//assertEquals(1, CourseSession.count);
		assertEquals(1, CourseSession.getCount());

		createCourseSession();
		//assertEquals(2, CourseSession.count);
		assertEquals(2, CourseSession.getCount());
	}

}
