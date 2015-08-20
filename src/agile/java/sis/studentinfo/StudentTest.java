package agile.java.sis.studentinfo;

public class StudentTest extends junit.framework.TestCase {

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

}
