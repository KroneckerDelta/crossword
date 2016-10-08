package de.mic.crossword;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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

		Raetsel r = new Raetsel();
		List<Zelle> alleZellen = new ArrayList<>();
		for (int i = 0; i < ANZAHL_SPALTEN; i++) {
			for (int j = 0; j < ANZAHL_REIHEN; j++) {
				alleZellen.add(new Zelle(new Point(i, j)));
			}
		}
		r.addAll(alleZellen);
		// Fragen hinzufügen
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

		checkRaetsel(r);

	}

	private void checkRaetsel(Raetsel r) {
		Assert.assertEquals(169, r.getAlleZellen().size());

		for (int y = 0; y < ANZAHL_REIHEN; y++) {
			for (int x = 0; x < ANZAHL_SPALTEN; x++) {
				assertNotNull(r.getZelle(x, y));
			}
		}

	}

	private void erstelleFrageProReihe(int x, Raetsel r, int... alleY) {

		for (int y : alleY) {
			r.getZelle(x, y).addEigenschaft(Zelltyp.FRAGE);
		}

	}
}
