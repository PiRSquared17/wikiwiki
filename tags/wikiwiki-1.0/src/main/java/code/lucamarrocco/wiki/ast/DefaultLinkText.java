package code.lucamarrocco.wiki.ast;

public class DefaultLinkText extends AbstractBodyDeclaration implements
		LinkText {
	private String href;

	private Text text;

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((LinkText) this, arg);
	}

	public String getHref() {
		return href;
	}

	public Text getText() {
		return text;
	}

	public String getValue() {
		return text.getValue();
	}

	public LinkText setHref(String href) {
		this.href = href;

		return this;
	}

	public LinkText setText(Text text) {
		this.text = text;

		return this;
	}

	public Text setValue(String value) {
		return text.setValue(value);
	}
}
