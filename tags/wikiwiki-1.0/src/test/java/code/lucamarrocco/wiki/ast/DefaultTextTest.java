package code.lucamarrocco.wiki.ast;

import junit.framework.TestCase;

public class DefaultTextTest extends TestCase {
	private static final String VALUE = "VALUE";

	public void testDefaultText() {
		DefaultText text = new DefaultText();

		assertNotNull(text);

		assertTrue(text instanceof Node);

		assertTrue(text instanceof Text);

		assertTrue(text instanceof BodyDeclaration);
	}

	public void testSetValue() {
		DefaultText text = new DefaultText();

		assertEquals(text, text.setValue(VALUE));

		assertEquals(VALUE, text.getValue());
	}
}