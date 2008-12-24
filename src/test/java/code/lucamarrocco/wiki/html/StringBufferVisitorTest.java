package code.lucamarrocco.wiki.html;

import static code.lucamarrocco.wiki.parser.WikiParser.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import code.lucamarrocco.wiki.ast.*;

/** @author Luca Marrocco */
public class StringBufferVisitorTest {
	private String visit(String string) {
		Visitor visitor = new StringBufferVisitor();
		StringBuffer stringBuffer = new StringBuffer();
		parse(string).accept(visitor, stringBuffer);
		return stringBuffer.toString();
	}

	@Test
	public void visitContent() {
		assertThat(visit("value"), is(equalTo("value")));
	}

	@Test
	public void visitBreakLine() {
		assertThat(visit("\r"), is(equalTo("<br/>")));
		assertThat(visit("\r\r"), is(equalTo("<br/>")));
	}

	@Test
	public void visitDecoratedBoldText() {
		assertThat(visit("'''value"), is(equalTo("<b>value</b>")));
		assertThat(visit("'''value'''"), is(equalTo("<b>value</b>")));
	}

	@Test
	public void visitDecoratedItalicText() {
		assertThat(visit("''value"), is(equalTo("<i>value</i>")));
		assertThat(visit("''value''"), is(equalTo("<i>value</i>")));
	}

	@Test
	public void visitDecoratedNormalText() {
		assertThat(visit("value"), is(equalTo("value")));
	}

	@Test
	public void visitDecoratedUnderlineText() {
		assertThat(visit("_value"), is(equalTo("<u>value</u>")));
		assertThat(visit("_value_"), is(equalTo("<u>value</u>")));
	}

	@Test
	public void visitLinkText() {
		assertThat(visit("http://www.google.com"), is(equalTo("<a href=\"http://www.google.com\">http://www.google.com</a>")));
		assertThat(visit("[http://www.google.com"), is(equalTo("<a href=\"http://www.google.com\">http://www.google.com</a>")));
		assertThat(visit("[http://www.google.com]"), is(equalTo("<a href=\"http://www.google.com\">http://www.google.com</a>")));
		assertThat(visit("http://www.google.com description"), is(equalTo("<a href=\"http://www.google.com\">http://www.google.com</a>description")));
		assertThat(visit("[http://www.google.com description"), is(equalTo("<a href=\"http://www.google.com\">description</a>")));
		assertThat(visit("[http://www.google.com description]"), is(equalTo("<a href=\"http://www.google.com\">description</a>")));
		assertThat(visit("[WikiWord"), is(equalTo("<a href=\"WikiWord\">WikiWord</a>")));
		assertThat(visit("[WikiWord]"), is(equalTo("<a href=\"WikiWord\">WikiWord</a>")));
		assertThat(visit("[WikiWord description"), is(equalTo("<a href=\"WikiWord\">description</a>")));
		assertThat(visit("[WikiWord description]"), is(equalTo("<a href=\"WikiWord\">description</a>")));
	}

	@Test
	public void visitOrderedList() {
		assertThat(visit("#value"), is(equalTo("<ol><li>value</li></ol>")));
		assertThat(visit("# value"), is(equalTo("<ol><li>value</li></ol>")));
	}

	@Test
	public void visitUnorderedList() {
		assertThat(visit("*value"), is(equalTo("<ul><li>value</li></ul>")));
		assertThat(visit("* value"), is(equalTo("<ul><li>value</li></ul>")));
		assertThat(visit("*value\r*value"), is(equalTo("<ul><li>value</li><li>value</li></ul>")));
		assertThat(visit("* value\r* value"), is(equalTo("<ul><li>value</li><li>value</li></ul>")));
		assertThat(visit("* value\r **value"), is(equalTo("<ul><li>value</li><ul><li>value</li></ul></ul>")));
		assertThat(visit("* value\r **value\r *value"), is(equalTo("<ul><li>value</li><ul><li>value</li></ul><li>value</li></ul>")));
	}

	@Test
	public void visitText() {
		assertThat(visit("value"), is(equalTo("value")));
		assertThat(visit("value, value"), is(equalTo("value, value")));
	}

	@Test
	public void visitTitleText() {
		assertThat(visit("=value"), is(equalTo("<h1>value</h1>")));
		assertThat(visit("=value="), is(equalTo("<h1>value</h1>")));

		assertThat(visit("==value"), is(equalTo("<h2>value</h2>")));
		assertThat(visit("==value=="), is(equalTo("<h2>value</h2>")));

		assertThat(visit("===value"), is(equalTo("<h3>value</h3>")));
		assertThat(visit("===value==="), is(equalTo("<h3>value</h3>")));
	}
}
