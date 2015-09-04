package agile.java.chapter09;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class Chapter09Practice01 extends TestCase {
	final String source = "Hundreds of thousands of refugees fleeing wars, "
			+ "as well as economic migrants escaping poverty, "
			+ "have arrived in the European Union, confounding EU leaders and feeding the "
			+ "rise of right wing populists."
			+ "Thousands have drowned in the Mediterranean and many others have died "
			+ "travelling over land, including 71 people found in the back of an abandoned "
			+ "truck in Austria last week."
			+ "The EU's executive European Commission promised to unveil a new policy next week "
			+ "to make it easier to process asylum claims, send those from safe countries home and "
			+ "distribute bona fide refugees among the bloc's 28 members.";

	//String[] words = source.split("\\W+");
	
	private Map<String, Integer> wordCount = new HashMap<String, Integer>();
	
	@Override
	protected void setUp() {
	}
	//-----------------------------
	private int getCount(String word) {
		String lowerWord = word.toLowerCase();
		if (wordCount.containsKey(lowerWord))
			return wordCount.get(lowerWord);
		else
			return 0;
	}
	
	private void setCount(String word, int count) {
		String lowerWord = word.toLowerCase();
		wordCount.put(lowerWord, count);
	}
	
	private void initCounter(String fullString) {
		String[] words = fullString.split("\\W+");
		
		for(String word: words) 
			setCount(word, getCount(word)+1);
	}
	//------------------------------
		public void testGetCount() {
		initCounter("this is a test.");
		
		assertEquals(0, getCount("that"));
		assertEquals(1, getCount("this"));
	}
		
	public void testSetCount() {
		initCounter("this is a test.");
		assertEquals(0, getCount("that"));
		setCount("that", 1);
		assertEquals(1, getCount("that"));
	}
	
	public void testInitCounter() {
		wordCount.clear();
		String testString = "this is a test.";
		initCounter(testString);
		assertEquals(4, wordCount.size());
		
		wordCount.clear();
		testString = "This thIS this THIS.";
		initCounter(testString);		
		assertEquals(4, getCount("this"));
	}
	//------------------------------
	public void testGetWordCount() {
		initCounter(source);
		for(String word : wordCount.keySet()) 
			System.out.println(
					String.format("word<%s>, count:<%d>", word, wordCount.get(word)));	
	}	
//	private void getWordCount(){
//		for(String word: words) {
//			if(wordCount.containsKey(word))
//		}
//	}
//	

}
