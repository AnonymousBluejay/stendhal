package games.stendhal.server.entity.npc.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test the NPC conversation PunctuationParser class.
 * 
 * @author Martin Fuchs
 */
public class PunctuationParserTest {

	@Test
	public final void testWordEntry() {
		PunctuationParser p = new PunctuationParser("... hello?");
		assertEquals(" hello", p.getText());
		assertEquals("...", p.getPrecedingPunctuation());
		assertEquals("?", p.getTrailingPunctuation());

		p = new PunctuationParser("hello world !");
		assertEquals("hello world ", p.getText());
		assertEquals("", p.getPrecedingPunctuation());
		assertEquals("!", p.getTrailingPunctuation());
	}
	@Test
	public final void tesNullEntry() {
		PunctuationParser p = new PunctuationParser(null);
		assertEquals(null, p.getText());
		assertEquals("", p.getPrecedingPunctuation());
		assertEquals("", p.getTrailingPunctuation());
	
		
	}
	@Test
	public final void testOnlyPunctuation() {
		String s = ".,?!";
		PunctuationParser p = new PunctuationParser(s);
		assertEquals("", p.getText());
		assertEquals(".,?!", p.getPrecedingPunctuation());
		assertEquals("", p.getTrailingPunctuation());
	}
	
	@Test
	public final void testEmptyString() {
		PunctuationParser p = new PunctuationParser("");
		assertEquals("", p.getText());
		assertEquals("", p.getPrecedingPunctuation());
		assertEquals("", p.getTrailingPunctuation());
	
		
	}
	@Test
	public final void testOnlyspacePunctuation() {
		PunctuationParser p = new PunctuationParser(".,?! ");
		assertEquals(" ", p.getText());
		assertEquals(".,?!", p.getPrecedingPunctuation());
		assertEquals("", p.getTrailingPunctuation());
		p = new PunctuationParser(" .,?!");
		assertEquals(" ", p.getText());
		assertEquals("", p.getPrecedingPunctuation());
		assertEquals(".,?!", p.getTrailingPunctuation());
	
		
	}

}
