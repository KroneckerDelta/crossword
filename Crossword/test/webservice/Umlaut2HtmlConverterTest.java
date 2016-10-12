package webservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Umlaut2HtmlConverterTest {

	@Test
	public void shouldSplittInTwoParts() throws Exception {
		String converted = new Umlaut2HtmlConverter().convertHtmlKonform("garten,haus");
		assertEquals("garten+haus", converted);
	}
}
