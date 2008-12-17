package code.lucamarrocco.wiki.ast;

import junit.framework.*;

public class DecoratedTextTest extends TestCase {
	private Text TEXT = new Text();

	private void assertType(DecoratedText decoratedText, int type) {
		assertEquals(decoratedText, decoratedText.setType(type));
		assertEquals(type, decoratedText.getType());
	}

	public void testDefaultDecoratedText() {
		DecoratedText decoratedText = new DecoratedText();

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testSetText() {
		DecoratedText decoratedText = new DecoratedText();

		assertEquals(decoratedText, decoratedText.setText(TEXT));
		assertEquals(TEXT, decoratedText.getText());
	}

	public void testSetType() {
		DecoratedText decoratedText = new DecoratedText();

		assertEquals(DecoratedText.NORMAL, decoratedText.getType());

		assertType(decoratedText, DecoratedText.NORMAL);
		assertType(decoratedText, DecoratedText.BOLD);
		assertType(decoratedText, DecoratedText.BOLDITALIC);
		assertType(decoratedText, DecoratedText.ITALIC);
		assertType(decoratedText, DecoratedText.UNDERLINE);
	}

	public void testType() {
		assertNotNull(DecoratedText.NORMAL);
		assertNotNull(DecoratedText.BOLD);
		assertNotNull(DecoratedText.BOLDITALIC);
		assertNotNull(DecoratedText.ITALIC);
		assertNotNull(DecoratedText.UNDERLINE);
	}
}