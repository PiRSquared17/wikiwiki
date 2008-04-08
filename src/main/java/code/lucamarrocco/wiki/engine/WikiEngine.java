package code.lucamarrocco.wiki.engine;

import java.io.InputStream;


import code.lucamarrocco.wiki.ast.Content;
import code.lucamarrocco.wiki.html.HtmlElement;
import code.lucamarrocco.wiki.html.HtmlElementVisitor;
import code.lucamarrocco.wiki.parser.ParseException;
import code.lucamarrocco.wiki.parser.WikiParser;

public class WikiEngine {
	public String html(InputStream inputStream) throws ParseException {
		Content content = WikiParser.parse(inputStream);

		HtmlElement html = new HtmlElement();

		HtmlElementVisitor visitor = new HtmlElementVisitor();

		content.accept(visitor, html);

		return html.toString();
	}
}