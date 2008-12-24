package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class DecoratedItalicText extends DecoratedText {

	public DecoratedItalicText(Text text) {
		super(text);
	}

	public DecoratedItalicText(DecoratedText decoratedText) {
		super(decoratedText);
	}

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	};

}
