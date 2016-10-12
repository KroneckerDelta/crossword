package webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Liefert von einer URL die Antworten zurück.
 * 
 * @author michael
 *
 */
public class WebContent {

	public List<String> getAntworten(String url) throws IOException {
		List<String> result = new ArrayList<>();

		Document doc = open(url);

		result.addAll(extractLoesungen(doc));

		return result;

	}

	private Collection<? extends String> extractLoesungen(Document doc) {
		List<String> result = new ArrayList<String>();
		Element content = doc.getElementById("content");
		if (content != null) {

			Elements links = content.getElementsByTag("a");

			for (Element link : links) {
				String linkText = link.text();
				System.out.println("Antworten: " + linkText);
				if (result.contains(linkText)) {
					if (!linkText.isEmpty()) {
						result.add(linkText);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {

		String u1 = "http://www.kreuzwort.net/fragen/gartenger%C3%A4t.htm";
		String u2 = "https://www.xwords.de/quest/gartenger%C3%A4t";
		/**
		 * Danach kamen Links auf denen man drauf drücken musste!
		 */
		String u3 = "http://www.kreuzwort.net/suche?token=die+Ackerkrume+lockern";

		String u4 = "http://www.kreuzwort-raetsel.com/f/gartenger%C3%A4t";

		String u5 = "http://www.kreuzwort-raetsel.com/f/die-ackerkrume-lockern";

		System.out.println(u1);
		traversier(open(u1));
		System.out.println(u2);
		traversier(open(u2));
		System.out.println(u3);
		traversier(open(u3));
		System.out.println(u4);
		traversier(open(u4));

		System.out.println(u5);
		traversier(open(u5));

		System.out.println("##################################################################");

		// test1();

	}

	private static Document open(String url) throws IOException {
		return Jsoup.connect(url).get();
	}

	private static void traversier(Document document) {
		Element content = document.getElementById("content");
		if (content != null) {

			Elements links = content.getElementsByTag("a");

			List<String> result = new ArrayList<String>();
			for (Element link : links) {

				String linkText = link.text();
				System.out.println("Links: " + linkText);
				if (result.contains(linkText)) {
					if (!linkText.isEmpty()) {
						result.add(linkText);
					}
				}
			}
		} else {
			System.out.println("Nicht gefunden: ");
		}
	}
}
