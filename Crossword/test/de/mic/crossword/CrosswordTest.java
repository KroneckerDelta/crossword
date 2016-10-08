package de.mic.crossword;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CrosswordTest {

	/**
	 * Dieser Test erstellt das Rätsel aus dem Bilder-Ordner
	 * 
	 * @throws Exception
	 */
	@Test
	public void erstelleTestRaetsel() throws Exception {

		Raetsel r = new Raetsel();
		List<Zelle> alleZellen = new ArrayList<>();
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				alleZellen.add(new Zelle(new Point(i, j)));
			}
		}
		r.addAll(alleZellen);
		// Fragen hinzufügen
		r.getZelle(0, 0).addEigenschaft(Zelltyp.FRAGE);

	}
}
