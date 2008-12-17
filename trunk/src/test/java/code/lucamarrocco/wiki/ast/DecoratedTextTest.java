package code.lucamarrocco.wiki.ast;

import junit.framework.*;

/** @author Luca Marrocco */
public class DecoratedTextTest extends TestCase {
	private Text TEXT = new Text();

	public void testDecoratedText() {
		DecoratedText decoratedText = new DecoratedText() {};

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testDecoratedNormalText() {
		DecoratedText decoratedText = new DecoratedNormalText();

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof DecoratedNormalText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testDecoratedBoldText() {
		DecoratedText decoratedText = new DecoratedBoldText();

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof DecoratedBoldText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testDecoratedBoldItalicText() {
		DecoratedText decoratedText = new DecoratedBoldItalicText();

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof DecoratedBoldItalicText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testDecoratedItalicText() {
		DecoratedText decoratedText = new DecoratedItalicText();

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof DecoratedItalicText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testDecoratedUnderlineText() {
		DecoratedText decoratedText = new DecoratedUnderlineText();

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof DecoratedUnderlineText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testText() {
		DecoratedText decoratedText = new DecoratedText() {};

		assertEquals(decoratedText, decoratedText.setText(TEXT));
		assertEquals(TEXT, decoratedText.getText());
	}
}