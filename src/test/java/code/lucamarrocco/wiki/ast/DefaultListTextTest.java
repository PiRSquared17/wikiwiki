package code.lucamarrocco.wiki.ast;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

public class DefaultListTextTest extends MockObjectTestCase {
	private Mock mockListItem = mock(ListItem.class);

	private ListItem LIST_ITEM = (ListItem) mockListItem.proxy();

	private void assertType(DefaultList listText, int type) {
		assertEquals(listText, listText.setType(type));
		assertEquals(type, listText.getType());
	}

	public void testDefaultListText() {
		DefaultList listText = new DefaultList();

		assertNotNull(listText);

		assertTrue(listText instanceof Node);

		assertTrue(listText instanceof List);

		assertTrue(listText instanceof BodyDeclaration);
	}

	public void testSetDecoratedText() {
		DefaultList listText = new DefaultList();

		assertEquals(listText, listText.addListItem(LIST_ITEM));

		assertEquals(LIST_ITEM, listText.getListItems().get(0));
	}

	public void testSetType() {
		DefaultList listText = new DefaultList();

		assertType(listText, List.ORDERED_LIST);
		assertType(listText, List.UNORDERED_LIST);
	}

	public void testType() {
		assertNotNull(List.ORDERED_LIST);
		assertNotNull(List.UNORDERED_LIST);
	}
}