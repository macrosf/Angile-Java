package agile.java.chapter13;

import junit.framework.TestCase;

public class AlarmClockTest extends TestCase {

	Object monitor = new Object();	
	
	public void testAlarmClock() throws InterruptedException {
		final int seconds = 5;		
		AlarmClockListener listener = new AlarmClockListener () {
			@Override
			public void update() {
				synchronized(monitor) {
					monitor.notifyAll();
				}
			}
		};
		
		long now = System.currentTimeMillis();
		new AlarmClock("Alarm event!", seconds, listener);
		
		synchronized (monitor){
			monitor.wait();
		} 
		long then = System.currentTimeMillis();
		
		assertEquals(5, then/1000-now/1000);
		
	}
}
