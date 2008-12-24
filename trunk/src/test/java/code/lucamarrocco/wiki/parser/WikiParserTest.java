package code.lucamarrocco.wiki.parser;

import static code.lucamarrocco.wiki.parser.WikiParser.*;

import java.io.*;

import junit.framework.*;
import code.lucamarrocco.wiki.ast.*;
import code.lucamarrocco.wiki.html.*;

/** @author Luca Marrocco */
public class WikiParserTest extends TestCase {
	private void assertWiki(String fileName) throws Exception {
		InputStream wikiContent = getClass().getClassLoader().getResourceAsStream(fileName.concat(".txt"));
		InputStream htmlContent = getClass().getClassLoader().getResourceAsStream(fileName.concat(".html"));
		assertNotNull(wikiContent);
		Content content = parse(wikiContent);
		assertNotNull(content);
		StringBuffer stringBuffer = new StringBuffer();
		content.accept(new StringBufferVisitor(), stringBuffer);
		assertEquals(slurp(htmlContent).replaceAll("\r", "").replaceAll("\n", ""), stringBuffer.toString());
	}

	public static String slurp(InputStream in) throws IOException {
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return out.toString();
	}

	public void testWikiParserBold() throws Exception {
		assertWiki("WikiBold");
	}

	public void testWikiParserBoldItalic() throws Exception {
		assertWiki("WikiBoldItalic");
	}

	public void testWikiParserContent() throws Exception {
		assertWiki("WikiContent");
	}

	public void testWikiParserDecoratedText() throws Exception {
		assertWiki("WikiDecoratedText");
	}

	public void testWikiParserItalic() throws Exception {
		assertWiki("WikiItalic");
	}

	public void testWikiParserOrderedList() throws Exception {
		assertWiki("WikiOrderedList");
	}

	public void testWikiParserTitle1() throws Exception {
		assertWiki("WikiTitle1");
	}

	public void testWikiParserTitle2() throws Exception {
		assertWiki("WikiTitle2");
	}

	public void testWikiParserTitle3() throws Exception {
		assertWiki("WikiTitle3");
	}

	public void testWikiParserUnderline() throws Exception {
		assertWiki("WikiUnderline");
	}

	public void testWikiParserUnorderedList() throws Exception {
		assertWiki("WikiUnorderedList");
	}

	public void testWikiParserWikiWord() throws Exception {
		assertWiki("WikiWikiWord");
	}
}