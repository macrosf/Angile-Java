package agile.java.chapter13;

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
	public AlarmClock(AlarmClockListener listener) {
		this.setListener(listener);
	}
	
	public AlarmClockListener getListener() {
		return listener;
	}
	private void setListener(AlarmClockListener listener) {
		this.listener = listener;
	}

	public void addAlarm(String string, int i) {
		// TODO Auto-generated method stub
		
	}
	
}
