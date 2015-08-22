package agile.java.sis.report;

import junit.framework.TestCase;
import static agile.java.util.StringUtil.NEWLINE;

import java.util.Date;

import agile.java.sis.studentinfo.CourseSession;

public class CourseReportTest extends TestCase {

	public void testReport() {
		final Date date = new Date();
		CourseReport report = new CourseReport();
		report.add(CourseSession.create("ENGL", "101", date));
		report.add(CourseSession.create("CHIN", "200", date));
		report.add(CourseSession.create("ITAL", "410", date));
		
		assertEquals(
				 "ENGL 101" + NEWLINE
				+ "CHIN 200" + NEWLINE
				+ "ITAL 410" + NEWLINE, 
				report.text());
	}
	
	public void testComparable() {
		final Date date = new Date();
		CourseSession sessionA = CourseSession.create("CHIN", "101", date);
		CourseSession sessionB = CourseSession.create("ENGL", "101", date);
		
		assertTrue(sessionA.compareTo(sessionB)<0);
		assertTrue(sessionB.compareTo(sessionA)>0);
		
		CourseSession sessionC = CourseSession.create("CHIN", "101", date);
		assertTrue(sessionA.compareTo(sessionC) == 0);
	}
}
