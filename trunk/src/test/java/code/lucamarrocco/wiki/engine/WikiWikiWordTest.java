package code.lucamarrocco.wiki.engine;

import junit.framework.TestCase;

public class WikiWikiWordTest extends TestCase {
	public void assertHtml(String html, String content) throws Exception {
		assertEquals(html, new Wiki().wiki(content));
	}
	public void testParserLbracketWikiWordDescriptionRbracket() throws Exception {
		String html = "<a href=\"WikiWord\">some word that describe wiki word</a>";

		assertHtml(html, "[WikiWord some word that describe wiki word]");
		assertHtml(html, "[WikiWord some word that describe wiki word");
	}

	public void testParserLbracketWikiwordRbracket() throws Exception {
		String html = "<a href=\"Wikiword\">Wikiword</a>";

		assertHtml(html, "[Wikiword]");
		assertHtml(html, "[Wikiword");
	}

	public void testParserWikiWord() throws Exception {
		String html = "<a href=\"WikiWikiWord\">WikiWikiWord</a>";

		assertHtml(html, "WikiWikiWord");
	}

	public void testParserWikiWordAndAnotherWikiWord() throws Exception {
		String html = "<a href=\"WikiWord\">WikiWord</a><a href=\"AnotherWikiWord\">AnotherWikiWord</a>";

		assertHtml(html, "WikiWord AnotherWikiWord");
	}

	public void testParserWikiWordAndLbracketUrlDescriptionRbracket()
			throws Exception {
		String html = "<a href=\"WikiWord\">WikiWord</a><a href=\"WikiWord\">This is a Wiki Word description</a>";

		assertHtml(html, "WikiWord [WikiWord This is a Wiki Word description]");
	}

	public void testParserWikiWordAndSomeString() throws Exception {
		String html = "<a href=\"WikiWikiWord\">WikiWikiWord</a>and some string";

		assertHtml(html, "WikiWikiWord and some string");
	}

	public void testParserWikiWordCarriageReturn() throws Exception {
		String html = "<a href=\"WikiWikiWord\">WikiWikiWord</a><br/>";

		assertHtml(html, "WikiWikiWord\r");
	}
}