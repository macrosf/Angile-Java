package agile.java.sis.studentinfo.test;

import java.math.BigDecimal;

import agile.java.sis.studentinfo.Account;
import junit.framework.TestCase;

public class AccountTest extends TestCase {
	//page 313
	public void testTransaction() {
		Account account = new Account();
		account.credit(new BigDecimal("0.10"));
		account.credit(new BigDecimal("11.00"));
		assertEquals(new BigDecimal("11.10"), account.getBalance());
	}
	
	//page 315
	public void testTransactionAverage() {
		Account account = new Account();
		account.credit(new BigDecimal("0.10"));
		account.credit(new BigDecimal("11.00"));
		account.credit(new BigDecimal("2.99"));
		assertEquals(new BigDecimal("4.70"), account.transactionAverage());
	}
	
	//page 425
	private Account account;
	
	@Override
	protected void setUp() {
		account = new Account();
	}
	
	public void testWithdraw() throws Exception {
		account.credit(new BigDecimal("100"));
		account.withdraw(new BigDecimal("40"));
		assertEquals(new BigDecimal("60.00"), account.getBalance());
	}
	
	public void testWithdrawInsufficientFunds() {
		account.credit(new BigDecimal("100"));
		account.withdraw(new BigDecimal("140"));
		assertEquals(new BigDecimal("100.00"), account.getBalance());
	}
}
