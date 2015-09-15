package agile.java.sis.clock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;
//page 432
public class ClockTest extends TestCase {
	private Clock clock;
	private Object monitor = new Object();
	
	public void testClock() throws Exception{
		final int seconds = 5;
		final List<Date> tics = new ArrayList<Date>();
		ClockListener listener = new ClockListener() {
			private int count = 0;
			public void update(Date date) {
				tics.add(date);
				if (++count == seconds)
					synchronized(monitor) {
						monitor.notifyAll();
					}
			}
		};
		clock = new Clock(listener);
		synchronized(monitor) {
			monitor.wait();
		}
		clock.stop();
		verify(tics, seconds);
	}

	private void verify(List<Date> tics, int seconds) {
		assertEquals(seconds, tics.size());
		for(int i=1; i<seconds; i++)
			assertEquals(1, getSecondsFromLast(tics, i));
	}

	private long getSecondsFromLast(List<Date> tics, int i) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(tics.get(i));
		int now = calendar.get(Calendar.SECOND);
		calendar.setTime(tics.get(i-1));
		int then = calendar.get(Calendar.SECOND);
		if (now == 0)
			now = 60;
		return now - then;
	}
	
	//--------------------------------------------------
	public void testClock2() throws Exception{

		class Clock2 implements Runnable {
			private ClockListener listener;
			private boolean run = true;
			
			public Clock2(ClockListener listener) {
				this.listener = listener;
				new Thread(this).start();
			}
			
			public void stop() {
				run = false;
			}
			
			@Override
			public void run() {
				long lastTime = System.currentTimeMillis();
				while (run) {
					try {Thread.sleep(5);}
					catch (InterruptedException e) {}
					long now = System.currentTimeMillis();
					if ( (now / 10) - (lastTime / 10) >= 1) {
						listener.update(new Date(now));
						lastTime = now;
					}			
				}
			}		
		}

		final int perseconds = 500;
		final List<Date> tics = new ArrayList<Date>();
		
		ClockListener listener = new ClockListener() {
			private int count = 0;
			public void update(Date date) {
				tics.add(date);
				if (++count == perseconds)
					synchronized(monitor) {
						monitor.notifyAll();
					}
			}
		};
		
		Clock2 clock2 = new Clock2(listener);
		synchronized(monitor) {
			monitor.wait();
		}
		clock2.stop();
		verify2(tics, perseconds);
	}	
	
	private void verify2(List<Date> tics, int perseconds) {
		assertEquals(perseconds, tics.size());
		for(int i=1; i<perseconds; i++)
			assertEquals(10, getSecondsFromLast2(tics, i));
	}

	private long getSecondsFromLast2(List<Date> tics, int i) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(tics.get(i));
		int now = calendar.get(Calendar.MILLISECOND);
		calendar.setTime(tics.get(i-1));
		int then = calendar.get(Calendar.MILLISECOND);
		if (now == 0)
			now = 1000;
		return now - then;
	}	
}
