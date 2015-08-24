package agile.java.sis.studentinfo;


//abstract public class BasicGrandingStrategy implements GradingStrategy{
//
//	abstract public int getGradePointsFor(Student.Grade grade);
//
//	int basicGradePointsFor(Grade grade) {
////		if (grade == Grade.A) return 4;
////		if (grade == Grade.B) return 3;
////		if (grade == Grade.C) return 2;
////		if (grade == Grade.D) return 1;
////		return 0;
//		switch(grade) {
//			case A : return 4;
//			case B : return 3;
//			case C : return 2;
//			case D : return 1;
//			default: return 0;
//		}
//	}
//}

//page 187: extend method
//public class BasicGrandingStrategy implements GradingStrategy{
//
//	public int getGradePointsFor(Student.Grade grade) {
//		return basicGradePointsFor(grade);
//	}
//
//	int basicGradePointsFor(Grade grade) {
//		switch(grade) {
//			case A : return 4;
//			case B : return 3;
//			case C : return 2;
//			case D : return 1;
//			default: return 0;
//		}
//	}
//}

//page 189: reconstruct
public class BasicGrandingStrategy implements GradingStrategy{

	public int getGradePointsFor(Student.Grade grade) {
		//page 190: emun pro
//		switch(grade) {
//			case A : return 4;
//			case B : return 3;
//			case C : return 2;
//			case D : return 1;
//			default: return 0;
//		}

		return grade.getPoints();
	}
}
