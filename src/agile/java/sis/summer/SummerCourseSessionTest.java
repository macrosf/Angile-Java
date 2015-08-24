package agile.java.sis.summer;

import java.util.Date;

import junit.framework.TestCase;
import agile.java.sis.studentinfo.CourseSession;
import agile.java.util.DateUtil;

public class SummerCourseSessionTest extends TestCase {

	protected void testEndDate() {
		Date startDate = DateUtil.createDate(2003, 6, 9);

		CourseSession session = SummerCourseSession.create("ENGL", "200", startDate);
		Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
		assertEquals(eightWeeksOut, session.getEndDate());
	}
}
