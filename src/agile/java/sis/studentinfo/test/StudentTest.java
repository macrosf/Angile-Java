package agile.java.sis.studentinfo.test;

import java.util.logging.Handler;
import java.util.logging.Logger;

import agile.java.sis.studentinfo.HonorsGrandingStrategy;
import agile.java.sis.studentinfo.Student;
import agile.java.sis.studentinfo.TestHandler;
import agile.java.sis.studentinfo.Student.Grade;
import agile.java.sis.studentinfo.exception.StudentNameFormatException;

public class StudentTest extends junit.framework.TestCase {
	private static final double GRADE_TOLERANCE = 0.05;

	public void testCreate() {
//		final String studentName = "Macros";
//		Student student = new Student(studentName);
//		assertEquals(studentName, student.getName());
		//page 211
		final String firstStudentName = "macros xia";
		Student firstStudent = new Student(firstStudentName);
		assertEquals(firstStudentName, firstStudent.getName());
		assertEquals("macros", firstStudent.getFirstName());
		assertEquals("xia", firstStudent.getLastName());
		assertEquals("", firstStudent.getMiddleName());

		final String secondStudentName = "macros";
		Student secondStudent = new Student(secondStudentName);
		assertEquals(secondStudentName, secondStudent.getName());
		assertEquals("", secondStudent.getFirstName());
		assertEquals("macros", secondStudent.getLastName());
		assertEquals("", secondStudent.getMiddleName());

		final String thirdStudentName = "macros f xia";
		Student thirdStudent = new Student(thirdStudentName);
		assertEquals(thirdStudentName, thirdStudent.getName());
		assertEquals("macros", thirdStudent.getFirstName());
		assertEquals("xia", thirdStudent.getLastName());
		assertEquals("f", thirdStudent.getMiddleName());
	}

	public void testFullTime() {
		Student student = new Student("a");
		assertFalse(student.isFullTime());
	}

	public void testCredits() {
		Student student = new Student("a");
		student.addCredits(3);
		assertEquals(3, student.getCredits());
		student.addCredits(4);
		assertEquals(7, student.getCredits());
		student.addCredits(5);
		assertEquals(12, student.getCredits());
		assertTrue("not enough credits.",student.isFullTime());
		//assertTrue(student.isFullTime());
	}

//	public void testCalculateGpa() {
//		Student student = new Student("a");
//		//assertEquals(0.0,  student.getGpa(), GRADE_TOLERANCE);
//		assertGpa(student, 0.0);
//		student.addGrade("A");
//		//assertEquals(4.0,  student.getGpa(), GRADE_TOLERANCE);
//		assertGpa(student, 4.0);
//		student.addGrade("B");
//		//assertEquals(3.5,  student.getGpa(), GRADE_TOLERANCE);
//		assertGpa(student, 3.5);
//		student.addGrade("C");
//		//assertEquals(3.0,  student.getGpa(), GRADE_TOLERANCE);
//		assertGpa(student, 3.0);
//		student.addGrade("D");
//		//assertEquals(2.5,  student.getGpa(), GRADE_TOLERANCE);
//		assertGpa(student, 2.5);
//		student.addGrade("F");
//		//assertEquals(2.0,  student.getGpa(), GRADE_TOLERANCE);
//		assertGpa(student, 2.0);
//	}

	public void testCalculateGpa() {
		Student student = new Student("a");
		assertGpa(student, 0.0);
		student.addGrade(Student.Grade.A);
		assertGpa(student, 4.0);
		student.addGrade(Student.Grade.B);
		assertGpa(student, 3.5);
		student.addGrade(Student.Grade.C);
		assertGpa(student, 3.0);
		student.addGrade(Student.Grade.D);
		assertGpa(student, 2.5);
		student.addGrade(Student.Grade.F);
		assertGpa(student, 2.0);
	}

	public void testCalculateHonorsStudentGpa() {
		assertGpa(createHonorsStudent("a", Grade.A), 5.0);
		assertGpa(createHonorsStudent("a", Grade.B), 4.0);
		assertGpa(createHonorsStudent("a", Grade.C), 3.0);
		assertGpa(createHonorsStudent("a", Grade.D), 2.0);
		assertGpa(createHonorsStudent("a", Grade.F), 0.0);
	}

	private Student createHonorsStudent(String name, Grade grade) {
		Student student = new Student(name);
		student.addGrade(grade);
		student.setGradingStrategy(new HonorsGrandingStrategy());
		return student;
	}

	private void assertGpa(Student student, double expectedGpa) {
		assertEquals(expectedGpa,  student.getGpa(), GRADE_TOLERANCE);
	}
	
	//page 251
	public void testBadlyFormatedName() {
		//Logger logger = Logger.getLogger(Student.class.getName());
		//logger.addHandler(handler);
		Handler handler = new TestHandler();
		Student.logger.addHandler(handler);

		final String studentName = "a b c d";
		try{
			new Student(studentName);
			fail("expected exception from 4-part name");
		}
		catch (StudentNameFormatException expectedException) {
			String message = String.format(Student.TOO_MANY_NAME_PARTS_MSG, 
					studentName, Student.MAX_NAME_PARTS);
			assertEquals(message,	expectedException.getMessage());
			//assertTrue(wasLogged(message, (TestHandler)handler));
			assertEquals(message, ((TestHandler) handler).getMessage());
		}
	}

//	private boolean wasLogged(String message, TestHandler handler ) {
//		return message.equals(handler.getMessage());
//	}
	
	//page 274
	public void testLoggingHierarchy() {
		Logger logger = Logger.getLogger("agile.java.sis.studentinfo");
		assertTrue(logger == Logger.getLogger("agile.java.sis.studentinfo"));
		
		Logger parent = Logger.getLogger("agile.java.sis");
		assertEquals(parent, logger.getParent());
		assertEquals(Logger.getLogger("agile.java"), parent.getParent());
	}
	
	//page 324
	public void testFlags() {
		Student student = new Student("a");
		student.set(
				Student.Flag.ON_CAMPUS,
				Student.Flag.TAX_EXEMPT,
				Student.Flag.MINOR);
		assertTrue(student.isOn(Student.Flag.ON_CAMPUS));
		assertTrue(student.isOn(Student.Flag.TAX_EXEMPT));
		assertTrue(student.isOn(Student.Flag.MINOR));
		
		assertFalse(student.isOff(Student.Flag.ON_CAMPUS));
		assertTrue(student.isOff(Student.Flag.TROUBLEMAKER));
		
		student.unset(Student.Flag.ON_CAMPUS);
		assertTrue(student.isOff(Student.Flag.ON_CAMPUS));
		assertTrue(student.isOn(Student.Flag.TAX_EXEMPT));
		assertTrue(student.isOn(Student.Flag.MINOR));	}
}
