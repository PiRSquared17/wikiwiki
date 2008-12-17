package code.lucamarrocco.wiki.ast;

public class TitleText extends BodyDeclaration {
	private int level;

	private Text text;

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((TitleText) this, arg);
	}

	public int getLevel() {
		return level;
	}

	public Text getText() {
		return text;
	}

	public TitleText setLevel(int level) {
		this.level = level;

		return this;
	}

	public TitleText setText(Text text) {
		this.text = text;
		return this;
	}
}
