package angile.java.chaptor03;

import java.util.ArrayList;
import java.util.Date;

import angile.java.chapter01.Student;

public class CourseSession {
//	final static String  NEW_LINE = System.getProperty("line.separator");
//	public final static String ROSTER_REPORT_HEADER = "----HEADER----" + NEW_LINE;
//	public final static String ROSTER_REPORT_FOOTER = "----FOOTER----" + NEW_LINE;

	private String department;
	private String number;
	private int numberOfStudents=0;
	private Date createDate;
	private java.util.ArrayList<Student> students = new ArrayList<Student>();

	public CourseSession(String department, String number){
		this.department = department;
		this.number = number;
	}

	public CourseSession(String department, String number, Date createDate) {
		this.department = department;
		this.number = number;
		this.setCreateDate(createDate);
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void enroll(Student student) {
		numberOfStudents++;
		students.add(student);
	}

	public String getRosterReport() {
		StringBuilder buffer = new StringBuilder();

		buffer.append(RosterReporter.ROSTER_REPORT_HEADER);
//		buffer.append(students.get(0).getName()).append(NEW_LINE);
//		buffer.append(students.get(1).getName()).append(NEW_LINE);
		for (Student student : students)
			buffer.append(student.getName()).append(RosterReporter.NEW_LINE);
		buffer.append(RosterReporter.ROSTER_REPORT_FOOTER);
		buffer.append(students.size());

		return buffer.toString();
	}
	public ArrayList<Student> getAllStudents() {
		return students;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
