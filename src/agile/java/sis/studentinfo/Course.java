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

	//page 292
	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		//option 1:
		if (this.getClass() != object.getClass())
			return false;
		//option 2:
		//if (!(object instanceof Course))
		//	return false;

		Course that = (Course) object;
		return
			this.department.equals(that.department) &&
			this.number.equals(that.number);
	}

	//page 299
	@Override
	public int hashCode() {
		final int hashMultiplier = 41;
		int result = 7;
		result = result * hashMultiplier + department.hashCode();
		result = result * hashMultiplier + number.hashCode();
		return result;
		//return 1;
	}
}
