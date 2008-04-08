package code.lucamarrocco.wiki.ast;

public interface List extends ListItem {
	final String ROLE = "listText";

	final int ORDERED_LIST = 1;

	final int UNORDERED_LIST = 2;

	List addListItem(ListItem listItem);

	java.util.List<ListItem> getListItems();

	List setType(int type);

	int getType();
}
