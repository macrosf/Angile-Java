package agile.java.sis.search;

import junit.framework.TestCase;
import agile.java.util.LineWriter;
import agile.java.util.TestUtil;

//page 417
public class ServerTest extends TestCase {
	private int numberOfResults = 0;
	private Server server;
	private static final long TIMEOUT = 3000L;
	private static final String[] URLS= {
			SearchTest.URL, SearchTest.URL, SearchTest.URL };

	@Override
	protected void setUp() throws Exception{
		TestUtil.delete(SearchTest.FILE);
		LineWriter.write(SearchTest.FILE, SearchTest.TEST_HTML);

		ResultListener listener = new ResultListener() {
			public void executed(Search search) {
				numberOfResults++;}
		};

		server = new Server(listener);
	}

	@Override
	protected void tearDown() throws Exception {
		//page 430
		assertTrue(server.isAlive());
		server.shutdown();
		server.join(3000);
		assertFalse(server.isAlive());
		TestUtil.delete(SearchTest.FILE);
	}

	public void testSearch() throws Exception {
		long start = System.currentTimeMillis();
		for (String url: URLS)
			server.add(new Search(url, "xxx"));
		long elapsed = System.currentTimeMillis() - start;
		long averageLatency = elapsed / URLS.length;
		assertTrue(averageLatency < 20);
		assertTrue(waitForResults());
	}

	private boolean waitForResults() {
		long start = System.currentTimeMillis();
		while (numberOfResults < URLS.length) {
			try { Thread.sleep(1); }
			catch (InterruptedException e) { }

			if (System.currentTimeMillis() - start > TIMEOUT)
				return false;
		}
		return true;
	}
}
