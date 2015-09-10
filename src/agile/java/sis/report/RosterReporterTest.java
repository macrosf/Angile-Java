package agile.java.sis.report;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import junit.framework.TestCase;
import agile.java.sis.studentinfo.Course;
import agile.java.sis.studentinfo.CourseSession;
import agile.java.sis.studentinfo.Session;
import agile.java.sis.studentinfo.Student;
import agile.java.util.DateUtil;

public class RosterReporterTest extends TestCase {

//	public void testRosterReport() {
//		//CourseSession session = new CourseSession("English", "101", DateUtil.createDate(2012, 10,10));
//		//CourseSession session = CourseSession.create("English", "101", DateUtil.createDate(2012, 10,10));
//
//		//page 288
//		Session session =
//				CourseSession.create(
//						new Course("ENGL", "101"),
//						DateUtil.createDate(2012, 10,10));
//
//		session.enroll(new Student("A"));
//		session.enroll(new Student("B"));
//
//		String rosterReport = new RosterReporter(session).getReport();
//
//		assertEquals(
//				RosterReporter.ROSTER_REPORT_HEADER +
//				"A" + RosterReporter.NEW_LINE +
//				"B" + RosterReporter.NEW_LINE +
//				RosterReporter.ROSTER_REPORT_FOOTER + "2", rosterReport);
//	}

//	private Date createDate(int year, int month, int day) {
//		GregorianCalendar calendar = new GregorianCalendar();
//		calendar.clear();
//		calendar.set(Calendar.YEAR, year);
//		calendar.set(Calendar.MONTH, month-1);
//		calendar.set(Calendar.DAY_OF_MONTH, day);
//		return calendar.getTime();
//	}

//	//page 340
//	public void testRosterReport() throws IOException {
//		Session session =
//				CourseSession.create(
//						new Course("ENGL", "101"),
//						DateUtil.createDate(2012, 10,10));
//
//		session.enroll(new Student("A"));
//		session.enroll(new Student("B"));
//
//		Writer writer = new StringWriter();
//		new RosterReporter(session).writeReport(writer);
//		String rosterReport = writer.toString();
//
//		assertEquals(
//				String.format(
//					RosterReporter.ROSTER_REPORT_HEADER +
//					"A%n" +
//					"B%n" +
//					RosterReporter.ROSTER_REPORT_FOOTER,  2),
//				rosterReport);
//	}

	//page 344
	private Session session;

	@Override
	protected void setUp() {
		session =
				CourseSession.create(
						new Course("ENGL", "101"),
						DateUtil.createDate(2003, 1, 6));
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
	}

	public void testRosterReport() throws IOException {

		Writer writer = new StringWriter();
		new RosterReporter(session).writeReport(writer);
		assertReportContents(writer.toString());
	}

	private void assertReportContents(String rosterReport) {
		assertEquals(
				String.format(
					RosterReporter.ROSTER_REPORT_HEADER +
					"A%n" +
					"B%n" +
					RosterReporter.ROSTER_REPORT_FOOTER,  2),
				rosterReport);
	}

	public void testFiledReport() throws IOException {
		final String filename = "testFiledReport.txt";
		new RosterReporter(session).writeReport(filename);

		StringBuffer buffer = new StringBuffer();
		String line;

		BufferedReader reader =
				new BufferedReader(new FileReader(filename));
		while (( line = reader.readLine()) != null)
			buffer.append(String.format(line + "%n"));
		reader.close();

		assertReportContents(buffer.toString());
	}
}
