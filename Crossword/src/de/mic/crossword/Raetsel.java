package de.mic.crossword;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse beinhaltet alle Zellen des Rätsels
 * 
 * @author thomasmichael
 *
 */
public class Raetsel {

	private List<Zelle> alleZellen = new ArrayList<>();

	/**
	 * Fügt dem Rätsel alle Zellen hinzu.
	 * 
	 * @param zelle
	 */

	public void addAll(List<Zelle> zellen) {
		alleZellen.addAll(zellen);
	}

	/**
	 * Liefert die Zelle von einer bestimmten Position zurück
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Zelle getZelle(int x, int y) {
		for (Zelle zelle : alleZellen) {
			if (zelle.isPosition(x, y)) {
				return zelle;
			}

		}
		return null;
	}

}
