package code.lucamarrocco.wiki.ast;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

public class DefaultTitleTextTest extends MockObjectTestCase {
	private static final int LEVEL = 2;

	private Mock mockText = mock(Text.class);

	private Text TEXT = (Text) mockText.proxy();

	public void testDefaultTitleText() {
		DefaultTitleText title = new DefaultTitleText();

		assertNotNull(title);
		assertTrue(title instanceof Node);
		assertTrue(title instanceof TitleText);
		assertTrue(title instanceof BodyDeclaration);
	}

	public void testSetLevel() {
		DefaultTitleText title = new DefaultTitleText();

		assertEquals(title, title.setLevel(LEVEL));
		assertEquals(LEVEL, title.getLevel());
	}

	public void testSetText() {
		DefaultTitleText title = new DefaultTitleText();

		assertEquals(title, title.setText(TEXT));
		assertEquals(TEXT, title.getText());
	}
}