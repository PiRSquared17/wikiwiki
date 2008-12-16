package code.lucamarrocco.wiki.ast;

import junit.framework.TestCase;

public class DefaultBreakLineTest extends TestCase {
	public void testDefaultBreakLine() {
		DefaultBreakLine text = new DefaultBreakLine();

		assertNotNull(text);

		assertTrue(text instanceof Node);

		assertTrue(text instanceof BreakLine);

		assertTrue(text instanceof BodyDeclaration);
	}
}
