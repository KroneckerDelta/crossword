package de.mic.crossword;

import static de.mic.crossword.Testfragen.DIE_ACKERKRUME_LOCKERN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import de.mic.crossword.Raetsel.Richtung;

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

}
