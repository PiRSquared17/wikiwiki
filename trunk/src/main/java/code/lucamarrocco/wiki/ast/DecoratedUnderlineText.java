package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class DecoratedUnderlineText extends DecoratedText {

	public DecoratedUnderlineText(Text text) {
		super(text);
	}

	public DecoratedUnderlineText(DecoratedText decoratedText) {
		super(decoratedText);
	}

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	};

}
