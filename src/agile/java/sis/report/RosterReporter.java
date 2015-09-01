package agile.java.sis.report;

import agile.java.sis.studentinfo.Session;
import agile.java.sis.studentinfo.Student;

public class RosterReporter {
	public final static String  NEW_LINE = System.getProperty("line.separator");
	public final static String ROSTER_REPORT_HEADER = "----HEADER----" + NEW_LINE;
	public final static String ROSTER_REPORT_FOOTER = "----FOOTER----" + NEW_LINE;

	private Session session;

	public RosterReporter(Session session2) {
		this.setSession(session2);
	}

	public Session getSession() {
		return session;
	}

	private void setSession(Session session2) {
		this.session = session2;
	}

	public String getReport() {
		StringBuilder buffer = new StringBuilder();

		buffer.append(ROSTER_REPORT_HEADER);
		for (Student student : session.getAllStudents())
			buffer.append(student.getName()).append(NEW_LINE);
		buffer.append(ROSTER_REPORT_FOOTER);
		buffer.append(session.getNumberOfStudents());

		return buffer.toString();
	}
}
