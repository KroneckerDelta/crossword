package webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import webservice.webseite.RaetselHomepage;

/**
 * Liefert von einer URL die Antworten zurück.
 * 
 * @author michael
 *
 */
public class AntwortenService {

	private RaetselHomepage homepage;
	private List<String> fehlerhafteFragen = new ArrayList<>();
	private List<String> keinErgebnis = new ArrayList<>();

	/**
	 * Erstellt einen Service für die entsprechenden Homepage.
	 * 
	 * @param homepage
	 */
	public AntwortenService(RaetselHomepage homepage) {
		this.homepage = homepage;

	}

	/**
	 * Holt von der konfigurierten Homepage die Antworten zur Rätselfrage
	 * 
	 * @param frage
	 * @return
	 * @throws IOException
	 */
	public List<String> getAntworten(String frage) {
		String[] splitted = frage.split(",");
		List<String> antworten = new ArrayList<>();
		for (String s : splitted) {

			String frageUmgestellt = new Umlaut2HtmlConverter().convertHtmlKonform(s);
			try {
				String url = homepage.getUrl(frageUmgestellt);
				antworten.addAll(openConnectionAndCollectAnswers(url));
				if (antworten.isEmpty()) {
					keinErgebnis.add(frage);
				}
				return antworten;
			} catch (IOException e) {
				fehlerhafteFragen.add(frage);
				// e.printStackTrace();
			}
		}
		return antworten;
	}

	private List<String> openConnectionAndCollectAnswers(String url) throws IOException {
		List<String> result = new ArrayList<>();

		Document doc = open(url);

		result.addAll(sammleLoesungen(doc));

		return result;

	}

	private Collection<? extends String> sammleLoesungen(Document doc) {
		List<String> result = new ArrayList<String>();
		Element content = doc.getElementById("content");
		if (content != null) {

			Elements links = content.getElementsByTag("a");

			for (Element link : links) {
				String linkText = link.text();
				System.out.println("Antworten: " + linkText);
				if (!result.contains(linkText)) {
					if (!linkText.isEmpty()) {
						result.add(linkText);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args)  {

		String u1 = "http://www.kreuzwort.net/fragen/gartenger%C3%A4t.htm";
		String u2 = "https://www.xwords.de/quest/gartenger%C3%A4t";
		/**
		 * Danach kamen Links auf denen man drauf drücken musste!
		 */
		String u3 = "http://www.kreuzwort.net/suche?token=die+Ackerkrume+lockern";

		String u4 = "http://www.kreuzwort-raetsel.com/f/gartenger%C3%A4t";

		String u5 = "http://www.kreuzwort-raetsel.com/f/die-ackerkrume-lockern";

		System.out.println(u1);
		try {
			traversier(open(u1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u2);
		System.out.println(u2);
		try {
			traversier(open(u2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u3);
		try {
			traversier(open(u3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u4);
		try {
			traversier(open(u4));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(u5);
		try {
			traversier(open(u5));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	/**
	 * Liefert die Fragen zurück, die beim Verbinden einen Fehler verursachten.
	 * 
	 * @return Liste mit Fragen.
	 */
	public List<String> getFehlerhafteFragen() {
		return fehlerhafteFragen;
	}

	/**
	 * Liefert dieFragen zurück, die kein Ergebnis lieferten.
	 * 
	 * @return Liste mit Fragen.
	 */
	public List<String> getKeinErgebnis() {
		return keinErgebnis;
	}
}
