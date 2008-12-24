package code.lucamarrocco.wiki.parser;

import static code.lucamarrocco.wiki.parser.WikiParser.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.*;

import junit.framework.*;

import org.junit.Test;

import code.lucamarrocco.wiki.ast.*;

/** @author Luca Marrocco */
public class WikiParserSomeTest extends TestCase {
	@Test
	public void testWikiParserBold() throws Exception {
		Content content = parse("'''bold'''");

		DecoratedBoldText boldText = (DecoratedBoldText) content.iterator().next();
		DecoratedNormalText normalText = (DecoratedNormalText) boldText.iterator().next();
		Text text = (Text) normalText.iterator().next();

		assertThat(text.toString(), is(equalTo("bold")));
	}

	public void testWikiParserBoldItalic() throws Exception {
		Content content = parse("'''''bolditalic'''''");

		DecoratedBoldText boldText = (DecoratedBoldText) content.iterator().next();
		DecoratedItalicText italicText = (DecoratedItalicText) boldText.iterator().next();
		DecoratedNormalText normalText = (DecoratedNormalText) italicText.iterator().next();
		Text text = (Text) normalText.iterator().next();

		assertThat(text.toString(), is(equalTo("bolditalic")));
	}

	public void testWikiParserContent() throws Exception {
		Content content = parse("content");

		Text text = (Text) content.iterator().next();

		assertThat(text.toString(), is(equalTo("content")));
	}

	public void testWikiParserItalic() throws Exception {
		Content content = parse("''italic''");

		DecoratedItalicText italicText = (DecoratedItalicText) content.iterator().next();
		DecoratedNormalText normalText = (DecoratedNormalText) italicText.iterator().next();
		Text text = (Text) normalText.iterator().next();

		assertThat(text.toString(), is(equalTo("italic")));
	}

	public void testWikiParserUnderline() throws Exception {
		Content content = parse("_underline_");

		DecoratedUnderlineText underlineText = (DecoratedUnderlineText) content.iterator().next();
		DecoratedNormalText normalText = (DecoratedNormalText) underlineText.iterator().next();
		Text text = (Text) normalText.iterator().next();

		assertThat(text.toString(), is(equalTo("underline")));
	}

	public void testWikiParserOrderedList() throws Exception {
		Content content = parse("# item");

		OrderedList unorderedList = (OrderedList) content.iterator().next();
		ListItem listItem = (ListItem) unorderedList.iterator().next();
		DecoratedNormalText normalText = (DecoratedNormalText) listItem.iterator().next();
		Text text = (Text) normalText.iterator().next();
		
		assertThat(text.toString(), is(equalTo("item")));
	}

	public void testWikiParserTitle1() throws Exception {
		Content content = parse("=content=");

		TitleText titleText = (TitleText) content.iterator().next();
		Text text = (Text) titleText.iterator().next();

		assertThat(text.toString(), is(equalTo("content")));
	}

	public void testWikiParserTitle2() throws Exception {
		Content content = parse("==content==");

		TitleText titleText = (TitleText) content.iterator().next();
		Text text = (Text) titleText.iterator().next();

		assertThat(text.toString(), is(equalTo("content")));
	}

	public void testWikiParserTitle3() throws Exception {
		Content content = parse("===content===");

		TitleText titleText = (TitleText) content.iterator().next();
		Text text = (Text) titleText.iterator().next();

		assertThat(text.toString(), is(equalTo("content")));
	}

	public void testWikiParserUnorderedList() throws Exception {
		Content content = parse("* item");

		UnorderedList orderedList = (UnorderedList) content.iterator().next();
		ListItem listItem = (ListItem) orderedList.iterator().next();
		DecoratedNormalText normalText = (DecoratedNormalText) listItem.iterator().next();
		Text text = (Text) normalText.iterator().next();
		
		assertThat(text.toString(), is(equalTo("item")));
	}

	public void testWikiParserWikiWord() throws Exception {
		Content content = parse("WikiWord");

		LinkText linkText = (LinkText) content.iterator().next();
		Text text = (Text) linkText.getText();

		assertThat(text.toString(), is(equalTo("WikiWord")));
	}

	public void testWikiParserWikiWordAndAnotherWikiWord() throws Exception {
		Content content = parse("WikiWord AnotherWikiWord");

		Iterator iterator = content.iterator();
		LinkText linkText = (LinkText) iterator.next();
		LinkText linkText2 = (LinkText) iterator.next();
		Text text = (Text) linkText.getText();
		Text text2 = (Text) linkText2.getText();

		assertThat(text.toString(), is(equalTo("WikiWord")));
		assertThat(text2.toString(), is(equalTo("AnotherWikiWord")));
	}
}