package code.lucamarrocco.wiki.html;

import code.lucamarrocco.wiki.ast.*;

/** @author Luca Marrocco */
public class StringBufferVisitor implements Visitor<StringBuffer> {

	private void appendTo(StringBuffer arg, Iterable<BodyDeclaration> iterable, String tag) {
		beginHtml(arg, tag);
		innerHtml(arg, iterable);
		endHtml(arg, tag);
	}

	private void beginHtml(StringBuffer arg, String tag) {
		arg.append("<").append(tag).append(">");
	}

	private void beginHtml(StringBuffer arg, String tag, String attrName, String attrValue) {
		arg.append("<").append(tag).append(" " + attrName + "=\"").append(attrValue).append("\"").append(">");
	}

	private void endHtml(StringBuffer arg, String tag) {
		arg.append("</").append(tag).append(">");
	}

	private String h(int level) {
		if (level == 1) return "h1";
		if (level == 2) return "h2";
		return "h3";
	}

	private void innerHtml(StringBuffer arg, Iterable<BodyDeclaration> iterable) {
		for (BodyDeclaration bodyDeclaration : iterable)
			bodyDeclaration.accept(this, arg);
	}

	public void visit(BreakLine breakLine, StringBuffer arg) {
		arg.append("<br/>");
	}

	public void visit(Content content, StringBuffer arg) {
		innerHtml(arg, content);
	}

	public void visit(DecoratedBoldText decoratedText, StringBuffer arg) {
		appendTo(arg, decoratedText, "b");
	}

	public void visit(DecoratedItalicText decoratedText, StringBuffer arg) {
		appendTo(arg, decoratedText, "i");
	}

	public void visit(DecoratedNormalText decoratedText, StringBuffer arg) {
		innerHtml(arg, decoratedText);
	}

	public void visit(DecoratedUnderlineText decoratedText, StringBuffer arg) {
		appendTo(arg, decoratedText, "u");
	}

	public void visit(LinkText linkText, StringBuffer arg) {
		beginHtml(arg, "a", "href", linkText.getHref());
		linkText.getText().accept(this, arg);
		endHtml(arg, "a");
	}

	public void visit(ListItem listItem, StringBuffer arg) {
		appendTo(arg, listItem, "li");
	}

	public void visit(OrderedList list, StringBuffer arg) {
		appendTo(arg, list, "ol");
	}

	public void visit(Text text, StringBuffer arg) {
		arg.append(text.toString());
	}

	public void visit(TitleText titleText, StringBuffer arg) {
		appendTo(arg, titleText, h(titleText.getLevel()));
	}

	public void visit(UnorderedList list, StringBuffer arg) {
		appendTo(arg, list, "ul");
	}
}
