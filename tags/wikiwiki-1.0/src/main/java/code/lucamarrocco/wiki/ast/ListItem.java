package code.lucamarrocco.wiki.ast;

public interface ListItem extends BodyDeclaration {
	final String ROLE = "listItem";

	Text getText();

	ListItem setText(Text text);
}
