package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class LinkText extends BodyDeclaration {
	private String href;

	private Text text = new Text();

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}

	public String getHref() {
		return href;
	}

	public Text getText() {
		return text;
	}

	public LinkText setHref(String href) {
		this.href = href;

		return this;
	}

	public LinkText setText(Text text) {
		this.text = text;
		return this;
	}
}
