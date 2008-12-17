package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class DecoratedUnderlineText extends DecoratedText {
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((DecoratedUnderlineText) this, arg);
	}
}
