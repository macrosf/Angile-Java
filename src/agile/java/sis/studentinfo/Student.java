package agile.java.sis.studentinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import agile.java.sis.studentinfo.exception.StudentNameFormatException;

public class Student {
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	public static final int MAX_NAME_PARTS = 3;
	public static final String TOO_MANY_NAME_PARTS_MSG = 
			"Student name '%s' contains more than %d parts";
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

	//page 268
	public final static Logger logger =
			Logger.getLogger(Student.class.getName());
	
	public Student(String fullName) {
		setName(fullName);
		setCredits(0);
		List<String> nameParts = split(fullName);
		//page 251
		final int maximumNumberOfNameParts = 3;
		if (nameParts.size() > maximumNumberOfNameParts) {
			String message = 
					String.format(TOO_MANY_NAME_PARTS_MSG,
							fullName, MAX_NAME_PARTS);
			//log(message);
			//page 268
			Student.logger.info(message);
		
			throw new StudentNameFormatException(message);
		}
			
		setName(nameParts);
	}

//	void addGrade(String grade) {
//		grades.add(grade);
//	}
//	//page 263
//	private void log(String message) {
//		Logger logger = Logger.getLogger(getClass().getName());
//		logger.info(message);
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
		Student.logger.fine("begin getGpa " + System.currentTimeMillis());
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
		double result = total / grades.size();
		Student.logger.fine("end getGpa " + System.currentTimeMillis());
		return result;
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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//page 283
	private String id;
	
	//page 324
	public enum Flag {
		ON_CAMPUS(1),
		TAX_EXEMPT(2),
		MINOR(4),
		TROUBLEMAKER(8);
		
		private int mask;
		
		Flag(int mask) {
			this.setMask(mask);
		}

		public int getMask() {
			return mask;
		}

		private void setMask(int mask) {
			this.mask = mask;
		}
	}
	
	private int settings = 0x0;
	
	public void set(Flag... flags) {
		for (Flag flag: flags) 
			setSettings(getSettings() | flag.getMask());
	}
	
	public void unset(Flag... flags) {
		for(Flag flag: flags)
			setSettings(getSettings() & ~flag.getMask());
	}

	public boolean isOn(Flag flag) {
		return (settings&flag.mask) == flag.mask;
	}
	
	public boolean isOff(Flag flag) {
		return !isOn(flag);
	}
	public int getSettings() {
		return settings;
	}

	public void setSettings(int settings) {
		this.settings = settings;
	}
}
