package de.mic.crossword;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Dieser Service löst das Raetsel
 * 
 * @author michael
 *
 */
public class LoesungsService {

	/**
	 * Lösen aller Gewinnspielzellen
	 * 
	 * @param r
	 */
	public String gewinnzellenLoesen(Raetsel r) {
		System.out.println(
				"###################################################################################################");
		System.out.println("Beginne Lösung zu suchen");
		System.out.println(
				"###################################################################################################");
		for (Zelle erstesGewinnFeld : r.getAlleZellen()) {

			// Zelle erstesGewinnFeld = r.getGewinnerfeld(9);

			List<Frage> fragen = erstesGewinnFeld.getFragen();
			for (Frage frageGewinnerFeld : fragen) {
				List<Zelle> zellen = frageGewinnerFeld.getZellen();
				// int stelleGewinnerFeld = zellen.indexOf(erstesGewinnFeld);

				final String moeglicheLoesung = erstelleTemplate(zellen);
				List<String> antwortenGewinnerFeld = frageGewinnerFeld.getMoeglicheAntworten();
				List<String> antworten = antwortenGewinnerFeld.stream().filter(p -> p.matches(moeglicheLoesung))
						.collect(Collectors.toList());
				System.out.println("Frage: " + frageGewinnerFeld);
				System.out.println("Für Feld: " + erstesGewinnFeld);
				if (antworten.size() == 1) {
					System.out.println("Setze Wort: " + antworten.get(0));
					setzeAntwort(zellen, antworten.get(0));
				} else if (antworten.size() > 1) {
					machwas();
					System.out.println(
							"###################################################################################################");
					System.out.println("MehrereAntworten!");
					System.out.println(
							"###################################################################################################");
				} else {

					System.out.println("Keine Antwort gefunden.");
				}

			}
		}

		return r.getLoesungsWort();
	}

	private String erstelleTemplate(List<Zelle> zellen) {
		String loesungsWortTemplate = "";
		for (int stelle = 0; stelle < zellen.size(); stelle++) {

			Zelle z = zellen.get(stelle);
			if (z.hatBuchstaben()) {
				loesungsWortTemplate += z.getBuchstabe();
			} else {
				loesungsWortTemplate += ".";
			}
		}
		return loesungsWortTemplate;
	}

	private void machwas() {
		// TODO Auto-generated method stub

	}

	private void setzeAntwort(List<Zelle> zellen, String loesung) {
		for (int i = 0; i < zellen.size(); i++) {
			zellen.get(i).setBuchstabe((String.valueOf(loesung.charAt(i))));
		}

	}

}
