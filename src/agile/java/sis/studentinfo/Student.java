package agile.java.sis.studentinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import agile.java.sis.studentinfo.exception.StudentNameFormatException;

public class Student {
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	//public enum Grade {A, B, C, D, E, F};
	//page 190: emun pro
	public enum Grade {
		A(4), B(3), C(2), D(1), F(0);
		private int points;

		Grade(int points){
			this.points = points;
		}

		int getPoints() {
			return points;
		}
	}

	private String name;
	private int credits;
	//private ArrayList<String> grades = new ArrayList<String>();
	private List<Grade> grades = new ArrayList<Grade>();
	//page 189: reconstruct
	//private GradingStrategy gradingStrategy = new RegularGradingStrategy();
	private GradingStrategy gradingStrategy = new BasicGrandingStrategy();
	//page 212
	private String firstName = "";
	private String middleName = "";
	private String lastName;

	public Student(String fullName) {
		setName(fullName);
		setCredits(0);
		List<String> nameParts = split(fullName);
		//page 251
		final int maximumNumberOfNameParts = 3;
		if (nameParts.size() > maximumNumberOfNameParts)
			throw new StudentNameFormatException("xxxx");
		setName(nameParts);
	}

//	void addGrade(String grade) {
//		grades.add(grade);
//	}

	private void setName(List<String> nameParts) {
//		if (nameParts.size() == 1)
//			this.lastName = nameParts.get(0);
//		else if (nameParts.size() ==2) {
//			this.firstName = nameParts.get(0);
//			this.lastName = nameParts.get(1);
//		}
//		else if (nameParts.size() == 3) {
//			this.firstName = nameParts.get(0);
//			this.middleName = nameParts.get(1);
//			this.lastName = nameParts.get(2);
//		}
		//page 214
		this.lastName = removeLast(nameParts);
		String name = removeLast(nameParts);
		if (nameParts.isEmpty())
			this.firstName = name;
		else {
			this.middleName = name;
			this.firstName = removeLast(nameParts);
		}
	}

	private String removeLast(List<String> list) {
		if (list.isEmpty())
			return "";
		return list.remove(list.size() - 1);
	}

//	private List<String> split(String fullName) {
//		List<String> results = new ArrayList<String>();
//		StringBuffer word = new StringBuffer();
//		for(int i=0; i<fullName.length(); i++) {
//			char ch = fullName.charAt(i);
//
//			if (!Character.isWhitespace(ch))
//				word.append(ch);
//			else
//				if(word.length()>0) {
//					results.add(word.toString());
//					word = new StringBuffer();
//				}
//		}
//
//		if(word.length()>0)
//			results.add(word.toString());
//		return results;
//	}

	//page 240
	private List<String> split(String fullName) {
		//solution 1
		//return Arrays.asList(fullName.split(" "));		//not work
		
		//solution 2
//		List<String> results = new ArrayList<String>();
//		List<String> parts = Arrays.asList(fullName.split(" "));
//		for (String part: parts)
//			results.add(part);
//		return results;
		
		//solution 3
		List<String> parts = Arrays.asList(fullName.split(" "));
		return new ArrayList<String>(parts);
	}
	
	public void addGrade(Grade grade) {
		grades.add(grade);
	}

	public double getGpa() {
		if (grades.isEmpty())
			return 0.0;

		double total = 0.0;
//		for(String grade : grades) {
////			if ("A".compareTo(grade)<=0 && "E".compareTo(grade)>=0)
////				total += ( 'E' - grade.charAt(0) );
//			total +=gradePointFor(grade);
//		}
		for (Grade grade : grades) {
			//total +=gradePointFor(grade);
			total += gradingStrategy.getGradePointsFor(grade);
		}
		return total / grades.size();
	}

//	private int gradePointFor(String grade) {
//		if ("A".equals(grade)) return 4;
//		if ("B".equals(grade)) return 3;
//		if ("C".equals(grade)) return 2;
//		if ("D".equals(grade)) return 1;
//		return 0;
//	}

//	private int gradePointFor(Grade grade) {
////		if (grade == Grade.A) return 4;
////		if (grade == Grade.B) return 3;
////		if (grade == Grade.C) return 2;
////		if (grade == Grade.D) return 1;
////		return 0;
//		return gradingStrategy.getGradePointFor(grade);
//	}

	public void addCredits(int credits) {
		this.credits += credits;
	}

	public boolean isFullTime() {
		return credits>=CREDITS_REQUIRED_FOR_FULL_TIME;
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

	public void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}
}
