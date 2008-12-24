package code.lucamarrocco.wiki.parser;

import static code.lucamarrocco.wiki.parser.WikiParser.*;

import java.io.*;

import junit.framework.*;
import code.lucamarrocco.wiki.ast.*;

/** @author Luca Marrocco */
public class WikiParserTest extends TestCase {
	private void assertWikiParserFile(String fileName) throws Exception {
		InputStream wikiContent = getClass().getClassLoader().getResourceAsStream(fileName);
		assertNotNull(wikiContent);
		Content content = parse(wikiContent);
		assertNotNull(content);
	}

	public void testWikiParserBold() throws Exception {
		assertWikiParserFile("WikiBold.txt");
	}

	public void testWikiParserBoldItalic() throws Exception {
		assertWikiParserFile("WikiBoldItalic.txt");
	}

	public void testWikiParserContent() throws Exception {
		assertWikiParserFile("WikiContent.txt");
	}

	public void testWikiParserDecoratedText() throws Exception {
		assertWikiParserFile("WikiDecoratedText.txt");
	}

	public void testWikiParserItalic() throws Exception {
		assertWikiParserFile("WikiItalic.txt");
	}

	public void testWikiParserOrderedList() throws Exception {
		assertWikiParserFile("WikiOrderedList.txt");
	}

	public void testWikiParserTitle1() throws Exception {
		assertWikiParserFile("WikiTitle1.txt");
	}

	public void testWikiParserTitle2() throws Exception {
		assertWikiParserFile("WikiTitle2.txt");
	}

	public void testWikiParserTitle3() throws Exception {
		assertWikiParserFile("WikiTitle3.txt");
	}

	public void testWikiParserUnderline() throws Exception {
		assertWikiParserFile("WikiUnderline.txt");
	}

	public void testWikiParserUnorderedList() throws Exception {
		assertWikiParserFile("WikiUnorderedList.txt");
	}

	public void testWikiParserWikiWord() throws Exception {
		assertWikiParserFile("WikiWikiWord.txt");
	}
}