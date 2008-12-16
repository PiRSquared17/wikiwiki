package code.lucamarrocco.wiki.ast;

import java.util.List;

public interface Content extends Node {
	final String ROLE = "content";

	Content addBodyDeclaration(BodyDeclaration bodyDeclaration);

	List<BodyDeclaration> getBodyDeclarations();
}
