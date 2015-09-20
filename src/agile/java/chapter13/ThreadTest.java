package agile.java.chapter13;

//page 444
public class ThreadTest {

	public static void main(String[] args) throws Exception {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (true)
				{
					System.out.print(".");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Thread.yield();
				}
			}
		};
		t.setDaemon(true);		
		t.start();
		Thread.sleep(1000);
		Runtime.getRuntime().exit(0);
	}
}
