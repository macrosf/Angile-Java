package agile.java.sis.search;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Server extends Thread {
	//solution 1:
	//private List<Search> queue = new LinkedList<Search>();		//flaw

	//solution 2: (page 428)
	//private List<Search> queue =
	//		Collections.synchronizedList(new LinkedList<Search>());

	//solution 3: (page 429)
	private BlockingQueue<Search> queue =
			new LinkedBlockingQueue<Search>();

	private ResultListener listener;

	public Server(ResultListener listener) {
		setListener(listener);
		start();
	}

	@Override
//	public void run() {
//		while (true) {
//			if (!queue.isEmpty())
//				execute(queue.remove(0));
//			Thread.yield();
//		}
//	}

	//page 429
	public void run() {
		while (true) {
				try {
					execute(queue.take());
				}
				catch (InterruptedException e) {
					break;	//page 431
				}
		}
	}
	public void add(Search search) throws Exception {
		//queue.add(search);
		//page 429
		queue.put(search);
	}

	private void execute(Search search) {
		search.execute();
		listener.executed(search);
	}

	public ResultListener getListener() {
		return listener;
	}

	private void setListener(ResultListener listener) {
		this.listener = listener;
	}

	//page 431
	public void shutdown() {
		this.interrupt();
	}
}
