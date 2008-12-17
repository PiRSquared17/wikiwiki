package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public interface Visitor<A> {
	void visit(BreakLine breakLine, A arg);

	void visit(Content content, A arg);

	void visit(DecoratedText decoratedText, A arg);

	void visit(LinkText linkText, A arg);

	void visit(List list, A arg);

	void visit(ListItem listItem, A arg);

	void visit(Text text, A arg);

	void visit(TitleText titleText, A arg);
}
