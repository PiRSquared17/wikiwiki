package code.lucamarrocco.wiki.ast;

import junit.framework.*;

/** @author Luca Marrocco */
public class ListTest extends TestCase {
	private ListItem LIST_ITEM = new ListItem();

	private void assertType(List list, int type) {
		assertEquals(list, list.setType(type));
		assertEquals(type, list.getType());
	}

	public void testList() {
		List list = new List();

		assertNotNull(list);
		assertTrue(list instanceof Node);
		assertTrue(list instanceof List);
		assertTrue(list instanceof ListItem);
	}

	public void testSetDecoratedText() {
		List list = new List();

		assertEquals(list, list.addListItem(LIST_ITEM));
		assertEquals(LIST_ITEM, list.iterator().next());
	}

	public void testSetType() {
		List list = new List();

		assertType(list, List.ORDERED_LIST);
		assertType(list, List.UNORDERED_LIST);
	}

	public void testType() {
		assertNotNull(List.ORDERED_LIST);
		assertNotNull(List.UNORDERED_LIST);
	}
}