package test.angile.java.chapter01;

import angile.java.chapter01.Student;

public class StudentTest extends junit.framework.TestCase {

	public void testCreate() {
		final String studentName = "Macros";
		
		Student student = new Student(studentName);
		
		assertEquals(studentName, student.getName());
	}
}
