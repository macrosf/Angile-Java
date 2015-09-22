package agile.java.chapter13;

import java.util.Date;

public interface AlarmClockListener {

	//public void update();
	
	void update(String clockName, Date now);

}
