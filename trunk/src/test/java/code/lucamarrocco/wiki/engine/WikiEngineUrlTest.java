package code.lucamarrocco.wiki.engine;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import code.lucamarrocco.wiki.engine.WikiEngine;

import junit.framework.TestCase;

public class WikiEngineUrlTest extends TestCase {
	public void assertHtml(String html, String content) throws Exception {
		InputStream inputStream = new ByteArrayInputStream(content.getBytes());

		WikiEngine wikiEngine = new WikiEngine();

		assertEquals(html, wikiEngine.html(inputStream));
	}

	public void testParserUrl() throws Exception {
		String html = "<a href=\"http://www.google.it\">http://www.google.it</a>";

		assertHtml(html, "http://www.google.it");
	}

	public void testParserLbracketUrlRbracket() throws Exception {
		String html = "<a href=\"http://www.google.it\">http://www.google.it</a>";

		assertHtml(html, "[http://www.google.it]");
		assertHtml(html, "[http://www.google.it");
	}

	public void testParserLbracketUrlDescriptionRbracket() throws Exception {
		String html = "<a href=\"http://www.google.it\">some word of description</a>";

		assertHtml(html, "[http://www.google.it some word of description]");
		assertHtml(html, "[http://www.google.it some word of description");
	}
}