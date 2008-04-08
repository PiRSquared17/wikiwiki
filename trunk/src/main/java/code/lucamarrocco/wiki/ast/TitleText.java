package code.lucamarrocco.wiki.ast;

public interface TitleText extends BodyDeclaration {
	final String ROLE = "titleText";

	TitleText setText(Text text);

	TitleText setLevel(int level);

	int getLevel();

	Text getText();
}
