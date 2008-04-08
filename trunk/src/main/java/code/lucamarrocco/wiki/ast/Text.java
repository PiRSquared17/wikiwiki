package code.lucamarrocco.wiki.ast;

public interface Text extends BodyDeclaration {
	final String ROLE = "text";

	Text setValue(String text);

	String getValue();
}
