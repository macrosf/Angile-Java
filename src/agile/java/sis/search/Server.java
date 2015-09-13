package agile.java.sis.search;

import java.util.*;

public class Server extends Thread {
	private List<Search> queue = new LinkedList<Search>();		//flaw
	private ResultListener listener;
	
	public Server(ResultListener listener) {
		setListener(listener);
		start();
	}

	@Override
	public void run() {
		while (true) {
			if (!queue.isEmpty())
				execute(queue.remove(0));
			Thread.yield();
		}
	}
	
	public void add(Search search) {
		queue.add(search);
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
}
