package agile.java.sis.report;

import agile.java.sis.DateUtil;
import agile.java.sis.studentinfo.CourseSession;
import agile.java.sis.studentinfo.Student;
import junit.framework.TestCase;

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
