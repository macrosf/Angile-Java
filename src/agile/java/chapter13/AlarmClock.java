package agile.java.chapter13;

public class AlarmClock {
	
	public AlarmClock(
			final String event, 
			final int seconds, 
			final AlarmClockListener listener) {

		new Thread(new Runnable(){
			@Override
			public void run() {
				long startTime = System.currentTimeMillis();
				try {
					Thread.sleep(seconds*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(event);
				listener.update();
			}
		}).start();;
	}
	
}
