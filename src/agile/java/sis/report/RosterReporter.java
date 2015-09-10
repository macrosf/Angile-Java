package agile.java.sis.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import agile.java.sis.studentinfo.Session;
import agile.java.sis.studentinfo.Student;

public class RosterReporter {
//	public final static String  NEW_LINE = System.getProperty("line.separator");
//	public final static String ROSTER_REPORT_HEADER = "----HEADER----" + NEW_LINE;
//	public final static String ROSTER_REPORT_FOOTER = "----FOOTER----" + NEW_LINE;
//
//	private Session session;
//
//	public RosterReporter(Session session2) {
//		this.setSession(session2);
//	}
//
//	public Session getSession() {
//		return session;
//	}
//
//	private void setSession(Session session2) {
//		this.session = session2;
//	}
//
//	public String getReport() {
//		StringBuilder buffer = new StringBuilder();
//
//		buffer.append(ROSTER_REPORT_HEADER);
//		for (Student student : session.getAllStudents())
//			buffer.append(student.getName()).append(NEW_LINE);
//		buffer.append(ROSTER_REPORT_FOOTER);
//		buffer.append(session.getNumberOfStudents());
//
//		return buffer.toString();
//	}

	//page 341
	public final static String  NEW_LINE = System.getProperty("line.separator");
	public final static String ROSTER_REPORT_HEADER = "Student%n-%n";
	public final static String ROSTER_REPORT_FOOTER = "%n# students = %d%n";

	private Session session;
	private Writer writer;

	RosterReporter(Session session) {
		this.session = session;
	}

	void writeReport(Writer writer) throws IOException {
		this.setWriter(writer);
		writeHeader();
		writeBody();
		writeFooter();
	}

	private void writeFooter() throws IOException {
		writer.write(
				String.format(ROSTER_REPORT_FOOTER, session.getAllStudents().size()));
	}

	private void writeBody() throws IOException {
		for (Student student: session.getAllStudents())
			writer.write(String.format(student.getName() + "%n"));
	}

	private void writeHeader() throws IOException {
		writer.write(String.format(ROSTER_REPORT_HEADER));
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	//page 345
	public void writeReport(String filename) throws IOException {
		Writer bufferedWriter =
				new BufferedWriter(new FileWriter(filename));
		try {
			writeReport(bufferedWriter);
		}
		finally {
			bufferedWriter.close();
		}
	}
}
