package agile.java.sis.clock;

import java.util.Date;

//page 433
public class Clock implements Runnable {

	private ClockListener listener;
	private boolean run = true;
	
	public Clock(ClockListener listener) {
		this.listener = listener;
		new Thread(this).start();
	}
	
	public void stop() {
		run = false;
	}

//	//solution 1: (page 433)
//	@Override
//	public void run() {
//		while ( run ) {
//			try { Thread.sleep(1000); }
//			catch ( InterruptedException e) { }
//			listener.update(new Date());
//		}
//	}

//-------------------------------------
//	//test flaw of solution 1
//	@Override
//	public void run() {
//		while (run) {
//			try {	Thread.sleep(1000);} 
//			catch (InterruptedException e) { }
//			listener.update(getDate());
//		}
//	}
//
//	private Date getDate() {
//		Date date = new Date();
//		try {	Thread.sleep(500);	} 
//		catch (InterruptedException e) { 	}
//		return date;
//	}
//	-------------------------------------	
	
	//solution 2: (page 434)
	@Override
	public void run() {
		//page 437
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY - 1);
		//end of page 437
		
		long lastTime = System.currentTimeMillis();
		while (run) {
			try {Thread.sleep(10);}
			catch (InterruptedException e) {}
			long now = System.currentTimeMillis();
			if ( (now / 1000) - (lastTime / 1000) >= 1) {
				listener.update(new Date(now));
				lastTime = now;
			}			
		}
	}
}
