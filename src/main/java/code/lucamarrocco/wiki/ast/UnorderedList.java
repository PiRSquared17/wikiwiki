package code.lucamarrocco.wiki.ast;


/** @author Luca Marrocco */
public class UnorderedList extends List {

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	};
}
