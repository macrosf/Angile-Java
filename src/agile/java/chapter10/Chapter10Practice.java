package agile.java.chapter10;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import junit.framework.TestCase;

public class Chapter10Practice extends TestCase {

	//page 334 - exercise 1
	public void testExercise01() {
		BigDecimal decimal1 = new BigDecimal("10");
		BigDecimal decimal2 = decimal1.add(new BigDecimal("20"));

		assertEquals(new BigDecimal("30"), decimal2);
		assertEquals(new BigDecimal("10"), decimal1);
	}

	//exercise 2
	public void testExercise02() {
		BigDecimal decimal1 = new BigDecimal("10.00");
		BigDecimal decimal2 = new BigDecimal("1");

		assertFalse(decimal1.equals(decimal2));

		assertEquals(decimal1, decimal2.multiply(decimal1));
		assertEquals(decimal2, decimal1.multiply(new BigDecimal("0.10")).setScale(0));
	}

	//exercise 3
	@SuppressWarnings("unused")
	public void testExercise03() {
		assertNotEquals(0.9, 0.005*0.2);

		float f1 = 0.9f;
		float f2 = 0.005f *2.0f;
		assertNotEquals(f1, f2);
//		System.out.println(f1);
//		System.out.println(f2);

		double d1 = 0.9d;
		double d2 = 0.05d*2.0d;
		double d3 = (3.3-2.4)/0.1;
		assertNotEquals(d1, d2);
//		System.out.println(d1);
//		System.out.println(d2);
//		System.out.println(d3);	//8.999999999999998
	}

	public void testExercise04() {
//		float x = 0.01f;
//		float y = (float)0.01;
	}

	@SuppressWarnings("unused")
	public void testExercise05() {
		int i = Integer.decode("0xDEAD");
		String s = Integer.toOctalString(i);
		int j =Integer.parseInt(s, 8);
//		System.out.println(i);
//		System.out.println(s);
//		System.out.println(j);
		assertEquals(0157255, Integer.parseInt(s, 8));
		assertEquals("157255", Integer.toString(0xDEAD, 8));
	}

	@SuppressWarnings("unused")
	public void testExercise10() {
		float x = 1;
		//float y = 1.0;	//compile error
		float z = (int)1.0;
		double d = 1.0;
	}

	public void testExercise11() {
//		System.out.println((int)1.9);	//output: 1
	}

	public void testExercise12() {
//		System.out.println(Math.rint(1.9));	//output: 2.0
	}

	public void testExercise16() {
//		System.out.println(~1);	//-2
//		System.out.println(~0);	//-1
	}
}
