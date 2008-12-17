
package code.lucamarrocco.wiki.html;

import code.lucamarrocco.wiki.ast.BodyDeclaration;
import code.lucamarrocco.wiki.ast.BreakLine;
import code.lucamarrocco.wiki.ast.Content;
import code.lucamarrocco.wiki.ast.DecoratedText;
import code.lucamarrocco.wiki.ast.LinkText;
import code.lucamarrocco.wiki.ast.List;
import code.lucamarrocco.wiki.ast.ListItem;
import code.lucamarrocco.wiki.ast.Node;
import code.lucamarrocco.wiki.ast.Text;
import code.lucamarrocco.wiki.ast.TitleText;
import code.lucamarrocco.wiki.ast.Visitor;

/** @author Luca Marrocco */
public class HtmlElementVisitor implements Visitor<HtmlElement> {
	public static final String A = "a";

	public static final String B = "b";

	public static final String BR = "br";

	public static final String H1 = "h1";

	public static final String H2 = "h2";

	public static final String H3 = "h3";

	public static final String H4 = "h4";

	public static final String H5 = "h5";

	public static final String HREF = "href";

	public static final String I = "i";

	public static final String U = "u";

	public static final String UL = "ul";

	public static final String OL = "ol";

	public static final String LI = "li";

	private String h(int level) {
		if (level == 1) return H1;
		if (level == 2) return H2;
		if (level == 3) return H3;
		if (level == 4) return H4;
		if (level == 5) return H5;

		return null;
	}

	private String l(int type) {
		if (type == List.ORDERED_LIST) return OL;
		if (type == List.UNORDERED_LIST) return UL;

		return UL;
	}

	public void visit(BreakLine breakLine, HtmlElement htmlElement) {
		htmlElement.setName(BR);
	}

	public void visit(Content content, HtmlElement htmlElement) {
		for (BodyDeclaration bodyDeclaration : content)
			visit(bodyDeclaration, htmlElement.addChild());
	}

	public void visit(DecoratedText decoratedText, HtmlElement htmlElement) {
		int type = decoratedText.getType();

		if (type == DecoratedText.BOLD) {
			decoratedText.getText().accept(this, htmlElement.setName(B).addChild());
			return;
		}

		if (type == DecoratedText.BOLDITALIC) {
			decoratedText.getText().accept(this, htmlElement.setName(B).addChild().setName(I).addChild());
			return;
		}

		if (type == DecoratedText.ITALIC) {
			decoratedText.getText().accept(this, htmlElement.setName(I).addChild());
			return;
		}

		if (type == DecoratedText.UNDERLINE) {
			decoratedText.getText().accept(this, htmlElement.setName(U).addChild());
			return;
		}

		decoratedText.getText().accept(this, htmlElement);
	}

	public void visit(LinkText linkText, HtmlElement htmlElement) {
		linkText.getText().accept(this, htmlElement.setName(A).addAttribute(HREF, linkText.getHref()).addChild());
	}

	public void visit(List list, HtmlElement htmlElement) {
		htmlElement.setName(l(list.getType()));

		for (ListItem listItem : list)
			if (listItem instanceof List) {
				visit((List) listItem, htmlElement.addChild());
			}
			else
				visit(listItem, htmlElement.addChild());
	}

	public void visit(ListItem listItem, HtmlElement htmlElement) {
		listItem.getText().accept(this, htmlElement.setName(LI).addChild());
	}

	public void visit(Node node, HtmlElement htmlElement) {
		if (node instanceof BreakLine) {
			visit((BreakLine) node, htmlElement);
			return;
		}
		if (node instanceof DecoratedText) {
			visit((DecoratedText) node, htmlElement);
			return;
		}
		if (node instanceof LinkText) {
			visit((LinkText) node, htmlElement);
			return;
		}
		if (node instanceof List) {
			visit((List) node, htmlElement);
			return;
		}
		if (node instanceof Text) {
			visit((Text) node, htmlElement);
			return;
		}
		if (node instanceof TitleText) {
			visit((TitleText) node, htmlElement);
			return;
		}
		throw new RuntimeException("declare and implement Visitor.visit(" + node.getClass().getName() + ")");
	}

	public void visit(Text text, HtmlElement htmlElement) {
		htmlElement.setValue(text.getValue());
	}

	public void visit(TitleText titleText, HtmlElement htmlElement) {
		titleText.getText().accept(this, htmlElement.setName(h(titleText.getLevel())).addChild());
	}
}