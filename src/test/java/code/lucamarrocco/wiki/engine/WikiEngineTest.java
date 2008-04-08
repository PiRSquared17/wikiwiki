package code.lucamarrocco.wiki.engine;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import code.lucamarrocco.wiki.engine.WikiEngine;

import junit.framework.TestCase;

public class WikiEngineTest extends TestCase {
	public void assertHtml(String html, String content) throws Exception {
		InputStream inputStream = new ByteArrayInputStream(content.getBytes());

		WikiEngine wikiEngine = new WikiEngine();

		assertEquals(html, wikiEngine.html(inputStream));
	}

	public void testParserBold() throws Exception {
		String html = "<b>value</b>";

		assertHtml(html, "'''value'''");
		assertHtml(html, "'''value");
	}

	public void testParserBoldItalic() throws Exception {
		String html = "<b><i>value</i></b>";

		assertHtml(html, "'''''value'''''");
		assertHtml(html, "'''''value");
	}

	public void testParserItalic() throws Exception {
		String html = "<i>value</i>";

		assertHtml(html, "''value''");
		assertHtml(html, "''value");
	}

	public void testParserTitle1() throws Exception {
		String html = "<h1>value</h1>";

		assertHtml(html, "=value=");
		assertHtml(html, "=value");
	}

	public void testParserTitle2() throws Exception {
		String html = "<h2>value</h2>";

		assertHtml(html, "==value==");
		assertHtml(html, "==value");
	}

	public void testParserTitle3() throws Exception {
		String html = "<h3>value</h3>";

		assertHtml(html, "===value===");
		assertHtml(html, "===value");
	}

	public void testParserUnderline() throws Exception {
		String html = "<u>value</u>";

		assertHtml(html, "_value_");
		assertHtml(html, "_value");
	}

	public void testParserString() throws Exception {
		String strings = "some word with comma, semicolon; dot. etc @$%^^&((";

		assertHtml(strings, strings);
	}
}