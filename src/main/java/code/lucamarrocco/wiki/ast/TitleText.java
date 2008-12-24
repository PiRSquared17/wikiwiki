package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public class TitleText extends Content {
	private int level;

	public TitleText(int level, Text text) {
		this.level = level;
		addBodyDeclaration(text);
	}

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}

	public int getLevel() {
		return level;
	}
}
