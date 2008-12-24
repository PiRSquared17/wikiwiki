package code.lucamarrocco.wiki.ast;

import junit.framework.*;

/** @author Luca Marrocco */
public class ContentTest extends TestCase {
	private BodyDeclaration BODY_DECLARATION = new Text();

	private Content content;

	public void testAddBodyDeclaration() {
		content.addBodyDeclaration(BODY_DECLARATION);
		assertTrue(content.iterator().hasNext());
		assertTrue(content.iterator().next().equals(BODY_DECLARATION));
	}

	@Override
	protected void setUp() throws Exception {
		content = new Content() {
			public <A> void accept(code.lucamarrocco.wiki.ast.Visitor<A> visitor, A arg) {}
		};
	}

	public void testDefaultContent() {
		assertNotNull(content);

		assertTrue(content instanceof Node);
		assertTrue(content instanceof Content);
		assertTrue(content instanceof Node);

		assertNotNull(content.iterator());
		assertFalse(content.iterator().hasNext());
	}
}
