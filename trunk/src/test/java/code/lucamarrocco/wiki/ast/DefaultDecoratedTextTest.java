package code.lucamarrocco.wiki.ast;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

public class DefaultDecoratedTextTest extends MockObjectTestCase {
	private Mock mockText = mock(Text.class);

	private Text TEXT = (Text) mockText.proxy();

	private void assertType(DefaultDecoratedText decoratedText, int type) {
		assertEquals(decoratedText, decoratedText.setType(type));
		assertEquals(type, decoratedText.getType());
	}

	public void testDefaultDecoratedText() {
		DefaultDecoratedText decoratedText = new DefaultDecoratedText();

		assertNotNull(decoratedText);

		assertTrue(decoratedText instanceof Node);

		assertTrue(decoratedText instanceof DecoratedText);

		assertTrue(decoratedText instanceof BodyDeclaration);
	}

	public void testSetText() {
		DefaultDecoratedText decoratedText = new DefaultDecoratedText();

		assertEquals(decoratedText, decoratedText.setText(TEXT));

		assertEquals(TEXT, decoratedText.getText());
	}

	public void testSetType() {
		DefaultDecoratedText decoratedText = new DefaultDecoratedText();

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