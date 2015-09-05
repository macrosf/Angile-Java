package agile.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

//page 327
public class ParityCheckerTest extends TestCase {
	public void testSingleByte() {
		ParityChecker checker = new ParityChecker();
		byte source1 = 10;	//1010
		byte source2 = 13;	//1101
		byte source3 = 2;	//0010
		
		byte[] data = new byte[] {source1, source2, source3};
		
		byte checksum = 5;	//0101
		
		assertEquals(checksum, checker.checksum(data));
		
		// corrupt the source2 element
		data[1] = 14;	//1110
		
		assertFalse(checksum == checker.checksum(data));
	}
	
	//page 332
	public void testCoinFlips() {
		final long seed = 100L;
		final int  total = 10;
		Random random1 = new Random(seed);
		List<Boolean> flips1 = new ArrayList<Boolean>();
		for (int i=0; i<total; i++)
			flips1.add(random1.nextBoolean());
		
		Random random2 = new Random(seed);
		List<Boolean> flips2 = new ArrayList<Boolean>();
		for (int i=0; i<total; i++)
			flips2.add(random2.nextBoolean());
		
		assertEquals(flips1, flips2);
	}
}
