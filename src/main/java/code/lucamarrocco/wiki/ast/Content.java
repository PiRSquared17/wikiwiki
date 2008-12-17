package code.lucamarrocco.wiki.ast;

import java.util.LinkedList;
import java.util.List;

public class Content extends Node  {
	private List<BodyDeclaration> bodyDeclarations = new LinkedList<BodyDeclaration>();

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((Content) this, arg);
	}

	public Content addBodyDeclaration(BodyDeclaration bodyDeclaration) {
		addChild(bodyDeclaration);

		bodyDeclarations.add(bodyDeclaration);

		return this;
	}

	public List<BodyDeclaration> getBodyDeclarations() {
		return bodyDeclarations;
	}
}
