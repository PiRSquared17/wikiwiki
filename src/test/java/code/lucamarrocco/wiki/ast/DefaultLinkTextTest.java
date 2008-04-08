package code.lucamarrocco.wiki.ast;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import code.lucamarrocco.wiki.ast.BodyDeclaration;
import code.lucamarrocco.wiki.ast.DefaultLinkText;
import code.lucamarrocco.wiki.ast.LinkText;
import code.lucamarrocco.wiki.ast.Node;
import code.lucamarrocco.wiki.ast.Text;

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
