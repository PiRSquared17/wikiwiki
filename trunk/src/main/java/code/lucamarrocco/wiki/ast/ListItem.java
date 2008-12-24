package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class ListItem extends Content {

	public ListItem(DecoratedText decoratedText) {
		addBodyDeclaration(decoratedText);
	}

	public ListItem() {}

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	};

}
