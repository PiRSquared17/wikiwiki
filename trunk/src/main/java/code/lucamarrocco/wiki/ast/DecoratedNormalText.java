package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class DecoratedNormalText extends DecoratedText {

	public DecoratedNormalText(Text text) {
		super(text);
	}

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	};

}
