package code.lucamarrocco.wiki.ast;

public class DefaultBreakLine extends AbstractBodyDeclaration implements
		BreakLine {
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((BreakLine) this, arg);
	}
}
