package code.lucamarrocco.wiki.parser;

import java.io.InputStream;

import junit.framework.TestCase;


import code.lucamarrocco.wiki.ast.Content;
import code.lucamarrocco.wiki.parser.WikiParser;

public class WikiParserTest extends TestCase {
	private void assertWikiParserContent(String fileName) throws Exception {
		InputStream wikiContent = getClass().getClassLoader()
				.getResourceAsStream(fileName);

		assertNotNull(wikiContent);

		Content content = WikiParser.parse(wikiContent);

		assertNotNull(content);
	}

	public void testWikiParserBold() throws Exception {
		assertWikiParserContent("WikiBold.txt");
	}

	public void testWikiParserBoldItalic() throws Exception {
		assertWikiParserContent("WikiBoldItalic.txt");
	}

	public void testWikiParserContent() throws Exception {
		assertWikiParserContent("WikiContent.txt");
	}

	public void testWikiParserDecoratedText() throws Exception {
		assertWikiParserContent("WikiDecoratedText.txt");
	}

	public void testWikiParserItalic() throws Exception {
		assertWikiParserContent("WikiItalic.txt");
	}

	public void testWikiParserOrderedList() throws Exception {
		assertWikiParserContent("WikiOrderedList.txt");
	}

	public void testWikiParserTitle1() throws Exception {
		assertWikiParserContent("WikiTitle1.txt");
	}

	public void testWikiParserTitle2() throws Exception {
		assertWikiParserContent("WikiTitle2.txt");
	}

	public void testWikiParserTitle3() throws Exception {
		assertWikiParserContent("WikiTitle3.txt");
	}

	public void testWikiParserUnderline() throws Exception {
		assertWikiParserContent("WikiUnderline.txt");
	}

	public void testWikiParserUnorderedList() throws Exception {
		assertWikiParserContent("WikiUnorderedList.txt");
	}

	public void testWikiParserWikiWord() throws Exception {
		assertWikiParserContent("WikiWikiWord.txt");
	}
}