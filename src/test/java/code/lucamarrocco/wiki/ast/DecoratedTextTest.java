package code.lucamarrocco.wiki.ast;

import junit.framework.*;

/** @author Luca Marrocco */
public class DecoratedTextTest extends TestCase {
	private Text TEXT = new Text();

	public void testDecoratedNormalText() {
		DecoratedText decoratedText = new DecoratedNormalText(TEXT);

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof DecoratedNormalText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testDecoratedBoldText() {
		DecoratedText decoratedText = new DecoratedBoldText(TEXT);

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof DecoratedBoldText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testDecoratedItalicText() {
		DecoratedText decoratedText = new DecoratedItalicText(TEXT);

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof DecoratedItalicText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testDecoratedUnderlineText() {
		DecoratedText decoratedText = new DecoratedUnderlineText(TEXT);

		assertNotNull(decoratedText);
		assertTrue(decoratedText instanceof Node);
		assertTrue(decoratedText instanceof DecoratedText);
		assertTrue(decoratedText instanceof DecoratedUnderlineText);
		assertTrue(decoratedText instanceof BodyDeclaration);
	}
}