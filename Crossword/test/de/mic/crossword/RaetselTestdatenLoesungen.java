package de.mic.crossword;

import static de.mic.crossword.Testfragen.AN_JEDEN_PLATZ_ORT;
import static de.mic.crossword.Testfragen.AUSFUEHREN_VERRICHTEN;
import static de.mic.crossword.Testfragen.BALDRIANGEWAECHS;
import static de.mic.crossword.Testfragen.BIBL_STAMMVATER_ARCHE;
import static de.mic.crossword.Testfragen.BUNDESSTAAT_DER_USA;
import static de.mic.crossword.Testfragen.DIE_ACKERKRUME_LOCKERN;
import static de.mic.crossword.Testfragen.EIWEISSHALTIGE_NUTZPFLANZE;
import static de.mic.crossword.Testfragen.FRANZ_WEIBLICHER_ARTIKEL;
import static de.mic.crossword.Testfragen.FREUNDLICH;
import static de.mic.crossword.Testfragen.GARTENGERAET_HARKE;
import static de.mic.crossword.Testfragen.HANDARBEITSTECHNIK;
import static de.mic.crossword.Testfragen.LAUTSTAERKEMASS;
import static de.mic.crossword.Testfragen.PAPSTKRONE;
import static de.mic.crossword.Testfragen.REGE_MUNTER;
import static de.mic.crossword.Testfragen.RUHMESBAU_BEI_REGENSBURG;
import static de.mic.crossword.Testfragen.WEIBLICHES_BUEHNENFACH;
import static de.mic.crossword.Testfragen.WESTAFRIKANER;
import static de.mic.crossword.Testfragen.WIDERHALL;
import static de.mic.crossword.Testfragen.WUERDIGEN_AUSZEICHNEN_UGS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Diese Klasse beinhaltet die L�sungen f�r die Testdaten.
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
		loesungen.put(Testfragen.AN_JEDEN_PLATZ_ORT, Arrays.asList("abc", "def"));

		loesungen.put(DIE_ACKERKRUME_LOCKERN, Arrays.asList("abc", "def"));
		loesungen.put(WESTAFRIKANER, Arrays.asList("abc", "def"));
		loesungen.put(GARTENGERAET_HARKE, Arrays.asList("abc", "def"));
		loesungen.put(BIBL_STAMMVATER_ARCHE, Arrays.asList("abc", "def"));
		loesungen.put(WUERDIGEN_AUSZEICHNEN_UGS, Arrays.asList("abc", "def"));
		loesungen.put(EIWEISSHALTIGE_NUTZPFLANZE, Arrays.asList("abc", "def"));
		loesungen.put(PAPSTKRONE, Arrays.asList("abc", "def"));
		loesungen.put(LAUTSTAERKEMASS, Arrays.asList("abc", "def"));
		loesungen.put(BALDRIANGEWAECHS, Arrays.asList("abc", "def"));

		loesungen.put(AN_JEDEN_PLATZ_ORT, Arrays.asList("abc", "def"));

		loesungen.put(RUHMESBAU_BEI_REGENSBURG, Arrays.asList("abc", "def"));
		loesungen.put(FRANZ_WEIBLICHER_ARTIKEL, Arrays.asList("abc", "def"));
		loesungen.put(REGE_MUNTER, Arrays.asList("abc", "def"));
		loesungen.put(BUNDESSTAAT_DER_USA, Arrays.asList("abc", "def"));

		loesungen.put(AUSFUEHREN_VERRICHTEN, Arrays.asList("abc", "def"));
		loesungen.put(WIDERHALL, Arrays.asList("abc", "def"));

		loesungen.put(HANDARBEITSTECHNIK, Arrays.asList("abc", "def"));
		loesungen.put(FREUNDLICH, Arrays.asList("abc", "def"));
		loesungen.put(WEIBLICHES_BUEHNENFACH, Arrays.asList("abc", "def"));

	}

	/**
	 * Liefert die Testdaten zur�ck.
	 * 
	 * @param frage
	 * @return
	 */
	public List<String> getAntworten(String frage) {
		return loesungen.get(frage);
	}
}
