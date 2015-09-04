package agile.java.sis.studentinfo.test;

import java.math.BigDecimal;

import agile.java.sis.studentinfo.Account;
import junit.framework.TestCase;

public class AccountTest extends TestCase {
	public void testTransaction() {
		Account account = new Account();
		account.credit(new BigDecimal("0.10"));
		account.credit(new BigDecimal("11.00"));
		assertEquals(new BigDecimal("11.10"), account.getBalance());
	}
}
