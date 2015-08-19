package agile.java.chess;

import junit.framework.TestCase;

public class CharacterTest extends TestCase {

	public void testIsWhitespace() {
		assertEquals(true, Character.isWhitespace('\t'));
		assertEquals(true, Character.isWhitespace('\r'));
		assertEquals(true, Character.isWhitespace('\n'));
		assertEquals(true, Character.isWhitespace(' '));

		assertEquals(false, Character.isJavaIdentifierPart('^'));
		assertEquals(false, Character.isJavaIdentifierPart('#'));
		assertEquals(false, Character.isJavaIdentifierPart('*'));
		assertEquals(false, Character.isJavaIdentifierPart('@'));
		assertEquals(false, Character.isJavaIdentifierPart('!'));
		assertEquals(false, Character.isJavaIdentifierPart('~'));
	}
}
