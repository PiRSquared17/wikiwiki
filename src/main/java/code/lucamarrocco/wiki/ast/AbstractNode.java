package code.lucamarrocco.wiki.ast;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractNode implements Node {

	private List<Node> children = new LinkedList<Node>();

	public void addChild(Node child) {
		children.add(child);
	}

	public List<Node> getChildren() {
		return children;
	}
}