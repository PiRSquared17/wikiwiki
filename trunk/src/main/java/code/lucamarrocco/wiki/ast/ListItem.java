package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class ListItem extends BodyDeclaration {
	private Text text;

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((ListItem) this, arg);
	}

	public Text getText() {
		return text;
	}

	public ListItem setText(Text text) {
		this.text = text;
		return this;
	}
}
