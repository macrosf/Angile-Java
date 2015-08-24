package agile.java.sis.studentinfo;

import agile.java.sis.studentinfo.Student.Grade;

public class HonorsGrandingStrategy
	extends BasicGrandingStrategy{

	@Override
	public int getGradePointsFor(Grade grade) {
		//int point = RegularGradingStrategy.basicGradePointsFor(grade);
		int point = basicGradePointsFor(grade);
		if (point >0)
			point += 1;
		return point;
	}

}
