package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public interface Visitor<A> {
	void visit(Content content, A arg);
	
	void visit(BreakLine breakLine, A arg);

	void visit(DecoratedBoldText decoratedText, A arg);

	void visit(DecoratedItalicText decoratedText, A arg);

	void visit(DecoratedNormalText decoratedText, A arg);

	void visit(DecoratedUnderlineText decoratedText, A arg);

	void visit(LinkText linkText, A arg);

	void visit(OrderedList list, A arg);

	void visit(UnorderedList list, A arg);

	void visit(ListItem listItem, A arg);

	void visit(Text text, A arg);

	void visit(TitleText titleText, A arg);
}
