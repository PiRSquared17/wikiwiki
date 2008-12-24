package code.lucamarrocco.wiki.ast;

import junit.framework.*;

/** @author Luca Marrocco */
public class TitleTextTest extends TestCase {
	private static final int LEVEL = 2;

	private Text TEXT = new Text();

	public void testDefaultTitleText() {
		TitleText title = new TitleText(LEVEL, TEXT);

		assertNotNull(title);
		assertTrue(title instanceof Node);
		assertTrue(title instanceof TitleText);
		assertTrue(title instanceof BodyDeclaration);
	}

	public void testSetLevel() {
		TitleText title = new TitleText(LEVEL, TEXT);
		assertEquals(LEVEL, title.getLevel());
	}

	public void testSetText() {
		TitleText title = new TitleText(LEVEL, TEXT);
		assertEquals(TEXT, title.iterator().next());
	}
}