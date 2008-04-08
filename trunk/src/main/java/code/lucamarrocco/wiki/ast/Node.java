package code.lucamarrocco.wiki.ast;

public interface Node {
	final String ROLE = "node";

	<A> void accept(Visitor<A> visitor, A arg);
}
