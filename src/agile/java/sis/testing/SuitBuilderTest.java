package agile.java.sis.testing;

import java.util.List;

import junit.framework.TestCase;

public class SuitBuilderTest extends TestCase {

	public void testGatherTestClassName() {
		SuiteBuilder builder = new SuiteBuilder();
		List<String> classes = builder.gatherTestClassNames();
		//assertTrue(classes.contains(this.getClass().getName()));
		assertTrue(classes.contains(this.getName()));
	}
}
