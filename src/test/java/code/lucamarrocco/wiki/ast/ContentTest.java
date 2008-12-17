package code.lucamarrocco.wiki.ast;

import junit.framework.*;

/** @author Luca Marrocco */
public class ContentTest extends TestCase {
	private BodyDeclaration BODY_DECLARATION = new Text();

	public void testAddBodyDeclaration() {
		Content content = new Content();
		content.addBodyDeclaration(BODY_DECLARATION);
		assertTrue(content.iterator().hasNext());
		assertTrue(content.iterator().next().equals(BODY_DECLARATION));
	}

	public void testDefaultContent() {
		Content content = new Content();

		assertNotNull(content);

		assertTrue(content instanceof Node);
		assertTrue(content instanceof Content);
		assertTrue(content instanceof Node);

		assertNotNull(content.iterator());
		assertFalse(content.iterator().hasNext());
	}
}
