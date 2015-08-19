package agile.java.sis.studentinfo;

public class StudentTest extends junit.framework.TestCase {

	public void testCreate() {
		final String studentName = "Macros";
		
		Student student = new Student(studentName);
		
		assertEquals(studentName, student.getName());
	}
}
