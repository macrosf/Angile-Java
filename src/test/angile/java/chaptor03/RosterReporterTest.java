package test.angile.java.chaptor03;

import junit.framework.TestCase;
import angile.java.chapter01.Student;
import angile.java.chaptor03.CourseSession;
import angile.java.chaptor03.DateUtil;
import angile.java.chaptor03.RosterReporter;

public class RosterReporterTest extends TestCase {

	public void testRosterReport() {
		CourseSession session = new CourseSession("English", "101", DateUtil.createDate(2012, 10,10));

		session.enroll(new Student("A"));
		session.enroll(new Student("B"));

		String rosterReport = new RosterReporter(session).getReport();

		assertEquals(
				RosterReporter.ROSTER_REPORT_HEADER +
				"A" + RosterReporter.NEW_LINE +
				"B" + RosterReporter.NEW_LINE +
				RosterReporter.ROSTER_REPORT_FOOTER + "2", rosterReport);
	}

//	private Date createDate(int year, int month, int day) {
//		GregorianCalendar calendar = new GregorianCalendar();
//		calendar.clear();
//		calendar.set(Calendar.YEAR, year);
//		calendar.set(Calendar.MONTH, month-1);
//		calendar.set(Calendar.DAY_OF_MONTH, day);
//		return calendar.getTime();
//	}
}
