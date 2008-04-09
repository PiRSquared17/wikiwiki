package code.lucamarrocco.wiki.ast;

public interface LinkText extends Text {
	final String ROLE = "linkText";

	String getHref();

	Text getText();

	LinkText setHref(String href);

	LinkText setText(Text text);
}
