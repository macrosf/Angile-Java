package agile.java.sis.studentinfo.test;

import java.math.BigDecimal;

import agile.java.sis.studentinfo.Account;
import junit.framework.*;

//page 426
public class MultithreadedAccountTest extends TestCase {
	
//	public void testConcurrency() throws Exception {
//		final int threadCount = 2;
//		Thread[] threads = new Thread[threadCount];
//		
//		class RunnableAccount implements Runnable {
//			final Account account = new Account();
//			{
//				account.credit(new BigDecimal("100"));
//			}
//
//			@Override
//			public void run() {
//				account.withdraw(new BigDecimal("80"));
//			}
//			
//			BigDecimal getBalance() {
//				return account.getBalance();
//			}
//		}
//		
//		RunnableAccount account =  new RunnableAccount();
//		
//		for (int i=0; i<threadCount; i++) {
//			threads[i] = new Thread(account);
//			threads[i].start();
//		}
//		
//		for (Thread thread: threads)
//			thread.join();
//
//		assertEquals(new BigDecimal("20.00"), account.getBalance());	
//	}
	public void testConcurrency() throws Exception {
		final int threadCount = 2;
		Thread[] threads = new Thread[threadCount];
		final Account account = new Account();
		account.credit(new BigDecimal("100"));
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				account.withdraw(new BigDecimal("80"));
			}		
		};

		for (int i=0; i<threadCount; i++) {
			threads[i] = new Thread(runnable);
			threads[i].start();
		}
		
		for (Thread thread: threads)
			thread.join();

		assertEquals(new BigDecimal("20.00"), account.getBalance());	
	}	
}
