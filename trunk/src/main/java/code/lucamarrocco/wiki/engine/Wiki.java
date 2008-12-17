package code.lucamarrocco.wiki.engine;

import static code.lucamarrocco.wiki.parser.WikiParser.*;

import java.io.*;

import code.lucamarrocco.wiki.html.*;
import code.lucamarrocco.wiki.parser.*;

public class Wiki {
	public static final String wiki(InputStream inputStream) throws ParseException {
		HtmlElement html = new HtmlElement();
		parse(inputStream).accept(new HtmlElementVisitor(), html);
		return html.toString();
	}

	public static final String wiki(String string) throws ParseException {
		return wiki(new ByteArrayInputStream(string.getBytes()));
	}
}