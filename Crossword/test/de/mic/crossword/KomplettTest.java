package de.mic.crossword;

import org.junit.Test;

import de.mic.crossword.testdaten.TestRaetsel;

public class KomplettTest {

	/**
	 * Dieser Test erstellt das Rätsel aus dem Bilder-Ordner
	 * 
	 * @throws Exception
	 */
	@Test
	public void erstelleTestRaetsel() throws Exception {

		Raetsel r = erstelleRaetsel();

		String loesung = new LoesungsService().gewinnzellenLoesen(r);
		System.out.println(r);
		System.out.println("Lösung: " + loesung);

	}

	private Raetsel erstelleRaetsel() {
		return new TestRaetsel().create();

	}

}
