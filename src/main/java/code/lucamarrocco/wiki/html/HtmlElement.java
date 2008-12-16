package code.lucamarrocco.wiki.html;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class HtmlElement {
	private Map<String, Object> attrs;

	private List<HtmlElement> children;

	private String name;

	private String value;

	public HtmlElement() {
		this.children = new LinkedList<HtmlElement>();

		this.attrs = new HashMap<String, Object>();
	}

	public HtmlElement addAttribute(String name, Object value) {
		getAttrs().put(name, value);

		return this;
	}

	public HtmlElement addChild() {
		HtmlElement childHtmlElement = new HtmlElement();

		children.add(childHtmlElement);

		return childHtmlElement;
	}

	public Map<String, Object> getAttrs() {
		return attrs;
	}

	public List<HtmlElement> getChildren() {
		return children;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public HtmlElement setName(String name) {
		this.name = name;

		return this;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();

		boolean hasName = !StringUtils.isBlank(getName());
		boolean hasValue = !StringUtils.isBlank(getValue());

		if (!hasName && !hasValue) {
			for (HtmlElement element : getChildren()) {
				stringBuffer.append(element);
			}
			return stringBuffer.toString();
		}

		if (!hasName && hasValue) {
			stringBuffer.append(getValue());
			return stringBuffer.toString();
		}

		stringBuffer.append("<");
		stringBuffer.append(getName());

		for (String name : getAttrs().keySet()) {
			stringBuffer.append(" ");
			stringBuffer.append(name);
			stringBuffer.append("=");
			stringBuffer.append("\"");
			stringBuffer.append(getAttrs().get(name));
			stringBuffer.append("\"");
		}

		boolean hasntChildren = getChildren().isEmpty() && StringUtils.isBlank(getValue());
		boolean hasChildren = !hasntChildren;

		if (hasntChildren) {
			stringBuffer.append("/>");
			return stringBuffer.toString();
		}

		if (hasChildren) {
			stringBuffer.append(">");

			for (HtmlElement element : getChildren()) {
				stringBuffer.append(element);
			}

			stringBuffer.append("</");
			stringBuffer.append(getName());
			stringBuffer.append(">");
		}

		return stringBuffer.toString();
	}
}