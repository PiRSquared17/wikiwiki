package code.lucamarrocco.wiki.ast;

import junit.framework.*;

/** @author Luca Marrocco */
public class ListTest extends TestCase {
	private String VALUE = "VALUE";

	private Text TEXT = new Text(VALUE);

	private ListItem LIST_ITEM = new ListItem(new DecoratedNormalText(TEXT));

	public void testNewOrderedList() {
		List list = new OrderedList();

		assertNotNull(list);
		assertTrue(list instanceof Node);
		assertTrue(list instanceof List);
		assertTrue(list instanceof ListItem);
	}

	public void testNeUnorderedList() {
		List list = new UnorderedList();

		assertNotNull(list);
		assertTrue(list instanceof Node);
		assertTrue(list instanceof List);
		assertTrue(list instanceof ListItem);
	}
}