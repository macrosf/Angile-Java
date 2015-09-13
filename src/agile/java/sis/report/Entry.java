package agile.java.sis.report;

import agile.java.sis.studentinfo.Student;

//page 305
public class Entry {
	private Student.Grade grade;
	private String message;

	public Entry(Student.Grade grade, String message) {
		setGrade(grade);
		setMessage(message);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null ||
			object.getClass() != this.getClass())
			return false;

		Entry that = (Entry) object;
		return this.grade == that.grade &&
				this.message.equals(that.message);
	}

	//page 306
	@Override
	public int hashCode() {
		final int hashMultiplier = 41;
		int result = 7;
		result = result * hashMultiplier + grade.hashCode();
		result = result * hashMultiplier + message.hashCode();
		return result;
	}

	public Student.Grade getGrade() {
		return grade;
	}

	private void setGrade(Student.Grade grade) {
		this.grade = grade;
	}

	public String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}
}
