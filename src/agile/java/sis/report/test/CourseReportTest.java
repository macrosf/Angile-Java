package agile.java.sis.report.test;

import static agile.java.util.StringUtil.*;

import java.util.Date;

import junit.framework.TestCase;
import agile.java.sis.report.CourseReport;
import agile.java.sis.studentinfo.Course;
import agile.java.sis.studentinfo.CourseSession;
import agile.java.sis.studentinfo.Session;

public class CourseReportTest extends TestCase {

	public void testReport() {
		final Date date = new Date();
		CourseReport report = new CourseReport();
//		report.add(CourseSession.create("ENGL", "101", date));
//		report.add(CourseSession.create("CHIN", "200", date));
//		report.add(CourseSession.create("ITAL", "410", date));
//		report.add(CourseSession.create("CHIN", "220", date));
//		report.add(CourseSession.create("ITAL", "330", date));
		report.add(create("ENGL", "101", date));
		report.add(create("CHIN", "200", date));
		report.add(create("ITAL", "410", date));
		report.add(create("CHIN", "220", date));
		report.add(create("ITAL", "330", date));

		assertEquals(
				"CHIN 200" + NEWLINE
				+ "CHIN 220" + NEWLINE
				+ "ENGL 101" + NEWLINE
				+ "ITAL 330" + NEWLINE
				+ "ITAL 410" + NEWLINE,
				report.text());
	}

	public void testComparable() {
		final Date date = new Date();
		Session sessionA = create("CHIN", "101", date);
		Session sessionB = create("ENGL", "101", date);

		assertTrue(sessionA.compareTo(sessionB)<0);
		assertTrue(sessionB.compareTo(sessionA)>0);

		Session sessionC = create("CHIN", "101", date);
		assertEquals(0, sessionA.compareTo(sessionC));

		Session sessionD = create("CHIN", "211", date);
		assertTrue(sessionC.compareTo(sessionD)<0);
		assertTrue(sessionD.compareTo(sessionC)>0);
	}

	//page 288
	private Session create(String name, String number, Date date) {
		return CourseSession.create(new Course(name, number), date);
	}
}
