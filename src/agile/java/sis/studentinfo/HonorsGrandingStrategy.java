package agile.java.sis.studentinfo;

import agile.java.sis.studentinfo.Student.Grade;

public class HonorsGrandingStrategy implements GradingStrategy {

	@Override
	public int getGradePointFor(Grade grade) {
		int point = RegularGradingStrategy.basicGradePointsFor(grade);
		if (point >0)
			point += 1;
		return point;
	}

}
