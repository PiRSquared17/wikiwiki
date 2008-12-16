package code.lucamarrocco.wiki.ast;

import java.util.LinkedList;

public class DefaultList extends AbstractBodyDeclaration implements List {
	private java.util.List<ListItem> listItems;

	private int type;

	private Text text;

	public DefaultList() {
		setListItems(new LinkedList<ListItem>());
	}

	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit((List) this, arg);
	}

	public List addListItem(ListItem listItem) {
		listItems.add(listItem);

		return this;
	}

	public java.util.List<ListItem> getListItems() {
		return listItems;
	}

	public Text getText() {
		return text;
	}

	public int getType() {
		return type;
	}

	public void setListItems(java.util.List<ListItem> listItems) {
		this.listItems = listItems;
	}

	public ListItem setText(Text text) {
		this.text = text;

		return this;
	}

	public List setType(int type) {
		this.type = type;

		return this;
	}
}
