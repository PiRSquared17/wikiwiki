package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public abstract class DecoratedText extends Text {

	private Text text = new Text();

	public Text getText() {
		return text;
	}

	public String getValue() {
		return text.getValue();
	}

	public DecoratedText setText(Text text) {
		this.text = text;
		return this;
	}

	public Text setValue(String value) {
		return text.setValue(value);
	}
}