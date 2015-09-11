package agile.java.sis.search;

import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;

public class SearchTest extends TestCase {
	private static final String URL="http://www.langrsoft.com";
	public void testCreate() throws IOException {
		Search search = new Search(URL, "x");
		assertEquals(URL, search.getUrl());
	}
	
	public void testPositiveSearch() throws IOException {
		Search search = new Search(URL, "Jeff Langr");
		search.execute();
		assertTrue(search.matches() >= 1);
		assertFalse(search.errored());
	}
	
	public void testNegativeSearch() throws IOException {
		final String unlikelyText = "mama cass elliott";
		Search search = new Search(URL, unlikelyText);
		search .execute();
		assertTrue(search.matches() == 0);
		assertTrue(search.errored());
	}
	
	public void testErroredSearch() throws IOException {
		final String badUrl = URL + "/z2468.html";
		Search search = new Search(badUrl, "whatever");
		search.execute();
		assertTrue(search.errored());
		assertEquals(FileNotFoundException.class, 
				search.getError().getClass());
	}
}
