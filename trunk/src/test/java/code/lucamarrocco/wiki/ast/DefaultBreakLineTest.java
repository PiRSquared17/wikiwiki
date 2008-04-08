package code.lucamarrocco.wiki.ast;

import code.lucamarrocco.wiki.ast.BodyDeclaration;
import code.lucamarrocco.wiki.ast.BreakLine;
import code.lucamarrocco.wiki.ast.DefaultBreakLine;
import code.lucamarrocco.wiki.ast.Node;

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
