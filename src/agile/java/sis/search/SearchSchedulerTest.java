package agile.java.sis.search;

import agile.java.util.LineWriter;
import agile.java.util.TestUtil;
import junit.framework.TestCase;

//page 441
public class SearchSchedulerTest extends TestCase {
	private int actualResultsCount = 0;
	
	@Override
	protected void setUp() throws Exception {
		TestUtil.delete(SearchTest.FILE);
		LineWriter.write(SearchTest.FILE, SearchTest.TEST_HTML);
	}
	
	protected void tearDown() throws Exception {
		TestUtil.delete(SearchTest.FILE);
	}
	
	public void testRepeatedSearch() throws Exception {
		final int searchInterval = 3000;
		Search search = new Search(SearchTest.URL, "xxx");
		
		ResultListener listener = new ResultListener() {
			public void executed(Search search) {
				++actualResultsCount;
			}
		};
		
		SearchScheduler scheduler = new SearchScheduler(listener);
		scheduler.repeat(search, searchInterval);
		
		final int expectedResultsCount = 3;
		Thread.sleep((expectedResultsCount-1) * searchInterval + 1000);
		
		scheduler.stop();
		assertEquals(expectedResultsCount, actualResultsCount);
	}
}
