package code.lucamarrocco.wiki.ast;

import code.lucamarrocco.wiki.ast.BodyDeclaration;
import code.lucamarrocco.wiki.ast.DefaultText;
import code.lucamarrocco.wiki.ast.Node;
import code.lucamarrocco.wiki.ast.Text;

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
