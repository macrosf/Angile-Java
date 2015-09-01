package agile.java.sis.report;

import static agile.java.util.StringUtil.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import agile.java.sis.studentinfo.Session;

public class CourseReport {

	private List<Session> sessions  =
			new ArrayList<Session>();

	public void add(Session session) {
		sessions.add(session);
	}

	public String text() {
		Collections.sort(sessions);
		StringBuilder builder = new StringBuilder();
		for (Session session: sessions) {
			builder.append(session.getDepartment() + " " +
					session.getNumber() + NEWLINE);
		}
		return builder.toString();
	}
}
