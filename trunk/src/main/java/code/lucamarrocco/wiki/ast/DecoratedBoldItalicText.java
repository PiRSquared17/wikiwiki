package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class DecoratedBoldItalicText extends DecoratedText {
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((DecoratedBoldItalicText) this, arg);
	}
}
