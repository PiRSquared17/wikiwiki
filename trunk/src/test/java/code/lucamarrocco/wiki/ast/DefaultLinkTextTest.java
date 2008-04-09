package code.lucamarrocco.wiki.ast;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

public class DefaultLinkTextTest extends MockObjectTestCase {
	private Mock mockText = mock(Text.class);

	private Text TEXT = (Text) mockText.proxy();

	public void testDefaultLinkText() {
		DefaultLinkText link = new DefaultLinkText();

		assertNotNull(link);

		assertTrue(link instanceof Node);

		assertTrue(link instanceof LinkText);

		assertTrue(link instanceof BodyDeclaration);
	}

	public void testSetText() {
		DefaultLinkText link = new DefaultLinkText();

		assertEquals(link, link.setText(TEXT));

		assertEquals(TEXT, link.getText());
	}
}
