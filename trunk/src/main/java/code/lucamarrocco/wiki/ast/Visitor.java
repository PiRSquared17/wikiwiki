package code.lucamarrocco.wiki.ast;

public interface Visitor<A> {
	final String ROLE = "visitor";

	void visit(Content content, A arg);

	void visit(BreakLine breakLine, A arg);

	void visit(DecoratedText decoratedText, A arg);

	void visit(LinkText linkText, A arg);

	void visit(List list, A arg);

	void visit(ListItem listItem, A arg);

	void visit(Text text, A arg);

	void visit(TitleText titleText, A arg);
}
