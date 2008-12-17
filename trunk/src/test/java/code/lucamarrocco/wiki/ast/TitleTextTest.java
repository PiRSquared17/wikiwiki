package code.lucamarrocco.wiki.ast;

import junit.framework.*;

public class TitleTextTest extends TestCase {
	private static final int LEVEL = 2;

	private Text TEXT = new Text();

	public void testDefaultTitleText() {
		TitleText title = new TitleText();

		assertNotNull(title);
		assertTrue(title instanceof Node);
		assertTrue(title instanceof TitleText);
		assertTrue(title instanceof BodyDeclaration);
	}

	public void testSetLevel() {
		TitleText title = new TitleText();

		assertEquals(title, title.setLevel(LEVEL));
		assertEquals(LEVEL, title.getLevel());
	}

	public void testSetText() {
		TitleText title = new TitleText();

		assertEquals(title, title.setText(TEXT));
		assertEquals(TEXT, title.getText());
	}
}