package agile.java.sis.report;

import java.util.ArrayList;

import agile.java.sis.studentinfo.CourseSession;
import static agile.java.util.StringUtil.NEWLINE;

public class CourseReport {
	
	private ArrayList<CourseSession> sessions  = 
			new ArrayList<CourseSession>();

	public void add(CourseSession session) {
		sessions.add(session);
	}
	
	public String text() {
		StringBuilder builder = new StringBuilder();
		for (CourseSession session: sessions) {
			builder.append(session.getDepartment() + " " + 
					session.getNumber() + NEWLINE);
		}
		return builder.toString();
	}
}
