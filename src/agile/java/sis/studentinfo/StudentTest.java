package agile.java.sis.studentinfo;

public class StudentTest extends junit.framework.TestCase {
	private static final double GRADE_TOLERANCE = 0.05;
	
	public void testCreate() {
		final String studentName = "Macros";
		Student student = new Student(studentName);
		assertEquals(studentName, student.getName());
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
	
	private void assertGpa(Student student, double expectedGpa) {
		assertEquals(expectedGpa,  student.getGpa(), GRADE_TOLERANCE);		
	}
}
