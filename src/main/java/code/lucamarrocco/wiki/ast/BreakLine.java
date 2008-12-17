package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class BreakLine extends BodyDeclaration {
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((BreakLine) this, arg);
	}
}
