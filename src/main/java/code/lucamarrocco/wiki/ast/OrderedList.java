package code.lucamarrocco.wiki.ast;


/** @author Luca Marrocco */
public class OrderedList extends List {

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	};
}