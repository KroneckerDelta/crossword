package de.mic.crossword;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Diese Klasse beinhaltet die Lösungen für die Testdaten.
 * 
 * @author michael
 *
 */
public class RaetselTestdatenLoesungen {

	private Map<String, List<String>> loesungen = new HashMap<>();

	/**
	 
	 */
	public RaetselTestdatenLoesungen() {
		fillDaten();
	}

	private void fillDaten() {

	}

	/**
	 * Liefert die Testdaten zurück.
	 * 
	 * @param frage
	 * @return
	 */
	public List<String> getAntworten(String frage) {
		return loesungen.get(frage);
	}
}
