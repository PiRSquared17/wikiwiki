package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class Text extends BodyDeclaration {
	private String value;

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}

	protected Text() {}

	public Text(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
