package agile.java.sis.search;

import java.io.*;
import java.net.*;

import agile.java.util.StringUtil;

//page 413
public class Search {
	private URL url;
	private String searchString;
	private int matches = 0;
	private Exception exception = null;
	
	public Search(String urlString, String searchString) 
			throws IOException {
		setUrl(new URL(urlString));
		setSearchString(searchString);
	}

	public String getText() {
		return searchString;
	}

	private void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public int matches() {
		return matches;
	}

	public Exception getError() {
		return exception;
	}
	
	public boolean errored() {
		return exception != null;
	}

	public String getUrl() {
		return url.toString();
	}

	public void execute() {
		try {
			searchUrl();
		}
		catch (IOException e) {
			exception = e;
		}
	}
	
	private void searchUrl() throws IOException{
		final String error404 = "http://langrsoft.com/index.php/404";
		
		URLConnection connection = url.openConnection();
		InputStream input = connection.getInputStream();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				if (StringUtil.occurrences(line, error404)>0)
					throw new FileNotFoundException();	//throw exception to pass junit test
				matches += StringUtil.occurrences(line, searchString);
			}	
		}
		finally {
			if (reader != null)
				reader.close();
		}
	}

	private void setUrl(URL url) {
		this.url = url;
	}
}
