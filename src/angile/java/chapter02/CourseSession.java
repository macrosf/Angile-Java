package angile.java.chapter02;

import java.util.ArrayList;

import angile.java.chapter01.Student;

public class CourseSession {
	private String department;
	private String number;
	private int numberOfStudents=0;
	private java.util.ArrayList<Student> students = new ArrayList<Student>();
	
	public CourseSession(String department, String number){
		this.department = department;
		this.number = number;
	}
	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	public void enroll(Student student) {
		numberOfStudents++;
		students.add(student);
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
	
}
