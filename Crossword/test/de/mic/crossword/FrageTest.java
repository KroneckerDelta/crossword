package de.mic.crossword;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

public class FrageTest {

	@Test
	public void checkFrageHatZellenFuerLoesung() {
		Frage frage = eineFrage();

		assertNotNull(frage.getZellen());
		assertFalse(frage.getZellen().isEmpty());
	}

	@Test
	public void checkFrageAnRichtigerPositionFuerLoesung() {
		Frage frage = eineFrage();

		List<Zelle> loesungszellen = frage.getZellen();

		Zelle zelle = loesungszellen.get(0);

		assertTrue(zelle.isPosition(0, 1));
		Zelle letzteZelle = loesungszellen.get(loesungszellen.size() - 1);

		assertTrue(letzteZelle.isPosition(4, 1));
	}

	private Frage eineFrage() {
		Frage frage = new Frage("Dies ist Test");
		Zelle z1 = new Zelle(new Point(0, 1));
		Zelle z2 = new Zelle(new Point(1, 1));
		Zelle z3 = new Zelle(new Point(2, 1));
		Zelle z4 = new Zelle(new Point(3, 1));
		Zelle z5 = new Zelle(new Point(4, 1));
		frage.addZellen(z1, z2, z3, z4, z5);
		return frage;
	}
}
