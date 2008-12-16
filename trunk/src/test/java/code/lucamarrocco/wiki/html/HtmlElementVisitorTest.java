package code.lucamarrocco.wiki.html;

import junit.framework.TestCase;
import code.lucamarrocco.wiki.ast.BreakLine;
import code.lucamarrocco.wiki.ast.Content;
import code.lucamarrocco.wiki.ast.DecoratedText;
import code.lucamarrocco.wiki.ast.DefaultBreakLine;
import code.lucamarrocco.wiki.ast.DefaultContent;
import code.lucamarrocco.wiki.ast.DefaultDecoratedText;
import code.lucamarrocco.wiki.ast.DefaultLinkText;
import code.lucamarrocco.wiki.ast.DefaultList;
import code.lucamarrocco.wiki.ast.DefaultListItem;
import code.lucamarrocco.wiki.ast.DefaultText;
import code.lucamarrocco.wiki.ast.DefaultTitleText;
import code.lucamarrocco.wiki.ast.LinkText;
import code.lucamarrocco.wiki.ast.List;
import code.lucamarrocco.wiki.ast.ListItem;
import code.lucamarrocco.wiki.ast.Text;
import code.lucamarrocco.wiki.ast.TitleText;

public class HtmlElementVisitorTest extends TestCase {
	private static final String VALUE = "value";

	private HtmlElement htmlElement;

	private HtmlElementVisitor htmlElementVisitor;

	private void assertDecoratedText(String expected, int type) {
		htmlElementVisitor = new HtmlElementVisitor();

		htmlElement = new HtmlElement();

		DecoratedText node = new DefaultDecoratedText().setType(type).setText(new DefaultText().setValue(VALUE));

		node.accept(htmlElementVisitor, htmlElement);

		assertEquals(expected, htmlElement.toString());
	}

	private void assertTitleText(String expected, int level) {
		htmlElementVisitor = new HtmlElementVisitor();

		htmlElement = new HtmlElement();

		TitleText node = new DefaultTitleText().setLevel(level).setText(new DefaultText().setValue(VALUE));

		node.accept(htmlElementVisitor, htmlElement);

		assertEquals(expected, htmlElement.toString());
	}

	protected void setUp() throws Exception {
		htmlElementVisitor = new HtmlElementVisitor();

		htmlElement = new HtmlElement();
	}

	public void testText() {
		Text node = new DefaultText().setValue(VALUE);

		node.accept(htmlElementVisitor, htmlElement);

		String expected = "value";

		assertEquals(expected, htmlElement.toString());
	}

	public void testVisitBreakLine() {
		BreakLine node = new DefaultBreakLine();

		node.accept(htmlElementVisitor, htmlElement);

		String expected = "<br/>";

		assertEquals(expected, htmlElement.toString());
	}

	public void testVisitContent() {
		Content node = new DefaultContent().addBodyDeclaration(new DefaultText().setValue(VALUE)).addBodyDeclaration(new DefaultBreakLine()).addBodyDeclaration(new DefaultText().setValue(VALUE));

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
		LinkText node = new DefaultLinkText().setHref(VALUE).setText(new DefaultText().setValue(VALUE));

		node.accept(htmlElementVisitor, htmlElement);

		String expected = "<a href=\"value\">value</a>";

		assertEquals(expected, htmlElement.toString());
	}

	public void testVisitListText() {
		List orderedList = new DefaultList().setType(List.ORDERED_LIST).addListItem(new DefaultListItem().setText(new DefaultText().setValue(VALUE))).addListItem(
				new DefaultListItem().setText(new DefaultText().setValue(VALUE)));
		List unorderedList = new DefaultList().setType(List.UNORDERED_LIST).addListItem(new DefaultListItem().setText(new DefaultText().setValue(VALUE))).addListItem(
				new DefaultListItem().setText(new DefaultText().setValue(VALUE)));

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