package agile.java.sis.studentinfo.test;

import java.util.Date;

import agile.java.sis.studentinfo.Course;
import agile.java.sis.studentinfo.Session;
import agile.java.sis.studentinfo.SummerCourseSession;
import agile.java.util.DateUtil;

public class SummerCourseSessionTest extends SessionTest {

	public void testEndDate() {
		Date startDate = DateUtil.createDate(2003, 6, 9);

		Session session = createSession(new Course("ENGL", "200"), startDate);
		Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
		assertEquals(eightWeeksOut, session.getEndDate());
	}

	@Override
	protected Session createSession(Course course,
			Date startDate) {
		return SummerCourseSession.create(
				course.getDepartment(), course.getNumber(), startDate);
	}

}
