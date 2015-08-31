package agile.java.chapter08;

import junit.framework.TestCase;

// page 278
public class Exercise07 extends TestCase {
	public void testWithProblems() {
		try {
			doSomething();
			fail("no exception");
		}
		catch (Exception success) {
		}
	}
	
	void doSomething() throws Exception {
		throw new Exception("blah");
	}
	
//	public void testDoSomething2() {
//		try {
//			doSomething();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
