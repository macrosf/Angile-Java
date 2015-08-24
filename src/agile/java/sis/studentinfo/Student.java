package agile.java.sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class Student {
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	public enum Grade {A, B, C, D, E, F};

	private String name;
	private int credits;
	//private ArrayList<String> grades = new ArrayList<String>();
	private List<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy = new RegularGradingStrategy();

	public Student(String name) {
		setName(name);
		setCredits(0);
	}

//	void addGrade(String grade) {
//		grades.add(grade);
//	}

	void addGrade(Grade grade) {
		grades.add(grade);
	}

	double getGpa() {
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

	void addCredits(int credits) {
		this.credits += credits;
	}

	boolean isFullTime() {
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
}
