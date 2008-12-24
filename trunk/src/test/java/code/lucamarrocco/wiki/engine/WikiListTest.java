package code.lucamarrocco.wiki.engine;

import junit.framework.*;

public class WikiListTest extends TestCase {
	public void assertHtml(String html, String content) throws Exception {
		Wiki wikiEngine = new Wiki();
		assertEquals(html, wikiEngine.wiki(content));
	}

	public void testParserOrderedList() throws Exception {
		String html = "<ol><li>value</li></ol>";

		assertHtml(html, "#value");
		assertHtml(html, "# value");
	}

	public void testParserOrderedListWithSomeListItem() throws Exception {
		String html = "";

		html += "<ol>";
		html += "<li>value</li>";
		html += "<li>value</li>";
		html += "<li>value</li>";
		html += "</ol>";

		assertHtml(html, "#value\n#value\n#value");
	}

	public void testParserOrderedListWithSomeNestedListItem() throws Exception {
		String html = "";

		html += "<ol>";
		html += "<li>value</li>";
		html += "<ol>";
		html += "<li>value</li>";
		html += "<li>value</li>";
		html += "<li>value</li>";
		html += "</ol>";
		html += "<li>value</li>";
		html += "</ol>";

		assertHtml(html, "#value\n##value\n##value\n##value\n#value");
	}

	public void testParserUnorderedList() throws Exception {
		String html = "<ul><li>value</li></ul>";

		assertHtml(html, "*value");
		assertHtml(html, "* value");
	}

	public void testParserUnorderedListWithSomeListItem() throws Exception {
		String html = "";

		html += "<ul>";
		html += "<li>value</li>";
		html += "<li>value</li>";
		html += "<li>value</li>";
		html += "</ul>";

		assertHtml(html, "*value\n*value\n*value");
	}

	public void testParserUnorderedListWithSomeNestedListItem() throws Exception {
		String html = "";

		html += "<ul>";
		html += "<li>value</li>";
		html += "<ul>";
		html += "<li>value</li>";
		html += "<li>value</li>";
		html += "<li>value</li>";
		html += "</ul>";
		html += "<li>value</li>";
		html += "</ul>";

		assertHtml(html, "*value\n**value\n**value\n**value\n*value");
	}
}