package code.lucamarrocco.wiki.ast;

/** @author Luca Marrocco */
public abstract class List extends ListItem {

	public List addListItem(ListItem listItem) {
		addBodyDeclaration(listItem);
		return this;
	}
}
