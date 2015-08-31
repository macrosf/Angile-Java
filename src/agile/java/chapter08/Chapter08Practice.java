package agile.java.chapter08;

import junit.framework.TestCase;


public class Chapter08Practice extends TestCase{
	final String MESSAGE = "Somebody should catch this!";

	//exercise 02
	public void testBlowUp() {

		try	{
			blowUp();
			fail("excepted exception not catched!");
		}
		catch(RuntimeException expected) {
			assertEquals(MESSAGE, expected.getMessage());
		}
	}

	//exercise 04
	public void testRethrows() {
		try {
			rethrows();
		}
		catch (RuntimeException expected) {
			//expected.getCause().printStackTrace();
			//expected.printStackTrace();
		}
	}

	void blowUp() {
		//throw new RuntimeException(MESSAGE);
		throw new SimpleException(MESSAGE);
	}

	void rethrows() {
		try {
			blowUp();
		}
		catch (RuntimeException expected) {
			throw new RuntimeException(expected);
			//throw new RuntimeException();
		}
	}

	//exercise 05
	void blowUp2() {
		//throw new RuntimeException(MESSAGE);
		throw new SimpleException(MESSAGE);
	}

	public void testBlowUp2() {
		try {
			blowUp2();
			fail("expected exception not catched!");
		}
		catch (RuntimeException expected) {
			//System.out.println("catched!");
			//throw new RuntimeException();
			assertEquals(MESSAGE, expected.getMessage());
		}
	}

	//exercise 06
	public void testExceptionOrder1() {
		try {
			blowUp();
			rethrows();
			fail("no exception");
		}
		catch (SimpleException yours) {
			fail("catch wrong exception");
		}
		catch (RuntimeException success) {

		}
	}

	public void testExceptionOrder2() {
		try {
			rethrows();
			blowUp();
			fail("no exception");
		}
		catch (SimpleException success) {
		}
		catch (RuntimeException yours) {
			fail("catch wrong exception");
		}
	}

	public void testExceptionOrder3() {
		try {
			blowUp();
			rethrows();
			fail("no exception");
		}
		catch (RuntimeException success) {

		}
//		catch (SimpleException yours) {	//compile error
//			fail("catch wrong exception");
//		}
	}

	public void testExceptionOrder4() {
		try {
			blowUp();
			rethrows();
			fail("no exception");
		}
		catch (SimpleException yours) {
			fail("catch wrong exception");
		}
		catch (RuntimeException fail) {
			fail("exception unacceptable");
		}
		finally {
			//return;	//cause warning, and maks catch block invalid
		}
	}

	public void testExceptionOrder5() {
		try {
			blowUp();
			rethrows();
			fail("no exception");
		}
		catch (SimpleException success) {
		}
		catch (RuntimeException fail) {
			fail("catch wrong exception");
		}
	}

	public void testExceptionOrder6() {
		try {
			rethrows();
			blowUp();
			fail("no exception");
		}
		catch (SimpleException yours) {
			fail("catch wrong exception");
		}
		catch (RuntimeException success) {
		}
	}

	//page 277
	public void testErrorException1() {
		try {
			throw new RuntimeException("fail");
		}
		catch (Exception success) {
			System.out.println("testErrorException1: catched!");
		}
	}

	public void testErrorException2() {
		try {
			new Dyer();
		}
		catch (Exception success) {
			System.out.println("testErrorException2: catched!");
		}
	}

	public void testErrorException3() {
		try {
			new Dyer();
		}
		catch (Error success) {	//can't catch Exception
			System.out.println("testErrorException3: catched!");
		}
	}

	public void testErrorException4() {
		try {
			new Dyer();
		}
		catch (Throwable success) {	//Exception catched
			System.out.println("testErrorException4: catched!");
		}
	}

	public void testErrorException5() {
		try {
			new Dyer();
		}
		catch (Throwable fail) {	//Exception catched
			fail("catch exception in wrong place");
		}
//		catch (Error success) {		//compile error
//
//		}
	}

	public void testErrorException6() {
		try {
			new Dyer();
		}
		catch (Error fail) {		//compile error
			fail("catch exception in wrong place");
		}
		catch (Throwable success) {	//Exception catched
			System.out.println("testErrorException6: catched!");
		}
	}

	public void testErrorException7() {
		try {
			new Dyer();
		}
		catch (Error fail) {		//compile error
			fail("catch exception in wrong place");
		}
		catch (Throwable success) {	//Exception catched
			System.out.println("testErrorException6: catched!");
			//success.printStackTrace();
			fail("catch exception in wrong place2");
		}
//		finally {
//			return;		//cause warning, and makes fail statement invalid
//		}
	}

	class Dyer {
		Dyer() {
			throw new RuntimeException("oops.");
		}
	}

	//exercise 07
	public void testWithProblems() {
		try {
			doSomething();
			fail("no exception");
		}
		catch (Exception success) {
		}
	}

	void doSomething() throws Exception {
		throw new Exception("blah");
	}

//	public void testDoSomething2() {
//		doSomething2();
//	}
//
//	void doSomething2() {
//		throw new RuntimeException("blah");
//	}
}

