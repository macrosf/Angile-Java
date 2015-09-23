package agile.java.chapter13;

import java.util.*;

public class AlarmClock {
	
//	public AlarmClock(
//			final String event, 
//			final int seconds, 
//			final AlarmClockListener listener) {
//
//		new Thread(new Runnable(){
//			@Override
//			public void run() {
//				long startTime = System.currentTimeMillis();
//				try {
//					Thread.sleep(seconds*1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(event);
//				listener.update();
//			}
//		}).start();;
//	}

	private AlarmClockListener listener;
	private Thread thread;
	private Map<String, Long> alarmTable;
	private boolean run;
	private Calendar calendar;

	public AlarmClock(final AlarmClockListener listener) {
		this.setListener(listener);
		alarmTable = new HashMap<String, Long>();
		run = true;
		calendar = GregorianCalendar.getInstance();
		
		setThread(new Thread(new Runnable() {
			@Override
			public void run() {
				while(run){
					long now = System.currentTimeMillis();
					for(Map.Entry<String, Long> entry: alarmTable.entrySet()) {
						if (entry.getValue()/1000 - now/1000 >1) {
							calendar.setTimeInMillis(now);
							listener.update(entry.getKey(), calendar.getTime());
							
							removeAlarm(entry.getKey());
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}));
	}
	
	public void addAlarm(String alarmName, int i) {
		calendar.setTime(new Date());
		calendar.add(Calendar.SECOND, i);
		alarmTable.put(alarmName, calendar.getTimeInMillis());
	}
	
	public void removeAlarm(String alarmName) {
		alarmTable.remove(alarmName);
	}

	public void stop() {
		run = false;
	}
	
	//getter & setter
	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}	
	
	public AlarmClockListener getListener() {
		return listener;
	}
	
	private void setListener(AlarmClockListener listener) {
		this.listener = listener;
	}

	public int getAlarmCount() {
		return alarmTable.size();
	}
	
}
