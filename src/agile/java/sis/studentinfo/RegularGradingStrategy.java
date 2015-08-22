package agile.java.sis.studentinfo;

import agile.java.sis.studentinfo.Student.Grade;

public class RegularGradingStrategy implements GradingStrategy {

	@Override
	public  int getGradePointFor(Grade grade) {
		return basicGradePointsFor(grade);
	}

	public static int basicGradePointsFor(Grade grade) {
		if (grade == Grade.A) return 4;
		if (grade == Grade.B) return 3;
		if (grade == Grade.C) return 2;
		if (grade == Grade.D) return 1;
		return 0;		
	}
}
