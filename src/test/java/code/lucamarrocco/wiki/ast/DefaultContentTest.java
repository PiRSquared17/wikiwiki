package code.lucamarrocco.wiki.ast;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

public class DefaultContentTest extends MockObjectTestCase {
	private Mock mockBodyDeclaration = mock(BodyDeclaration.class);

	private BodyDeclaration BODY_DECLARATION = (BodyDeclaration) mockBodyDeclaration
			.proxy();

	public void testAddBodyDeclaration() {
		DefaultContent content = new DefaultContent();

		content.addBodyDeclaration(BODY_DECLARATION);

		assertTrue(content.getBodyDeclarations().contains(BODY_DECLARATION));

		assertTrue(content.getChildren().contains(BODY_DECLARATION));

		assertEquals(1, content.getBodyDeclarations().size());
	}

	public void testDefaultContent() {
		DefaultContent content = new DefaultContent();

		assertNotNull(content);

		assertNotNull(content.getBodyDeclarations());

		assertTrue(content.getBodyDeclarations().isEmpty());

		assertTrue(content instanceof Node);

		assertTrue(content instanceof Content);

		assertTrue(content instanceof AbstractNode);
	}
}
