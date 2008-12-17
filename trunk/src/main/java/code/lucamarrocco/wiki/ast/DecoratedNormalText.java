package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class DecoratedNormalText extends DecoratedText {
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((DecoratedNormalText) this, arg);
	}
}
