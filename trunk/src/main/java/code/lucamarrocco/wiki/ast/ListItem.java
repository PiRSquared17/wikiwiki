package code.lucamarrocco.wiki.ast;

public interface ListItem extends BodyDeclaration {
	final String ROLE = "listItem";

	ListItem setText(Text text);

	Text getText();
}
