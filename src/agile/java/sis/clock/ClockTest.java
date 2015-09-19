package agile.java.sis.clock;

import java.util.*;
import java.util.concurrent.locks.*;

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
	//TODO: test failed
//	public void testClock2() throws Exception{
//
//		class Clock2 implements Runnable {
//			private ClockListener listener;
//			private boolean run = true;
//
//			public Clock2(ClockListener listener) {
//				this.listener = listener;
//				new Thread(this).start();
//			}
//
//			public void stop() {
//				run = false;
//			}
//
//			@Override
//			public void run() {
//				long lastTime = System.currentTimeMillis();
//				Calendar calendar = new GregorianCalendar();
//
//				while (run) {
//					try {Thread.sleep(5);}
//					catch (InterruptedException e) {}
//					long now = System.currentTimeMillis();
//					if ( (now / 10) - (lastTime / 10) >= 1) {
//						//listener.update(new Date(now));
//						calendar.setTimeInMillis(now);
//						listener.update(calendar.getTime());
//						lastTime = now;
//					}
//				}
//			}
//		}
//
//		final int perseconds = 500;
//		final List<Date> tics = new ArrayList<Date>();
//
//		ClockListener listener = new ClockListener() {
//			private int count = 0;
//			public void update(Date date) {
//				tics.add(date);
//				if (++count == perseconds)
//					synchronized(monitor) {
//						monitor.notifyAll();
//					}
//			}
//		};
//
//		Clock2 clock2 = new Clock2(listener);
//		synchronized(monitor) {
//			monitor.wait();
//		}
//		clock2.stop();
//		verify2(tics, perseconds);
//	}
//
//	private void verify2(List<Date> tics, int perseconds) {
//		assertEquals(perseconds, tics.size());
//		for(int i=1; i<perseconds; i++)
//			assertEquals(1, getSecondsFromLast2(tics, i));
//	}
//
//	private long getSecondsFromLast2(List<Date> tics, int i) {
//		Calendar calendar = new GregorianCalendar();
//		calendar.setTime(tics.get(i));
//		int now = calendar.get(Calendar.MILLISECOND) / 10;
//		calendar.setTime(tics.get(i-1));
//		int then = calendar.get(Calendar.MILLISECOND) / 10;
//
//		System.out.println(
//				String.format("now=[%d], then=[%d], difference=[%d]", now, then, now-then));
//
//		if (now == 0)
//			now = 100;
//		return now - then;
//	}
	
	//page 436
	private Lock lock;
	private Condition receivedEnoughTics;
	
	@Override
	protected void setUp() {
		lock = new ReentrantLock();
		receivedEnoughTics = lock.newCondition();
	}
	
	public void testClockLock() throws Exception{
		final int seconds = 2;
		final List<Date> tics = new ArrayList<Date>();
		ClockListener listener = createClockListener(tics, seconds);
		
		clock = new Clock(listener);
		lock.lock();
		try {
			receivedEnoughTics.await();
		}
		finally {
			lock.unlock();
		}
		
		clock.stop();
		verify(tics, seconds);
	}

	private ClockListener createClockListener(
			final List<Date> tics, final int seconds) {
		return new ClockListener() {
			private int count = 0;

			@Override
			public void update(Date date) {
				tics.add(date);
				if (++count == seconds) {
					lock.lock();
					try {
						receivedEnoughTics.signalAll();
					}				
					finally {
						lock.unlock();
					}
				}
			}//end of update()
			
		};
	}
}
