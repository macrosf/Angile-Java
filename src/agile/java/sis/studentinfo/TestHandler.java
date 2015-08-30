package agile.java.sis.studentinfo;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TestHandler extends Handler {

	private LogRecord record;
	
	@Override
	public void close() throws SecurityException {}

	@Override
	public void flush() {}

	@Override
	public void publish(LogRecord record) {
		this.setRecord(record);
	}

	private void setRecord(LogRecord record) {
		this.record = record;
	}

	public String getMessage() {
		return record.getMessage();
	}
	
	@Override
	public boolean isLoggable(LogRecord record) {
		return true;
	}
}
