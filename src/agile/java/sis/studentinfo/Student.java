package agile.java.sis.studentinfo;

public class Student {
	private String name;
	private int credits;
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	
	public Student(String name) {
		setName(name);
		setCredits(0);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	private void setCredits(int credits) {
		this.credits = credits;
	}

	public void addCredits(int credits) {
		this.credits += credits;
	}

	boolean isFullTime() {
		return credits>=CREDITS_REQUIRED_FOR_FULL_TIME;
	}
}
