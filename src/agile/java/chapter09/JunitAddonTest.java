package agile.java.chapter09;

import agile.java.sis.studentinfo.Course;
import junit.framework.TestCase;
//import junitx.framework.Assert;
import junitx.framework.ObjectAssert;

public class JunitAddonTest extends TestCase {
	public void testEquality() {
		Course courseA = new Course("NURS", "201");
		Course courseAPrime = new Course("NURS", "201");
		assertEquals(courseA, courseAPrime);

		Course courseB = new Course("ARTH", "300");
		assertFalse(courseA.equals(courseB));
		
		ObjectAssert.assertSame(courseA, courseAPrime);
		//Assert.assertNotEquals(courseA, courseAPrime);
	}
}
