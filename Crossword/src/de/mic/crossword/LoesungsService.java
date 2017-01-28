package de.mic.crossword;

import java.util.ArrayList;
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

		List<Zelle> mehrereAntworten = new ArrayList<>();
		List<Zelle> keineAntwort = new ArrayList<>();
		List<Zelle> alleZellen = r.getAlleZellen();
		fillLists(mehrereAntworten, keineAntwort, alleZellen);

		logFehler(mehrereAntworten, keineAntwort);

		boolean abbruch = false;
		int zaehler = 0;
		while (!abbruch && !keineAntwort.isEmpty() && !mehrereAntworten.isEmpty()) {
			keineAntwort.clear();
			mehrereAntworten.clear();
			fillLists(mehrereAntworten, keineAntwort, alleZellen);
			logFehler(mehrereAntworten, keineAntwort);
			zaehler++;
			if (zaehler > 3) {
				abbruch = true;
			}
		}

		return r.getLoesungsWort();
	}

	private void logFehler(List<Zelle> mehrereAntworten, List<Zelle> keineAntwort) {
		System.out.println("Anzahl mehrerer Antworten und keiner Antworten (" + mehrereAntworten.size() + "/"
				+ keineAntwort.size() + ")");
	}

	private void fillLists(List<Zelle> meherereAntworten, List<Zelle> keineAntwort, List<Zelle> alleZellen) {
		for (Zelle zelle : alleZellen) {

			findAntwortProZelle(meherereAntworten, keineAntwort, zelle);
		}
	}

	private void findAntwortProZelle(List<Zelle> meherereAntworten, List<Zelle> keineAntwort, Zelle zelle) {
		// Zelle erstesGewinnFeld = r.getGewinnerfeld(9);

		List<Frage> fragen = zelle.getFragen();
		for (Frage zellFragen : fragen) {
			if (!zelle.hatBuchstaben()) {

				List<Zelle> zellen = zellFragen.getZellen();
				// int stelleGewinnerFeld =
				// zellen.indexOf(erstesGewinnFeld);

				List<String> antworten = findeAntworten(zellen, zellFragen);

				logAntworten(zelle, zellFragen, antworten);

				if (antworten.size() == 1) {
					System.out.println(
							"###################################################################################################");

					System.out.println("Setze Wort: " + antworten.get(0));
					System.out.println(
							"###################################################################################################");

					setzeAntwort(zellen, antworten.get(0));
				} else if (antworten.size() > 1) {

					meherereAntworten.add(zelle);
					machwas();
					System.out.println(
							"###################################################################################################");
					System.out.println("MehrereAntworten!");
					System.out.println(
							"###################################################################################################");
				} else {

					keineAntwort.add(zelle);
					System.out.println("Keine Antwort gefunden.");
				}
			}

		}
	}

	private void logAntworten(Zelle zelle, Frage zellFragen, List<String> antworten) {
		System.out.println("Übrig gebliebene Antworten: " + antworten);
		System.out.println("Frage: " + zellFragen.getFrage());
		System.out.println("Für Feld: " + zelle.getPosition());
	}

	private List<String> findeAntworten(final List<Zelle> zellen, Frage zellFragen) {

		final String loesungsTemplate = erstelleTemplate(zellen);

		List<String> antwortenGewinnerFeld = zellFragen.getMoeglicheAntworten();

		System.out.println("mögliche Antworten: " + antwortenGewinnerFeld);

		return antwortenGewinnerFeld.stream().filter(p -> p.matches(loesungsTemplate)).collect(Collectors.toList());
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
		System.out.println("Lösungstemplate: " + loesungsWortTemplate);
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
