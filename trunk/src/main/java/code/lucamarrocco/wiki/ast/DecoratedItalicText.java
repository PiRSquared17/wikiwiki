package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class DecoratedItalicText extends DecoratedText {
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((DecoratedItalicText) this, arg);
	}
}
