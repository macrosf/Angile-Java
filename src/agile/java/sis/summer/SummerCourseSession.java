package agile.java.sis.summer;


//public class SummerCourseSession extends CourseSession {
//
//	public static SummerCourseSession create(
//			String department,
//			String number,
//			Date startDate) {
//		return new SummerCourseSession(department, number, startDate);
//	}
//
//	private SummerCourseSession(
//			String department,
//			String number,
//			Date startDate) {
//		super(department, number, startDate);
//	}
//
////	@Override
////	public Date getEndDate() {
////		GregorianCalendar calendar = new GregorianCalendar();
////		calendar.setTime(getStartDate());
////		final int sessionLength = 8;
////		final int daysInWeek = 7;
////		final int daysFromFridayToMonday = 3;
////		int numberOfDays =
////				sessionLength * daysInWeek - daysFromFridayToMonday;
////		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
////		return calendar.getTime();
////	}
//
//	@Override
//	protected int getSessionLength() {
//		return 8;
//	}
//}
