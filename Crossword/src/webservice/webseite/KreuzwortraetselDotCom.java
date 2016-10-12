package webservice.webseite;

public class KreuzwortraetselDotCom implements RaetselHomepage {

	private final String URL = "http://www.kreuzwort-raetsel.com/f/";

	/**
	 * Liefert die URL zum direkten Abfragen zurück.
	 * 
	 * @param frage
	 * @return
	 */
	public String getUrl(String frage) {
		return URL + frage;
	}
}
