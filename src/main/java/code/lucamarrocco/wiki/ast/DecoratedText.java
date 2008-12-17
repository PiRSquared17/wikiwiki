package code.lucamarrocco.wiki.ast;

public class DecoratedText extends Text {

	public static final int NORMAL = 0;

	public static final int BOLD = 1;

	public static final int BOLDITALIC = 2;

	public static final int ITALIC = 3;

	public static final int UNDERLINE = 4;

	private Text text;

	private int type = DecoratedText.NORMAL;

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((DecoratedText) this, arg);
	}

	public Text getText() {
		return text;
	}

	public int getType() {
		return type;
	}

	public String getValue() {
		return text.getValue();
	}

	public DecoratedText setText(Text text) {
		this.text = text;

		return this;
	}

	public DecoratedText setType(int type) {
		this.type = type;

		return this;
	}

	public Text setValue(String value) {
		return text.setValue(value);
	}
}