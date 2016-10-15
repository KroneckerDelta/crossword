package de.mic.crossword;

import static de.mic.crossword.testdaten.Testfragen.ANZAHL_REIHEN;
import static de.mic.crossword.testdaten.Testfragen.ANZAHL_SPALTEN;
import static de.mic.crossword.testdaten.Testfragen.DIE_ACKERKRUME_LOCKERN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.mic.crossword.Raetsel.Richtung;
import de.mic.crossword.testdaten.TestRaetsel;

public class CrosswordTest {

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
		return new TestRaetsel().create();

	}

	@Test
	public void zelleHatFrageMitAckerkrumeLockern() throws Exception {
		Raetsel r = erstelleRaetsel();

		Zelle zelle = r.getZelle(1, 2);
		Frage frage = zelle.getFragen().get(0);
		String text = frage.getFrage();
		assertEquals(DIE_ACKERKRUME_LOCKERN, text);
	}

	@Test
	public void zelleHatFragen() throws Exception {
		Raetsel r = erstelleRaetsel();

		Zelle zelle = r.getZelle(1, 2);
		assertFalse(zelle.getFragen().isEmpty());

	}

	@Test
	public void zelleHatNurEineFrage() throws Exception {
		Raetsel r = erstelleRaetsel();

		Zelle zelle = r.getZelle(1, 2);
		assertEquals(1, zelle.getFragen().size());

	}

	@Test
	public void zelleHatZweiFragen() throws Exception {
		Raetsel r = erstelleRaetsel();

		Zelle zelle = r.getZelle(1, 3);
		assertEquals(2, zelle.getFragen().size());

	}

	@Test
	public void checkRaetsel() throws Exception {
		Raetsel r = erstelleRaetsel();

		checkRaetsel(r);
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

		assertEquals(2,

				r.getGewinnerfeld(1).getFragen().size());
		assertEquals(2, r.getGewinnerfeld(2).getFragen().size());
		assertEquals(2, r.getGewinnerfeld(3).getFragen().size());
		assertEquals(2, r.getGewinnerfeld(4).getFragen().size());
		assertEquals(2, r.getGewinnerfeld(5).getFragen().size());
		assertEquals(2, r.getGewinnerfeld(6).getFragen().size());
		assertEquals(2, r.getGewinnerfeld(7).getFragen().size());
		assertEquals(2, r.getGewinnerfeld(8).getFragen().size());
		assertEquals(2, r.getGewinnerfeld(9).getFragen().size());

		// for (Zelle zelle : r.getFrageZellen()) {
		// assertFalse(zelle.getFragen().isEmpty());
		// for (Frage frage : zelle.getFragen()) {
		// System.out.println("Antworten vorhanden: " +
		// !frage.getMoeglicheAntworten().isEmpty());
		// }
		// }
	}

}
