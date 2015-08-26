package agile.java.sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

//page 205
abstract class Session implements Comparable<Session>{

	private String department;
	private String number;
	private int numberOfStudents=0;
	private Date startDate;

	private List<Student> students = new ArrayList<Student>();
//	private static int count;
	private int numberOfCredits;

//	public static Session create(String department, String number, Date startDate) {
//		Session.increasementCount();
//		return new Session(department, number, startDate);
//	}

	protected Session(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	//page 205 add
	abstract protected int getSessionLength();

//	private static void increasementCount() {
//		count++;
//	}
//
//	static void resetCount() {
//		count = 0;
//	}
//
//	static int getCount() {
//		return count;
//	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void enroll(Student student) {
		numberOfStudents++;
		student.addCredits(numberOfCredits);
		students.add(student);
	}

//	public String getRosterReport() {
//		StringBuilder buffer = new StringBuilder();
//
//		buffer.append(RosterReporter.ROSTER_REPORT_HEADER);
////		buffer.append(students.get(0).getName()).append(NEW_LINE);
////		buffer.append(students.get(1).getName()).append(NEW_LINE);
//		for (Student student : students)
//			buffer.append(student.getName()).append(RosterReporter.NEW_LINE);
//		buffer.append(RosterReporter.ROSTER_REPORT_FOOTER);
//		buffer.append(students.size());
//
//		return buffer.toString();
//	}

	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		//final int sessionLength = 16;
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays =
				getSessionLength() * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

	public List<Student> getAllStudents() {
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

	/**
	 * @return the numberOfCredits
	 */
	public int getNumberOfCredits() {
		return numberOfCredits;
	}

	/**
	 * @param numberOfCredits the numberOfCredits to set
	 */
	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	@Override
	public int compareTo(Session that) {
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0)
			compare = this.getNumber().compareTo(that.getNumber());
		return compare;
	}

	protected Date getStartDate() {
		return startDate;
	}

	Student get(int i) {
		return students.get(i);
	}

	int getNumberOfStudent() {
		return students.size();
	}

//	protected int getSessionLength() {
//		return 16;
//	}
}
