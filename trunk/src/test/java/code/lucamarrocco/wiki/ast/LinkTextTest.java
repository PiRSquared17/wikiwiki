package code.lucamarrocco.wiki.ast;

import junit.framework.*;

public class LinkTextTest extends TestCase {
	private Text TEXT = new Text();

	public void testDefaultLinkText() {
		LinkText link = new LinkText();

		assertNotNull(link);
		assertTrue(link instanceof Node);
		assertTrue(link instanceof LinkText);
		assertTrue(link instanceof BodyDeclaration);
	}

	public void testSetText() {
		LinkText link = new LinkText();

		assertEquals(link, link.setText(TEXT));
		assertEquals(TEXT, link.getText());
	}
}
