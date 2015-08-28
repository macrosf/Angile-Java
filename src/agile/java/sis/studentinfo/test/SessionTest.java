package agile.java.sis.studentinfo.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import agile.java.sis.studentinfo.Session;
import agile.java.sis.studentinfo.Student;
import agile.java.sis.studentinfo.exception.SessionException;
import agile.java.util.DateUtil;

//page 201
abstract public class SessionTest extends TestCase {

	private Session session;
	private Date startDate;

	public static final int CREDITS = 3;

	@Override
	public void setUp() {
		startDate = DateUtil.createDate(2003, 1, 6);
		session = createSession("ENGL", "101", startDate);
		session.setNumberOfCredits(CREDITS);
	}

	abstract protected Session createSession(
			String department, String number, Date startDate);

	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudent());
		assertEquals(startDate, session.getStartDate());
	}

	public void testEnrollStudents() {
		Student student1 = new Student("Cain Divoe");
		session.enroll(student1);
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));

		Student student2 = new Student("Coralee DeVauhn");
		session.enroll(student2);
		assertEquals(CREDITS, student2.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}

	public void testComparable() {
		final Date date = new Date();
		Session sessionA = createSession("CSMC", "101", date);
		Session sessionB = createSession("ENGL", "101", date);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		assertTrue(sessionB.compareTo(sessionA) > 0);

		Session sessionC = createSession("CSMC", "101", date);
		assertEquals(0,sessionA.compareTo(sessionC));

		Session sessionD = createSession("CSMC", "210", date);
		assertTrue(sessionC.compareTo(sessionD) < 0);
		assertTrue(sessionD.compareTo(sessionC) > 0);
	}

	public void testIterate() {
		enrollStudents(session);
		List<Student> results = new ArrayList<Student>();
		for (Student student: session)
			results.add(student);

		assertEquals(results, session.getAllStudents());
	}

	private void enrollStudents(Session session) {
		session.enroll(new Student("1"));
		session.enroll(new Student("2"));
		session.enroll(new Student("3"));
	}
	
	//page 256
	public void testSessionUrl() throws SessionException {
		final String url = "http://course.langrsoft.com/cmsc3000";
		session.setUrl(url);
		assertEquals(url, session.getUrl().toString());
	}
	
	public void testInvalidSessionUrl() {
		final String url = "httsp://course.langrsoft.com/csmc3000";
		try {
			session.setUrl(url);
			fail("expected exception due to invalid protocol in URL");
		}
		catch (SessionException success){
			
		}
	}
}
