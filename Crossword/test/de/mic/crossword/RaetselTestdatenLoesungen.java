package de.mic.crossword;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import webservice.AntwortenService;
import webservice.webseite.KreuzwortraetselDotCom;

/**
 * Diese Klasse beinhaltet die Lösungen für die Testdaten.
 * 
 * @author michael
 *
 */
public class RaetselTestdatenLoesungen {

	private Map<String, List<String>> loesungen = new HashMap<>();
	AntwortenService service = null;

	/**
	 
	 */
	public RaetselTestdatenLoesungen(AntwortenService service) {
		this.service = service;
		fillDaten();

		checkDaten();
	}

	private void checkDaten() {
		System.out.println("Frage/Antworten: " + loesungen);
		System.out.println("Fehler beim Zugriff: " + service.getFehlerhafteFragen().size());
		System.out.println(service.getFehlerhafteFragen());
		System.out.println("Kein Ergebnis: " + service.getKeinErgebnis().size());
		System.out.println(service.getKeinErgebnis());

	}

	private void fillDaten() {

		fillMap(Testfragen.AN_JEDEN_PLATZ_ORT, loesungen, service);
		fillMap(Testfragen.DIE_ACKERKRUME_LOCKERN, loesungen, service);
		fillMap(Testfragen.WESTAFRIKANER, loesungen, service);
		fillMap(Testfragen.GARTENGERAET_HARKE, loesungen, service);
		fillMap(Testfragen.BIBL_STAMMVATER_ARCHE, loesungen, service);
		fillMap(Testfragen.WUERDIGEN_AUSZEICHNEN_UGS, loesungen, service);
		fillMap(Testfragen.EIWEISSHALTIGE_NUTZPFLANZE, loesungen, service);
		fillMap(Testfragen.PAPSTKRONE, loesungen, service);
		fillMap(Testfragen.LAUTSTAERKEMASS, loesungen, service);
		fillMap(Testfragen.BALDRIANGEWAECHS, loesungen, service);

		fillMap(Testfragen.RUHMESBAU_BEI_REGENSBURG, loesungen, service);
		fillMap(Testfragen.FRANZ_WEIBLICHER_ARTIKEL, loesungen, service);
		fillMap(Testfragen.REGE_MUNTER, loesungen, service);
		fillMap(Testfragen.BUNDESSTAAT_DER_USA, loesungen, service);
		fillMap(Testfragen.AUSFUEHREN_VERRICHTEN, loesungen, service);
		fillMap(Testfragen.WIDERHALL, loesungen, service);
		fillMap(Testfragen.HANDARBEITSTECHNIK, loesungen, service);
		fillMap(Testfragen.FREUNDLICH, loesungen, service);
		fillMap(Testfragen.WEIBLICHES_BUEHNENFACH, loesungen, service);

		fillMap(Testfragen.DUESENFLUGZEUG, loesungen, service);
		fillMap(Testfragen.FRUEHERE_MUENZE, loesungen, service);
		fillMap(Testfragen.ALGERISCHE_STADT, loesungen, service);
		fillMap(Testfragen.EINWOHNER_DER_GRIECH_HAUPTSTADT, loesungen, service);
		fillMap(Testfragen.KNOCHENGERUEST, loesungen, service);
		fillMap(Testfragen.STADT_AN_DER_MURG, loesungen, service);
		fillMap(Testfragen.VERMUTEN, loesungen, service);
		fillMap(Testfragen.BUCH_DES_ALTEN_TESTAMENTS, loesungen, service);
		fillMap(Testfragen.GEBIRGE_ZWISCHEN_EUROPA_UND_ASIEN, loesungen, service);
		fillMap(Testfragen.REICH_AN_LICHT, loesungen, service);
		fillMap(Testfragen.FEINER_UNTERSCHIED_FEINHEIT, loesungen, service);

	}

	private void fillMap(String key, Map<String, List<String>> map, AntwortenService service) {
		map.put(key, service.getAntworten(key));

	}

	/**
	 * Liefert die Testdaten zur+ck.
	 * 
	 * @param frage
	 * @return
	 */
	public List<String> getAntworten(String frage) {
		return loesungen.get(frage);
	}

	public static void main(String[] args) {
		new RaetselTestdatenLoesungen(new AntwortenService(new KreuzwortraetselDotCom()));
	}
}
