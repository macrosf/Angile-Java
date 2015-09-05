package agile.java.util;

public class ParityChecker {
	//page 327
	public byte checksum(byte[] bytes) {
		byte checksum = bytes[0];
		for(int i = 1; i<bytes.length; i++)
			checksum ^= bytes[i];
		
		return checksum;
	}
}
