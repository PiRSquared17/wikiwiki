package code.lucamarrocco.wiki.ast;

public class DefaultText extends AbstractBodyDeclaration implements Text {
	private String value;

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((Text) this, arg);
	}

	public String getValue() {
		return value;
	}

	public Text setValue(String value) {
		this.value = value;

		return this;
	}
}
