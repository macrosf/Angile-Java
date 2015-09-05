package agile.java.sis.studentinfo;

import java.math.BigDecimal;

public class Account {
	//page 314	
	private BigDecimal balance = new BigDecimal("0.00");
	private int transactionCount = 0;
	
	public void credit(BigDecimal amount) {
		balance = balance.add(amount);
		transactionCount++;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

	//page 315
	public BigDecimal transactionAverage() {
		return balance.divide(
				new BigDecimal(transactionCount), BigDecimal.ROUND_HALF_UP);
	}
}
