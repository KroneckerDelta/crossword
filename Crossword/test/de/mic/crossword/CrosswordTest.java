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
		return r;
	}

	private void fuegeEchteFragenHinzu(Raetsel r) {

		Frage f1 = new Frage("die Ackerkrume lockern");

		f1.addZellen(r.getZellen(5, de.mic.crossword.Raetsel.Richtung.SENKRECHT, 1, 0));
		r.getZelle(0, 0).addFrage(f1);

		Frage f2 = new Frage("Westafrikaner");
		f2.addZellen(r.getZellen(5, de.mic.crossword.Raetsel.Richtung.WAAGERECHT, 1, 1));
		r.getZelle(0, 1).addFrage(f2);

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
}
