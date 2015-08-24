package agile.java.sis.studentinfo;

import agile.java.sis.studentinfo.Student.Grade;

public interface GradingStrategy {
	int getGradePointsFor(Grade grade);
}
