package code.lucamarrocco.wiki.engine;

import static code.lucamarrocco.wiki.parser.WikiParser.*;

import java.io.*;

import code.lucamarrocco.wiki.html.*;
import code.lucamarrocco.wiki.parser.*;

/** @author Luca Marrocco */
public class Wiki {
	public static final String wiki(InputStream inputStream) throws ParseException {
		StringBuffer stringBuffer = new StringBuffer();
		parse(inputStream).accept(new StringBufferVisitor(), stringBuffer);
		return stringBuffer.toString();
	}

	public static final String wiki(String string) throws ParseException {
		return wiki(new ByteArrayInputStream(string.getBytes()));
	}
}