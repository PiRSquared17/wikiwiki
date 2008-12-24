package code.lucamarrocco.wiki.ast;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.*;

/** @author Luca Marrocco */
public abstract class Node {
	private List<Node> children = new LinkedList<Node>();

	public void addChild(Node child) {
		children.add(child);
	}

	public abstract <A> void accept(Visitor<A> visitor, A arg);

	private Log log = LogFactory.getLog(getClass());
}