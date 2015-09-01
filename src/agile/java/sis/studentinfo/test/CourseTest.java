package agile.java.sis.studentinfo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import agile.java.sis.studentinfo.Course;

public class CourseTest extends TestCase {
	public void testCreate() {
		Course course = new Course("CMSC", "120");
		assertEquals("CMSC", course.getDepartment());
		assertEquals("120", course.getNumber());
	}

	public void testEquality() {
		Course courseA = new Course("NURS", "201");
		Course courseAPrime = new Course("NURS", "201");
		assertEquals(courseA, courseAPrime);

		Course courseB = new Course("ARTH", "300");
		assertFalse(courseA.equals(courseB));

		// page 293
		// reflexivity
		assertEquals(courseA, courseA);

		// transitivity
		Course courseAPrime2 = new Course("NURS", "201");
		assertEquals(courseAPrime, courseAPrime2);
		assertEquals(courseA, courseAPrime2);

		// symmetry
		assertEquals(courseAPrime, courseA);

		// consistency
		assertEquals(courseA, courseAPrime);

		// comparison to null
		assertFalse(courseA.equals(null));

		//assertTrue(courseA == courseAPrime);
		//assertSame(courseA, courseAPrime);

		//page 296
		// containment
		List<Course> list = new ArrayList<Course>();
		list.add(courseA);
		assertTrue(list.contains(courseAPrime));

		//page 297
//		Map<Course, String> map = new HashMap<Course, String>();
//		map.put(courseA, "");
//		assertTrue(map.containsKey(courseAPrime));
	}

	//page 300
	public void testHashCode() {
		Course courseA = new Course("NURS", "201");
		Course courseAPrime = new Course("NURS", "201");

		Map<Course, String> map = new HashMap<Course, String>();
		map.put(courseA, "");
		assertTrue(map.containsKey(courseAPrime));

		assertEquals(courseA.hashCode(), courseAPrime.hashCode());
		//consistency
		assertEquals(courseA.hashCode(), courseA.hashCode());
	}
}
