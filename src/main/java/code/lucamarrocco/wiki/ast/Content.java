package code.lucamarrocco.wiki.ast;

import java.util.*;
import java.util.List;

/** @author Luca Marrocco */
public class Content extends BodyDeclaration implements Iterable<BodyDeclaration> {
	private List<BodyDeclaration> bodyDeclarations = new LinkedList<BodyDeclaration>();

	public Content addBodyDeclaration(BodyDeclaration bodyDeclaration) {
		addChild(bodyDeclaration);
		bodyDeclarations.add(bodyDeclaration);
		return this;
	}

	public Iterator<BodyDeclaration> iterator() {
		return bodyDeclarations.iterator();
	}

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	};

}
