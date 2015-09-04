package agile.java.chapter09;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

public class NameTest extends TestCase {

	public void testEquals(){
		Name name1 = new Name("jack");
		Name name2 = new Name("jack");
		
		assertTrue(name1.equals(name1));
		
		assertTrue(name1.equals(name2));
		assertTrue(name2.equals(name1));
		
		Name name3 = new Name("jack");
		assertTrue(name2.equals(name3));
		assertTrue(name1.equals(name3));
		
		assertFalse(name1.equals(null));
	}
	
	public void testSet() {
		Set<Name> names = new HashSet<Name>();
		
		Name foo = new Name("Foo");
		names.add(foo);
		names.add(new Name("jack"));
		names.add(new Name("mike"));
		
		assertTrue(names.contains(foo));
		
		//assertFalse(names.contains(new Name("Foo")));	//before hashCode() is defined
		assertTrue(names.contains(new Name("Foo")));	
	}
}
