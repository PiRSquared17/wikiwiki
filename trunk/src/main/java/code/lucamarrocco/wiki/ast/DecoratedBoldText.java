package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class DecoratedBoldText extends DecoratedText {

	public DecoratedBoldText(Text text) {
		super(text);
	}

	public DecoratedBoldText(DecoratedText decoratedText) {
		super(decoratedText);
	}

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	};

}