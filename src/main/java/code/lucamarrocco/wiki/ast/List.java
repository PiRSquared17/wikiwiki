package code.lucamarrocco.wiki.ast;

import java.util.*;

/** @author Luca Marrocco */
public class List extends ListItem implements Iterable<ListItem> {

	public static final int ORDERED_LIST = 1;

	public static final int UNORDERED_LIST = 2;

	private java.util.List<ListItem> listItems = new LinkedList<ListItem>();

	private int type;

	private Text text = new Text();

	public Iterator<ListItem> iterator() {
		return listItems.iterator();
	}
	
	public List() {}

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((List) this, arg);
	}

	public List addListItem(ListItem listItem) {
		listItems.add(listItem);
		return this;
	}

	public Text getText() {
		return text;
	}

	public int getType() {
		return type;
	}

	public List setText(Text text) {
		this.text = text;
		return this;
	}

	public List setType(int type) {
		this.type = type;
		return this;
	}
}
