package de.mic.crossword;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.mic.crossword.Raetsel.Richtung;

public class CrosswordTest {

	private static final String WEIBLICHES_BUEHNENFACH = "weibliches Bühnenfach";

	private static final String FREUNDLICH = "freundlich";

	private static final String HANDARBEITSTECHNIK = "Handarbeitstechnik";

	private static final String WIDERHALL = "Widerhall";

	private static final String AUSFUEHREN_VERRICHTEN = "ausführen, verrichten";

	private static final String BUNDESSTAAT_DER_USA = "Bundesstaat der USA";

	private static final String REGE_MUNTER = "rege, munter";

	private static final String FRANZ_WEIBLICHER_ARTIKEL = "franz. weiblicher Artikel";

	private static final String RUHMESBAU_BEI_REGENSBURG = "Ruhmesbau bei Regensburg";

	private static final String AN_JEDEN_PLATZ_ORT = "an jeden Platz, Ort";

	private static final String BALDRIANGEWAECHS = "Baldriangewächs";

	private static final String LAUTSTAERKEMASS = "Lautstärkemaß";

	private static final String PAPSTKRONE = "Papstkrone";

	private static final String EIWEISSHALTIGE_NUTZPFLANZE = "eiweißhaltige Nutzpflanze";

	private static final String WUERDIGEN_AUSZEICHNEN_UGS = "würdigen, auszeichnen (ugs.)";

	private static final String BIBL_STAMMVATER_ARCHE = "bibl. Stammvater (Arche)";

	private static final String GARTENGERAET_HARKE = "Gartengerät, Harke";

	private static final String WESTAFRIKANER = "Westafrikaner";

	private static final String DIE_ACKERKRUME_LOCKERN = "die Ackerkrume lockern";

	private static final int ANZAHL_REIHEN = 13;

	private static final int ANZAHL_SPALTEN = 13;

	/**
	 * Dieser Test erstellt das Rätsel aus dem Bilder-Ordner
	 * 
	 * @throws Exception
	 */
	@Test
	public void erstelleTestRaetsel() throws Exception {

		Raetsel r = erstelleRaetsel();

		checkRaetsel(r);

	}

	@Test
	public void checkZellenRueckgabeSenkrecht() throws Exception {
		Raetsel r = erstelleRaetsel();

		List<Zelle> zellen = r.getZellen(2, Richtung.SENKRECHT, 2, 2);
		Zelle z1 = zellen.get(0);
		Zelle z2 = zellen.get(1);
		assertTrue(z1.isPosition(2, 2));
		assertTrue(z2.isPosition(2, 3));
	}

	@Test
	public void checkZellenRueckgabeWaagerecht() throws Exception {
		Raetsel r = erstelleRaetsel();

		List<Zelle> zellen = r.getZellen(2, Richtung.WAAGERECHT, 2, 2);
		Zelle z1 = zellen.get(0);
		Zelle z2 = zellen.get(1);
		assertTrue(z1.isPosition(2, 2));
		assertTrue(z2.isPosition(3, 2));
	}

	@Test
	public void checkAnzahlDerZellenRueckgabe() throws Exception {
		Raetsel r = erstelleRaetsel();

		List<Zelle> zellen = r.getZellen(2, Richtung.SENKRECHT, 2, 2);
		assertEquals(2, zellen.size());
	}

	@Test
	public void checkZellenRueckgabeIstNichtLeer() throws Exception {
		Raetsel r = erstelleRaetsel();

		List<Zelle> zellen = r.getZellen(2, Richtung.SENKRECHT, 2, 2);
		assertFalse(zellen.isEmpty());
	}

	private Raetsel erstelleRaetsel() {
		Raetsel r = new Raetsel();
		List<Zelle> alleZellen = new ArrayList<>();
		for (int i = 0; i < ANZAHL_SPALTEN; i++) {
			for (int j = 0; j < ANZAHL_REIHEN; j++) {
				alleZellen.add(new Zelle(new Point(i, j)));
			}
		}
		r.addAll(alleZellen);
		// Fragen hinzufügen
		erstelleDieFragen(r);

		erstelleDieGewinnerZellen(r);

		fuegeEchteFragenHinzu(r);

		fuegeAntwortenHinzu(r);
		return r;
	}

	private void fuegeAntwortenHinzu(Raetsel r) {

		RaetselAntwortenService service = new RaetselAntwortenService();
		List<Zelle> fragen = r.getFrageZellen();
		service.sammleAntworten(fragen);
	}

	private void fuegeEchteFragenHinzu(Raetsel r) {

		// Erste Reihe
		erstelleFrage(r, DIE_ACKERKRUME_LOCKERN, new Point(0, 0), Richtung.SENKRECHT, new Point(1, 0), 5);
		erstelleFrage(r, WESTAFRIKANER, new Point(0, 1), Richtung.WAAGERECHT, new Point(1, 1), 7);
		erstelleFrage(r, GARTENGERAET_HARKE, xy(0, 2), Richtung.WAAGERECHT, xy(0, 2), 6);
		erstelleFrage(r, BIBL_STAMMVATER_ARCHE, xy(0, 4), Richtung.WAAGERECHT, xy(1, 4), 4);
		erstelleFrage(r, WUERDIGEN_AUSZEICHNEN_UGS, xy(0, 5), Richtung.WAAGERECHT, xy(0, 6), 5);
		erstelleFrage(r, EIWEISSHALTIGE_NUTZPFLANZE, xy(0, 8), Richtung.WAAGERECHT, xy(0, 7), 4);
		erstelleFrage(r, PAPSTKRONE, xy(0, 9), Richtung.WAAGERECHT, xy(1, 9), 5);
		erstelleFrage(r, LAUTSTAERKEMASS, xy(0, 10), Richtung.WAAGERECHT, xy(0, 9), 4);
		erstelleFrage(r, BALDRIANGEWAECHS, xy(0, 11), Richtung.WAAGERECHT, xy(1, 11), 5);

		// zweite Reihe
		erstelleFrage(r, AN_JEDEN_PLATZ_ORT, xy(1, 5), Richtung.SENKRECHT, xy(1, 6), 7);
		// dritte Reihe
		erstelleFrage(r, RUHMESBAU_BEI_REGENSBURG, xy(2, 0), Richtung.SENKRECHT, xy(3, 0), 8);
		erstelleFrage(r, FRANZ_WEIBLICHER_ARTIKEL, xy(2, 2), Richtung.WAAGERECHT, xy(3, 2), 2);
		erstelleFrage(r, REGE_MUNTER, xy(2, 5), Richtung.WAAGERECHT, xy(3, 5), 7);
		erstelleFrage(r, BUNDESSTAAT_DER_USA, xy(2, 8), Richtung.SENKRECHT, xy(2, 9), 4);

		// vierte Reihe
		erstelleFrage(r, AUSFUEHREN_VERRICHTEN, xy(3, 8), Richtung.WAAGERECHT, xy(4, 8), 3);
		erstelleFrage(r, WIDERHALL, xy(3, 11), Richtung.WAAGERECHT, xy(4, 11), 4);

		// f�nfte Reihe
		erstelleFrage(r, HANDARBEITSTECHNIK, xy(4, 0), Richtung.SENKRECHT, xy(4, 1), 6);
		erstelleFrage(r, FREUNDLICH, xy(4, 7), Richtung.WAAGERECHT, xy(5, 7), 3);
		erstelleFrage(r, WEIBLICHES_BUEHNENFACH, xy(4, 10), Richtung.WAAGERECHT, xy(5, 10), 5);

	}

	private void erstelleFrage(Raetsel r, String frage, Point frageXY, Richtung richtung, Point antwortXY, int anzahl) {
		Frage f2 = new Frage(frage);
		f2.addZellen(r.getZellen(anzahl, richtung, antwortXY));
		Zelle zelle = r.getZelle(frageXY.x, frageXY.y);
		zelle.addFrage(f2);
		f2.setAntworten(getAntworten(f2));
	}

	private List<String> getAntworten(Frage f) {
		RaetselAntwortenService s = new RaetselAntwortenService() {
			@Override
			protected List<String> getAntworten(String frage) {
				return new RaetselTestdatenLoesungen().getAntworten(frage);
			}
		};
		return s.getAntworten(f.getFrage());

	}

	private void erstelleDieGewinnerZellen(Raetsel r) {
		erstelleGewinnerZelle(r, 1, 6, 8);
		erstelleGewinnerZelle(r, 2, 10, 9);
		erstelleGewinnerZelle(r, 4, 7, 7);
		erstelleGewinnerZelle(r, 5, 9, 1);
		erstelleGewinnerZelle(r, 7, 1, 2);
		erstelleGewinnerZelle(r, 8, 6, 3);
		erstelleGewinnerZelle(r, 9, 10, 4);
		erstelleGewinnerZelle(r, 10, 7, 6);
		erstelleGewinnerZelle(r, 12, 5, 5);

	}

	private void erstelleGewinnerZelle(Raetsel r, int x, int y, int stelle) {
		r.getZelle(x, y).addGewinnfeld(stelle);

	}

	private void erstelleDieFragen(Raetsel r) {
		erstelleFrageProReihe(0, r, 0, 2, 4, 5, 7, 9, 11, 12);
		erstelleFrageProReihe(1, r, 0, 8);
		erstelleFrageProReihe(2, r, 0, 2, 5, 11);
		erstelleFrageProReihe(3, r, 6, 8);
		erstelleFrageProReihe(4, r, 0, 5);
		erstelleFrageProReihe(5, r, 0, 1, 2, 10);
		erstelleFrageProReihe(6, r, 5, 8);
		erstelleFrageProReihe(7, r, 4, 9, 12);
		erstelleFrageProReihe(8, r, 0, 2, 3, 7, 8);
		erstelleFrageProReihe(9, r, 0, 6, 11);
		erstelleFrageProReihe(10, r, 4, 10);
		erstelleFrageProReihe(11, r, 0, 3, 8);
		erstelleFrageProReihe(12, r, 0, 6);
	}

	private void checkRaetsel(Raetsel r) {
		Assert.assertEquals(169, r.getAlleZellen().size());

		for (int y = 0; y < ANZAHL_REIHEN; y++) {
			for (int x = 0; x < ANZAHL_SPALTEN; x++) {
				assertNotNull(r.getZelle(x, y));
			}
		}

		assertNotNull(r.getGewinnerfeld(1));
		assertNotNull(r.getGewinnerfeld(2));
		assertNotNull(r.getGewinnerfeld(3));
		assertNotNull(r.getGewinnerfeld(4));
		assertNotNull(r.getGewinnerfeld(5));
		assertNotNull(r.getGewinnerfeld(6));
		assertNotNull(r.getGewinnerfeld(7));
		assertNotNull(r.getGewinnerfeld(8));
		assertNotNull(r.getGewinnerfeld(9));
		assertNull(r.getGewinnerfeld(10));

	}

	private void erstelleFrageProReihe(int x, Raetsel r, int... alleY) {

		for (int y : alleY) {
			r.getZelle(x, y).addEigenschaft(Zelltyp.FRAGE);
		}

	}

	private static Point xy(int x, int y) {
		return new Point(x, y);
	}
}
