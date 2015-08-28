package agile.java.sis.studentinfo.test;

import java.util.Date;

import agile.java.sis.studentinfo.CourseSession;
import agile.java.sis.studentinfo.Session;
import agile.java.util.DateUtil;


//public class CourseSessionTest extends TestCase {
//page 203
//	private static final int CREDITS = 3;
//	private CourseSession session;
//
//	private CourseSession createCourseSession() {
//		//return new CourseSession("English", "102", DateUtil.createDate(2003,1,6));
//		CourseSession session = CourseSession.create("English", "102", DateUtil.createDate(2003,1,6));
//		session.setNumberOfCredits(CREDITS);
//		return session;
//	}
//
//	public void setUp() {
//		//session = new CourseSession("English", "101", DateUtil.createDate(2003,1,6));
//		session = createCourseSession();
//	}
//
////	public void testRosterReport() {
////		session.enroll(new Student("A"));
////		session.enroll(new Student("B"));
////
////		String rosterReport = session.getRosterReport();
////
////		assertEquals(
////				RosterReporter.ROSTER_REPORT_HEADER  +
////				"A\r\nB\r\n" +
////				RosterReporter.ROSTER_REPORT_FOOTER + "2", rosterReport);
////	}
//
//	public void testCourseDates() {
//		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
//		assertEquals(sixteenWeeksOut, session.getEndDate());
//	}
//
//	public void testCount() {
//		//CourseSession.count = 0;
//		CourseSession.resetCount();
//		createCourseSession();
//		//assertEquals(1, CourseSession.count);
//		assertEquals(1, CourseSession.getCount());
//
//		createCourseSession();
//		//assertEquals(2, CourseSession.count);
//		assertEquals(2, CourseSession.getCount());
//	}
//
//	public void testEnrollStudents() {
//		Student student1 = new Student("Mike");
//		session.enroll(student1);
//		assertEquals(CREDITS, student1.getCredits());
//
//		Student student2 = new Student("Janny");
//		session.enroll(student2);
//		assertEquals(CREDITS, student2.getCredits());
//	}
//
//	public void testStudentStatus() {
//		Student student1 = new Student("Mike");
//		session.enroll(student1);
//		assertEquals(CREDITS, student1.getCredits());
//
//		student1.addCredits(9);
//		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student1.getCredits());
//		assertTrue(student1.isFullTime());
//	}
//
//	public void testInState() {
//		Student student = new Student("Frank");
//		assertFalse(student.isInState());
//		student
//	}
//}

//page 203
public class CourseSessionTest extends SessionTest {

	public void testCourseDates() {

		Date startDate = DateUtil.createDate(2003, 1, 6);
		Session session = createSession("ENGL", "200", startDate);
		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);

		assertEquals(sixteenWeeksOut, session.getEndDate());
	}

	public void testCount() {
		CourseSession.resetCount();
		createSession("", "", new Date());
		assertEquals(1, CourseSession.getCount());

		createSession("", "", new Date());
		assertEquals(2, CourseSession.getCount());
	}

	@Override
	protected Session createSession(String department, String number,
			Date startDate) {

		return CourseSession.create(department, number, startDate);
	}
}