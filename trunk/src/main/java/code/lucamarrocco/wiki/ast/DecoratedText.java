package code.lucamarrocco.wiki.ast;

public interface DecoratedText extends BodyDeclaration, Text {
	final String ROLE = "decoratedText";

	final int NORMAL = 0;

	final int BOLD = 1;

	final int BOLDITALIC = 2;

	final int ITALIC = 3;

	final int UNDERLINE = 4;

	DecoratedText setText(Text text);

	DecoratedText setType(int type);

	Text getText();

	int getType();
}
