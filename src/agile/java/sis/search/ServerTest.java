package agile.java.sis.search;

import junit.framework.TestCase;

import java.util.List;

import org.junit.*;

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
	
	@Before
	void initialize() {
		numberOfResults = 0;
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
	
	//page 439
	public void testSearch2() throws Exception{
		long start = System.currentTimeMillis();
		executeSearches();
		long elapsed = System.currentTimeMillis() - start;
		assertTrue(elapsed < 20);
		waitForResults2();
	}
	
	private void waitForResults2() {
		long start = System.currentTimeMillis();
		while (numberOfResults < URLS.length) {
			try { Thread.sleep(1); }
			catch (InterruptedException e) { }

			if (System.currentTimeMillis() - start > TIMEOUT)
				fail("timeout");
		}		
		
	}

	private void executeSearches() throws Exception {
		for (String url : URLS)
			server.add(new Search(url, "xxx"));
	}

	public void testLogs() throws Exception {
		executeSearches();
		waitForResults2();
		verifyLogs();
	}

	private void verifyLogs() {
		List<String> list = server.getLog();
		assertEquals(URLS.length * 2, list.size());
		for (int i = 0; i<URLS.length; i += 2) {
			verifySameSearch(list.get(i), list.get(i+1));
		}
		
		for (String line: list)
			System.out.println(line);
	}

	private void verifySameSearch(String startSearchMsg, String endSearchMsg) {
		String startSearch = substring(startSearchMsg, Server.START_MSG);
		String endSearch = substring(endSearchMsg, Server.END_MSG);
		assertEquals(startSearch, endSearch);
	}

	private String substring(String string, String upTo) {
		int endIndex = string.indexOf(upTo);
		assertTrue("didn't find" + upTo + " in " + string, 
				endIndex != -1);
		return string.substring(0, endIndex);
	}
}
