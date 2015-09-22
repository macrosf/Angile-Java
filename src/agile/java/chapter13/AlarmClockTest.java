package agile.java.chapter13;

import java.util.*;

import junit.framework.TestCase;

public class AlarmClockTest extends TestCase {
	Object monitor = new Object();	
	
	//page 447: exercise 1 & 2
//	public void testAlarmClock() throws InterruptedException {
//		final int seconds = 5;		
//		AlarmClockListener listener = new AlarmClockListener () {
//			@Override
//			public void update() {
//				synchronized(monitor) {
//					monitor.notifyAll();
//				}
//			}
//		};
//		
//		long now = System.currentTimeMillis();
//		new AlarmClock("Alarm event!", seconds, listener);
//		
//		synchronized (monitor){
//			monitor.wait();
//		} 
//		long then = System.currentTimeMillis();
//		
//		assertEquals(5, then/1000-now/1000);
//	}
	
	//page 447: exercise 3
	public void testAlarmClock2() {
		
		final Map<String, Date> tics = new HashMap<String, Date>();
		Map<String, Date> verifyTics = new HashMap<String, Date>();
		
		AlarmClockListener listener = new AlarmClockListener () {
			@Override
			public void update(String clockName, Date now) {
				System.out.println("Alarm time up for [" + clockName + "], time: "+ now);
				tics.put(clockName, now);
				synchronized(monitor) {
					monitor.notifyAll();
				}
			}
		};	
		
		AlarmClock clock = new AlarmClock(listener);
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.SECOND, 1);
		clock.addAlarm("1 second after", 1);
		verifyTics.put("1 second after", calendar.getTime());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendar.setTime(new Date());
		calendar.add(Calendar.SECOND, 2);
		clock.addAlarm("2 second after", 2);
		verifyTics.put("2 second after", calendar.getTime());
		
		verify(verifyTics, tics);
	}

	private void verify(Map<String, Date> verifyTics, Map<String, Date> tics) {
		if (verifyTics.size() != tics.size())
			fail("Tics count not equal.");
		
		for(Map.Entry<String, Date> verifyTic: verifyTics.entrySet()) {
			if (!tics.containsKey(verifyTic.getKey())) {
				fail("Alarm clock["+verifyTic.getKey()+" not found!");
				break;
			}
			if ( !tics.get(verifyTic.getKey()).equals(verifyTic.getValue()) ) {
				fail("Alarm clock["+verifyTic.getKey()+"'s time not equal!");
				break;				
			}
				
		}
		
	}
}
