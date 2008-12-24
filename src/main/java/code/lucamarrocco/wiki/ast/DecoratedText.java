package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public abstract class DecoratedText extends Content {

	public DecoratedText(Text text) {
		addBodyDeclaration(text);
	}

	public DecoratedText(DecoratedText decoratedText) {
		addBodyDeclaration(decoratedText);
	}

}