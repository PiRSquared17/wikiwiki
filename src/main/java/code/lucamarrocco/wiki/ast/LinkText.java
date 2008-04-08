package code.lucamarrocco.wiki.ast;

public interface LinkText extends Text {
	final String ROLE = "linkText";

	LinkText setText(Text text);

	LinkText setHref(String href);

	String getHref();

	Text getText();
}
