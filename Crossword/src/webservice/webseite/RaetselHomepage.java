package webservice.webseite;

/**
 * Interface für verschiedene Webseiten für die Lösungen.
 * 
 * @author michael
 *
 */
public interface RaetselHomepage {
	/**
	 * Liefert die URL zur Homepage.
	 * 
	 * @return URL
	 */
	String getUrl(String frage);
}
