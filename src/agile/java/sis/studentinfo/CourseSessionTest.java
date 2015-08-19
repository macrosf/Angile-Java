package agile.java.sis.studentinfo;

import java.util.Date;

import agile.java.sis.DateUtil;
import junit.framework.TestCase;

public class CourseSessionTest extends TestCase {

	private CourseSession session;

	public void setUp() {
		session = new CourseSession("English", "101", DateUtil.createDate(2003,1,6));
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
}
