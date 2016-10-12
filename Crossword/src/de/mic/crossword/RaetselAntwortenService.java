package de.mic.crossword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Holt zu einer Frage mögliche Antworten
 * 
 * @author michael
 *
 */
public class RaetselAntwortenService {

	public void sammleAntworten(List<Zelle> zellenMitFragen) {
		for (Zelle z : zellenMitFragen) {
			List<Frage> fragen = z.getFragen();
			for (Frage f : fragen) {
				String formulierteFrage = f.getFrage();
				f.setAntworten(sucheAntworten(formulierteFrage, f.getAntwortLaenge()));
			}
		}
	}

	protected List<String> sucheAntworten(String formulierteFrage, int laenge) {
		List<String> result = new ArrayList<String>();

		return result;

	}

	/**
	 * Liefert für eine Frage eine Liste von Antworten.
	 * 
	 * @param frage
	 * @return
	 */
	protected List<String> getAntworten(String frage) {
		return Arrays.asList("");
	}

}
