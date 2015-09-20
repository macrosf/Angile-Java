package agile.java.sis.search;

import java.util.*;

//page 442
public class SearchScheduler {

	private ResultListener listener;
	private Timer timer;
	public SearchScheduler(ResultListener listener) {
		this.listener = listener;
	}
	
	public void repeat(final Search search, long interval) {
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				search.execute();
				listener.executed(search);
			}
		};
		timer.scheduleAtFixedRate(task, 0, interval);
	}
	
	public void stop() {
		timer.cancel();
	}
}
