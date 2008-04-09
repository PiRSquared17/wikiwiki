package code.lucamarrocco.wiki.ast;

public interface Text extends BodyDeclaration {
	final String ROLE = "text";

	String getValue();

	Text setValue(String text);
}
