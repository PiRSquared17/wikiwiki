package code.lucamarrocco.wiki.ast;

public class DefaultListItem extends AbstractNode implements ListItem {
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
