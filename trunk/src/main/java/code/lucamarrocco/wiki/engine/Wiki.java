package code.lucamarrocco.wiki.engine;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import code.lucamarrocco.wiki.ast.Content;
import code.lucamarrocco.wiki.html.HtmlElement;
import code.lucamarrocco.wiki.html.HtmlElementVisitor;
import code.lucamarrocco.wiki.parser.ParseException;
import code.lucamarrocco.wiki.parser.WikiParser;

public class Wiki {
	public static final String wiki(InputStream inputStream) throws ParseException {
		Content content = WikiParser.parse(inputStream);
		HtmlElement html = new HtmlElement();
		HtmlElementVisitor visitor = new HtmlElementVisitor();
		content.accept(visitor, html);
		return html.toString();
	}

	public static final String wiki(String string) throws ParseException {
		return wiki(new ByteArrayInputStream(string.getBytes()));
	}
}