http://wikiwiki.googlecode.com/files/wikiwiki-1.1.jar

&lt;wiki:gadget url="http://www.ohloh.net/p/81846/widgets/project\_users.xml" height="100"  border="0" /&gt;

## using as maven dependency ##
install in your local maven repository
```
$ svn checkout http://wikiwiki.googlecode.com/svn/trunk/ wikiwiki-read-only
$ mvn install
```

adding to your pom follows statements
```
<dependency>
  <groupId>code.lucamarrocco</groupId>
  <artifactId>wikiwiki</artifactId>
  <version>1.0</version>
</dependency>
```
public class WikiTest {
  @Test
  public void testParserBold() throws Exception {
    assertThat(wiki("'''value'''"), is("<b>value</b>"));
    assertThat(wiki("'''value"), is("<b>value</b>"));
  }

  @Test
  public void testParserBoldItalic() throws Exception {
    assertThat(wiki("'''''value'''''"), is("<b><i>value</i></b>"));
    assertThat(wiki("'''''value"), is("<b><i>value</i></b>"));
  }

  @Test
  public void testParserItalic() throws Exception {
    assertThat(wiki("''value''"), is("<i>value</i>"));
    assertThat(wiki("''value"), is("<i>value</i>"));
  }

  @Test
  public void testParserString() throws Exception {
    assertThat(wiki("some word with comma, semicolon; dot. etc @$%^^&(("), 
                 is("some word with comma, semicolon; dot. etc @$%^^&(("));
  }

  @Test
  public void testParserTitle1() throws Exception {
    assertThat(wiki("=value="), is("<h1>value</h1>"));
    assertThat(wiki("=value"), is("<h1>value</h1>"));
  }

  @Test
  public void testParserTitle2() throws Exception {
    assertThat(wiki("==value=="), is("<h2>value</h2>"));
    assertThat(wiki("==value"), is("<h2>value</h2>"));
  }

  @Test
  public void testParserTitle3() throws Exception {
    assertThat(wiki("===value==="), is("<h3>value</h3>"));
    assertThat(wiki("===value"), is("<h3>value</h3>"));
  }

  @Test
  public void testParserUnderline() throws Exception {
    assertThat(wiki("_value_"), is("<u>value</u>"));
    assertThat(wiki("_value"), is("<u>value</u>"));
  }

  @Test
  public void testParserLbracketUrlDescriptionRbracket() throws Exception {
    assertThat(wiki("[http://www.google.it google]"), 
                 is("<a href=\"http://www.google.it\">google</a>"));
    assertThat(wiki("[http://www.google.it google"), 
                 is("<a href=\"http://www.google.it\">google</a>"));
  }

  @Test
  public void testParserLbracketUrlRbracket() throws Exception {
    assertThat(wiki("[http://www.google.it]"), 
                 is("<a href=\"http://www.google.it\">http://www.google.it</a>"));
    assertThat(wiki("[http://www.google.it"), 
                 is("<a href=\"http://www.google.it\">http://www.google.it</a>"));
  }

  @Test
  public void testParserUrl() throws Exception {
    assertThat(wiki("http://www.google.it"), 
                 is("<a href=\"http://www.google.it\">http://www.google.it</a>"));
  }
}
}}}}```