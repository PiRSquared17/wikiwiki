package code.lucamarrocco.wiki.ast;

import junit.framework.TestCase;

/** @author Luca Marrocco */
public class BreakLineTest extends TestCase {
	public void testDefaultBreakLine() {
		BreakLine text = new BreakLine();

		assertNotNull(text);
		assertTrue(text instanceof Node);
		assertTrue(text instanceof BreakLine);
		assertTrue(text instanceof BodyDeclaration);
	}
}
