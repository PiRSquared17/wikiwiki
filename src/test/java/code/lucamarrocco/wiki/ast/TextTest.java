package code.lucamarrocco.wiki.ast;

import junit.framework.TestCase;

/** @author Luca Marrocco */
public class TextTest extends TestCase {
	private static final String VALUE = "VALUE";

	public void testDefaultText() {
		Text text = new Text();

		assertNotNull(text);
		assertTrue(text instanceof Node);
		assertTrue(text instanceof Text);
		assertTrue(text instanceof BodyDeclaration);
	}

	public void testSetValue() {
		Text text = new Text();

		assertEquals(text, text.setValue(VALUE));
		assertEquals(VALUE, text.getValue());
	}
}
