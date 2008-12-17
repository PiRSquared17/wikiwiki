package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class DecoratedBoldText extends DecoratedText {
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((DecoratedBoldText) this, arg);
	}
}
