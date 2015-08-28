package agile.java.sis.studentinfo;

import java.util.Date;
/*
public class CourseSession implements Comparable<CourseSession>{
//	final static String  NEW_LINE = System.getProperty("line.separator");
//	public final static String ROSTER_REPORT_HEADER = "----HEADER----" + NEW_LINE;
//	public final static String ROSTER_REPORT_FOOTER = "----FOOTER----" + NEW_LINE;

	private String department;
	private String number;
	private int numberOfStudents=0;
	private Date startDate;

	private List<Student> students = new ArrayList<Student>();
	private static int count;
	private int numberOfCredits;

//	public CourseSession(String department, String number){
//		this.department = department;
//		this.number = number;
//	}

	public static CourseSession create(String department, String number, Date startDate) {
		CourseSession.increasementCount();
		return new CourseSession(department, number, startDate);
	}

	protected CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	private static void increasementCount() {
		count++;
	}

	static void resetCount() {
		count = 0;
	}

	static int getCount() {
		return count;
	}

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	@Override
	public int compareTo(CourseSession that) {
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0)
			compare = this.getNumber().compareTo(that.getNumber());
		return compare;
	}

	protected Date getStartDate() {
		return startDate;
	}

	protected int getSessionLength() {
		return 16;
	}
}
*/

//page 205
public class CourseSession extends Session {
	private static int count;
	
	public static CourseSession create(String department, String number, Date startDate) {
		return new CourseSession(department, number, startDate);
	}	
	
	protected CourseSession(String department, String number, Date startDate) {
		super(department, number, startDate);
		CourseSession.incrementCount();
	}

	@Override
	protected int getSessionLength() {
		return 16;
	}

	public static int getCount() {
		return count;
	}

	private static void incrementCount() {
		++count;
	}
	
	public static void resetCount() {
		count = 0;
	}
}