package agile.java.sis.studentinfo;

import java.util.Date;

import agile.java.sis.summer.SummerCourseSession;
import agile.java.util.DateUtil;

public class SummerCourseSessionTest extends SessionTest {

	protected void testEndDate() {
		Date startDate = DateUtil.createDate(2003, 6, 9);

		Session session = createSession("ENGL", "200", startDate);
		Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
		assertEquals(eightWeeksOut, session.getEndDate());
	}

	@Override
	protected Session createSession(String department, String number,
			Date startDate) {
		return SummerCourseSession.create(department, number, startDate);
	}

}
