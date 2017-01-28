package de.mic.crossword.testdaten;

import java.util.Arrays;
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
		fillDatenDummy();

		checkDaten();
	}

	private void checkDaten() {
		System.out.println("Frage/Antworten: " + loesungen);
		System.out.println("Anzahl Fehler beim Zugriff: " + service.getFehlerhafteFragen().size());
		System.out.println("Fehlerhafte Fragen: " + service.getFehlerhafteFragen());
		System.out.println("Anzahl Fragen ohne Ergebnis: " + service.getKeinErgebnis().size());
		System.out.println("Fragen ohne Ergebnis: "+ service.getKeinErgebnis());

	}

	private void fillDatenDummy() {

		fillMap(Testfragen.AN_JEDEN_PLATZ_ORT, loesungen, "Ueberall");
		fillMap(Testfragen.DIE_ACKERKRUME_LOCKERN, loesungen, "Eggen");
		fillMap(Testfragen.WESTAFRIKANER, loesungen, "Ewe", " Malier", " Togoer", " Nigrer", " Ivorer", " Gabuner",
				" Ghanaer", " Ghanese", " Guineer", " Togolese", " Liberier", " Malinese", " Angolaner", " Kameruner",
				" Senegaler", " Liberianer", " Nigerianer", " Senegalese", " Mauretanier");
		fillMap(Testfragen.GARTENGERAET_HARKE, loesungen, "Forke", " Hacke", " Harke", " Sense", " Rechen", " Sichel",
				" Spaten", " Schere", " Maeher", " Schaufel", " Setzholz", " Ziehhacke", " Astschere", " Baumsaege",
				" Haecksler", " Ziehharke", " Kultivator", " Baumschere", " Schubkarre", " Giesskanne", " Spitzhacke",
				" Laubsauger", " Grasmaeher", " Grabegabel", " Laubrechen", " Motorhacke", " Rasenmaeher",
				" Rasenschere", " Rosenschere", " Heckenschere", " Vertikutierer", " Rasensprenger", " Kantenschneider",
				" Haeckselmaschine");
		fillMap(Testfragen.BIBL_STAMMVATER_ARCHE, loesungen, "Noah");
		fillMap(Testfragen.WUERDIGEN_AUSZEICHNEN_UGS, loesungen, "Ehren", " Loben", " Achten", " Belobigen",
				" Anerkennen", " Honorieren");
		fillMap(Testfragen.EIWEISSHALTIGE_NUTZPFLANZE, loesungen, "Soja");
		fillMap(Testfragen.PAPSTKRONE, loesungen, "Tiara");
		fillMap(Testfragen.LAUTSTAERKEMASS, loesungen, "Db", " Fon", " Phon", " Sone", " Dezibel");
		fillMap(Testfragen.BALDRIANGEWAECHS, loesungen, "Fedia", " Speik", " Narde", " Rapunze", " Baldrian",
				" Rapunzel", " Feldsalat", " Spornblume", " Algiersalat", " Echterspeik", " Rapunzelchen");

		fillMap(Testfragen.RUHMESBAU_BEI_REGENSBURG, loesungen, "Walhalla");
		fillMap(Testfragen.FRANZ_WEIBLICHER_ARTIKEL, loesungen, "La");
		fillMap(Testfragen.REGE_MUNTER, loesungen, "Agil", " Emsig", " Aktiv", " Munter", " Lebhaft", " Lebendig",
				" Umtriebig", " Betriebsam");
		fillMap(Testfragen.BUNDESSTAAT_DER_USA, loesungen, "Iowa", " Ohio", " Utah", " Maine", " Idaho", " Texas",
				" Nevada", " Alaska", " Hawaii", " Kansas", " Oregon", " Dakota", " Alabama", " Arizona", " Florida",
				" Georgia", " Indiana", " Montana", " Vermont", " Wyoming", " Illinois", " Arkansas", " Colorado",
				" Delaware", " Kentucky", " Maryland", " Michigan", " Missouri", " Nebraska", " Oklahoma", " Virginia",
				" Louisiana", " Minnesota", " Wisconsin", " Washington", " Kalifornien");
		fillMap(Testfragen.AUSFUEHREN_VERRICHTEN, loesungen, "Tun", " Bauen", " Machen", " Meistern", " Schaffen",
				" Taetigen", " Darlegen", " Erzeugen", " Einladen", " Fertigen", " Erfuellen", " Beendigen",
				" Erledigen", " Abwickeln", " Erstellen", " Erklaeren", " Einloesen", " Schaukeln", " Anfertigen",
				" Herstellen", " Verrichten", " Vollziehen", " Ausliefern", " Wahrmachen", " Realisieren",
				" Fabrizieren", " Produzieren", " Vollfuehren", " Durchziehen", " Verfertigen", " Exekutieren",
				" Exportieren", " Abschliessen", " Vollstrecken", " Verwirklichen", " Fertigstellen", " Zuwegebringen",
				" Amplifizieren", " Konkretisieren", " Bewerkstelligen", " Spazierenfahren", " Zustandebringen",
				" Spazierenfuehren");
		fillMap(Testfragen.WIDERHALL, loesungen, "Echo", " Klang", " Schall", " Anklang", " Wirkung", " Aufnahme",
				" Resonanz", " Nachklang");
		fillMap(Testfragen.HANDARBEITSTECHNIK, loesungen, "Occhi", " Naehen", " Haekeln", " Knuepfen", " Stricken",
				" Patchwork", " Kreuzstich", " Kloeppelei", " Filetarbeit");
		fillMap(Testfragen.FREUNDLICH, loesungen, "Nett", " Lieb", " Heiter", " Guetig", " Kordial", " Angenehm",
				" Charmant", " Herzlich", " Leutselig", " Konziliant", " Warmherzig", " Unbewoelkt", " Sympathisch",
				" Verbindlich", " Liebenswert", " Ansprechend", " Umgaenglich", " Wohlwollend", " Liebenswuerdig",
				" Entgegenkommend");
		fillMap(Testfragen.WEIBLICHES_BUEHNENFACH, loesungen, "Alte", " Naive", " Heldin", " Heroine");

		fillMap(Testfragen.DUESENFLUGZEUG, loesungen, "Jet");
		fillMap(Testfragen.FRUEHERE_MUENZE, loesungen, "Taler");
		fillMap(Testfragen.ALGERISCHE_STADT, loesungen, "Bone", " Oran", " Kafi", " Blida", " Setif", " Saida",
				" Algier", " Annaba", " Skikda", " Biskra", " Abadla", " Bejaja", " Bechar", " Mascara", " Tlemcen",
				" Zeralda", " Constantine", " Tamanrasset", " Sidibelabbes");
		fillMap(Testfragen.EINWOHNER_DER_GRIECH_HAUPTSTADT, loesungen, "Athener");
		fillMap(Testfragen.KNOCHENGERUEST, loesungen, "Gebein", " Gerippe", " Skelett", " Gebeine");
		fillMap(Testfragen.STADT_AN_DER_MURG, loesungen, "");
		fillMap(Testfragen.VERMUTEN, loesungen, "Ahnen", " Meinen", " Waehnen", " Erahnen", " Glauben", " Erraten",
				" Erwarten", " Annehmen", " Schwanen", " Schaetzen", " Mutmassen", " Spekulieren");
		fillMap(Testfragen.BUCH_DES_ALTEN_TESTAMENTS, loesungen, "Hiob", " Amos");
		fillMap(Testfragen.GEBIRGE_ZWISCHEN_EUROPA_UND_ASIEN, loesungen, "Ural");
		fillMap(Testfragen.REICH_AN_LICHT, loesungen, "Hell");
		fillMap(Testfragen.FEINER_UNTERSCHIED_FEINHEIT, loesungen, "Differenz");

	}

	private void fillMap(String key, Map<String, List<String>> map, String... loesung) {
		map.put(key, Arrays.asList(loesung));
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
