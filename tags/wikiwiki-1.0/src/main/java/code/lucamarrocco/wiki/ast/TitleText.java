package code.lucamarrocco.wiki.ast;

public interface TitleText extends BodyDeclaration {
	final String ROLE = "titleText";

	int getLevel();

	Text getText();

	TitleText setLevel(int level);

	TitleText setText(Text text);
}
