package agile.java.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//line 416
public class LineWriter {
	public static void write(String filename, String[] records) throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filename));
			for ( int i=0; i<records.length; i++) {
				writer.write(records[i]);
				writer.newLine();
			}
		}
		finally {
			if (writer != null)
				writer.close();
		}
	}
}
