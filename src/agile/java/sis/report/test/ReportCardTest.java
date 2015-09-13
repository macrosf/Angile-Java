package agile.java.sis.report.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;
import agile.java.sis.report.Entry;
import agile.java.sis.report.ReportCard;
import agile.java.sis.studentinfo.Student;

public class ReportCardTest extends TestCase {
	private ReportCard card;

	protected void setUp() {
		card = new ReportCard();
	}

	public void testMessage() {
		// ReportCard card = new ReportCard();
		assertEquals(ReportCard.A_MESSAGE, card.getMessage(Student.Grade.A));
		assertEquals(ReportCard.B_MESSAGE, card.getMessage(Student.Grade.B));
		assertEquals(ReportCard.C_MESSAGE, card.getMessage(Student.Grade.C));
		assertEquals(ReportCard.D_MESSAGE, card.getMessage(Student.Grade.D));
		assertEquals(ReportCard.F_MESSAGE, card.getMessage(Student.Grade.F));
	}

	// page 303
	public void testKeys() {
		Set<Student.Grade> expectedGrades = new HashSet<Student.Grade>();
		expectedGrades.add(Student.Grade.A);
		expectedGrades.add(Student.Grade.B);
		expectedGrades.add(Student.Grade.C);
		expectedGrades.add(Student.Grade.D);
		expectedGrades.add(Student.Grade.F);

		Set<Student.Grade> grades = new HashSet<Student.Grade>();
		for (Student.Grade grade : card.getMessages().keySet()) {
			grades.add(grade);
		}
		assertEquals(expectedGrades, grades);

		assertEquals(expectedGrades, card.getMessages().keySet());
	}

	// page 304
	public void testValues() {
		List<String> expectedMessages = new ArrayList<String>();
		expectedMessages.add(ReportCard.A_MESSAGE);
		expectedMessages.add(ReportCard.B_MESSAGE);
		expectedMessages.add(ReportCard.C_MESSAGE);
		expectedMessages.add(ReportCard.D_MESSAGE);
		expectedMessages.add(ReportCard.F_MESSAGE);

		Collection<String> messages = card.getMessages().values();
		for (String message : messages)
			assertTrue(expectedMessages.contains(message));
		assertEquals(expectedMessages.size(), messages.size());
	}

	// page 305
	public void testEntries() {
		int i = 0;

		Set<Entry> entries = new HashSet<Entry>();
		for (Map.Entry<Student.Grade, String> entry : card.getMessages()
				.entrySet()) {
			entries.add(new Entry(entry.getKey(), entry.getValue()));
			System.out.println("Map.Entry[" + (i++) + "]:" + entry.hashCode());
		}

		Set<Entry> expectedEntries = new HashSet<Entry>();
		expectedEntries.add(new Entry(Student.Grade.A, ReportCard.A_MESSAGE));
		expectedEntries.add(new Entry(Student.Grade.B, ReportCard.B_MESSAGE));
		expectedEntries.add(new Entry(Student.Grade.C, ReportCard.C_MESSAGE));
		expectedEntries.add(new Entry(Student.Grade.D, ReportCard.D_MESSAGE));
		expectedEntries.add(new Entry(Student.Grade.F, ReportCard.F_MESSAGE));

		i = 0;
		for (Entry entry : expectedEntries)
			System.out.println(String.format(
					"expectedEntries[%d]'s hashCode:%s, "
							+ "grade's hashCode:%s", i++, entry.hashCode(),
					entry.getGrade().hashCode()));
		//
		// i=0;
		// for (Entry entry: entries)
		// System.out.println(
		// String.format("entries[%d]:%s, "
		// + "grade's hashCode:%s",
		// i++, entry.hashCode(),
		// entry.getGrade().hashCode()));

		assertEquals(expectedEntries, entries);

		//assertEquals(expectedEntries, card.getMessages().entrySet()); //not work
	}

	//page 306
	public void testKey() {
		Set<Student.Grade> expectedGrades =
				EnumSet.allOf(Student.Grade.class);
		Set<Student.Grade> grades =
				EnumSet.noneOf(Student.Grade.class);
		for (Student.Grade grade: card.getMessages().keySet())
			grades.add(grade);
		assertEquals(expectedGrades, grades);
	}
}
