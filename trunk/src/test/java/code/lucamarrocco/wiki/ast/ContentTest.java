package code.lucamarrocco.wiki.ast;

import org.jmock.*;

public class ContentTest extends TestCase {
	private BodyDeclaration BODY_DECLARATION = new Text();

	public void testAddBodyDeclaration() {
		Content content = new Content();

		content.addBodyDeclaration(BODY_DECLARATION);

		assertTrue(content.getBodyDeclarations().contains(BODY_DECLARATION));
		assertTrue(content.getChildren().contains(BODY_DECLARATION));
		assertEquals(1, content.getBodyDeclarations().size());
	}

	public void testDefaultContent() {
		Content content = new Content();

		assertNotNull(content);
		assertNotNull(content.getBodyDeclarations());
		assertTrue(content.getBodyDeclarations().isEmpty());
		assertTrue(content instanceof Node);
		assertTrue(content instanceof Content);
		assertTrue(content instanceof Node);
	}
}
