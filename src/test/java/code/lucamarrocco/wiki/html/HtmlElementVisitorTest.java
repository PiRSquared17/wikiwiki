package code.lucamarrocco.wiki.html;

import junit.framework.*;
import code.lucamarrocco.wiki.ast.*;

/** @author Luca Marrocco */
public class HtmlElementVisitorTest extends TestCase {
	private static final String VALUE = "value";

	private HtmlElement htmlElement;

	private HtmlElementVisitor htmlElementVisitor;

	private void assertDecoratedText(String expected, int type) {
		htmlElementVisitor = new HtmlElementVisitor();

		htmlElement = new HtmlElement();

		DecoratedText node = new DecoratedText().setType(type).setText(new Text().setValue(VALUE));

		node.accept(htmlElementVisitor, htmlElement);

		assertEquals(expected, htmlElement.toString());
	}

	private void assertTitleText(String expected, int level) {
		htmlElementVisitor = new HtmlElementVisitor();

		htmlElement = new HtmlElement();

		TitleText node = new TitleText().setLevel(level).setText(new Text().setValue(VALUE));

		node.accept(htmlElementVisitor, htmlElement);

		assertEquals(expected, htmlElement.toString());
	}

	protected void setUp() throws Exception {
		htmlElementVisitor = new HtmlElementVisitor();

		htmlElement = new HtmlElement();
	}

	public void testText() {
		Text node = new Text().setValue(VALUE);

		node.accept(htmlElementVisitor, htmlElement);

		String expected = "value";

		assertEquals(expected, htmlElement.toString());
	}

	public void testVisitBreakLine() {
		BreakLine node = new BreakLine();

		node.accept(htmlElementVisitor, htmlElement);

		String expected = "<br/>";

		assertEquals(expected, htmlElement.toString());
	}

	public void testVisitContent() {
		Content node = new Content().addBodyDeclaration(new Text().setValue(VALUE)).addBodyDeclaration(new BreakLine()).addBodyDeclaration(new Text().setValue(VALUE));

		node.accept(htmlElementVisitor, htmlElement);

		String expected = "value<br/>value";

		assertEquals(expected, htmlElement.toString());
	}

	public void testVisitDecoratedText() {
		assertDecoratedText("<b><i>value</i></b>", DecoratedText.BOLDITALIC);
		assertDecoratedText("<b>value</b>", DecoratedText.BOLD);
		assertDecoratedText("<i>value</i>", DecoratedText.ITALIC);
		assertDecoratedText("<u>value</u>", DecoratedText.UNDERLINE);
		assertDecoratedText("value", DecoratedText.NORMAL);
	}

	public void testVisitLinkText() {
		LinkText node = new LinkText().setHref(VALUE).setText(new Text().setValue(VALUE));

		node.accept(htmlElementVisitor, htmlElement);

		String expected = "<a href=\"value\">value</a>";

		assertEquals(expected, htmlElement.toString());
	}

	public void testVisitListText() {
		List orderedList = new List().setType(List.ORDERED_LIST).addListItem(new ListItem().setText(new Text().setValue(VALUE))).addListItem(
				new ListItem().setText(new Text().setValue(VALUE)));
		List unorderedList = new List().setType(List.UNORDERED_LIST).addListItem(new ListItem().setText(new Text().setValue(VALUE))).addListItem(
				new ListItem().setText(new Text().setValue(VALUE)));

		htmlElement = new HtmlElement();
		orderedList.accept(htmlElementVisitor, htmlElement);
		assertEquals("<ol><li>value</li><li>value</li></ol>", htmlElement.toString());

		htmlElement = new HtmlElement();
		unorderedList.accept(htmlElementVisitor, htmlElement);
		assertEquals("<ul><li>value</li><li>value</li></ul>", htmlElement.toString());

		htmlElement = new HtmlElement();
		orderedList.addListItem((ListItem) unorderedList);
		orderedList.accept(htmlElementVisitor, htmlElement);
		assertEquals("<ol><li>value</li><li>value</li><ul><li>value</li><li>value</li></ul></ol>", htmlElement.toString());
	}

	public void testVisitTitleText() {
		assertTitleText("<h1>value</h1>", 1);
		assertTitleText("<h2>value</h2>", 2);
		assertTitleText("<h3>value</h3>", 3);
		assertTitleText("<h4>value</h4>", 4);
		assertTitleText("<h5>value</h5>", 5);
	}
}