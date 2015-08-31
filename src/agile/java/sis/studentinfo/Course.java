package agile.java.sis.studentinfo;

public class Course {
	private String department;
	private String number;
	
	public Course(String department, String number) {
		setDepartment(department);
		setNumber(number);
	}
	
	public String getDepartment() {
		return department;
	}
	private void setDepartment(String department) {
		this.department = department;
	}
	public String getNumber() {
		return number;
	}
	private void setNumber(String number) {
		this.number = number;
	}
}
