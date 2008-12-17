package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class Text extends BodyDeclaration {
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
