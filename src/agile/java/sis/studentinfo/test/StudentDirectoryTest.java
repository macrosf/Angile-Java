package agile.java.sis.studentinfo.test;

import java.io.IOException;

import agile.java.sis.studentinfo.Student;
import agile.java.sis.studentinfo.StudentDirectory;
import junit.framework.TestCase;

public class StudentDirectoryTest extends TestCase {
	private StudentDirectory dir;
	
	protected void setUp() {
		dir = new StudentDirectory();
	}
	
	public void testStoreAndRetieve() throws IOException {
		final int numberOfStudent = 10;
		
		for (int i=0; i<numberOfStudent; i++) 
			addStudent(dir, i);
		
		for (int i=0; i<numberOfStudent; i++)
			verifyStudentLookup(dir, i);
	}
	
	void addStudent(StudentDirectory directory, int i) throws IOException {
		String id = "" + i;
		Student student = new Student(id);
		student.setId(id);
		student.addCredits(i);
		directory.add(student);
		
	}
	
	void verifyStudentLookup(StudentDirectory directory, int i) throws IOException {
		String id = "" + i;
		Student student = directory.findById(id);
		assertEquals(id, student.getId());
		assertEquals(id, student.getLastName());
		assertEquals(i, student.getCredits());
	}
}
