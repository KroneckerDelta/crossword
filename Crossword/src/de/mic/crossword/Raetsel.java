package de.mic.crossword;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Diese Klasse beinhaltet alle Zellen des Rätsels
 * 
 * @author thomasmichael
 *
 */
public class Raetsel {
	/**
	 * Für die Ausrichtung der Zellen.
	 *
	 */
	public enum Richtung {
		SENKRECHT, WAAGERECHT;
	}

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

	/**
	 * Liefert die Zelle
	 * 
	 * @param punkt
	 *            - Koordinate
	 * @return Zelle
	 */
	public Zelle getZelle(Point punkt) {
		return getZelle(punkt.x, punkt.y);
	}

	/**
	 * Liefert alle Zellen im Original zurück.
	 * 
	 * @return zellen
	 */
	public List<Zelle> getAlleZellen() {
		return alleZellen;
	}

	/**
	 * Liefert das Gewinnerfeld für die Stelle zurück
	 * 
	 * @param i
	 */
	public Zelle getGewinnerfeld(int stelle) {
		for (Zelle zelle : alleZellen) {
			if (zelle.hatEigenschaft(Zelltyp.GEWINNFELD)) {
				if (zelle.getStelle() == stelle) {
					return zelle;
				}
			}
		}
		return null;
	}

	/**
	 * Liefert an Anzahl der Zellen vom Startpunkt zur gwünshten Richtung
	 * zurück.
	 * 
	 * @param i
	 * @param senkrecht
	 * @param j
	 * @param k
	 * @return
	 */
	public List<Zelle> getZellen(int anzahl, Richtung richtung, int x, int y) {
		List<Zelle> result = new ArrayList<>();

		for (int i = 0; i < anzahl; i++) {
			result.add(getZelle(x, y));
			switch (richtung) {
			case SENKRECHT:
				y++;
				break;
			case WAAGERECHT:
				x++;
				break;
			default:
				break;
			}
		}
		return result;
	}

	/**
	 * Liefert die Anzahl der Zellen zurück.
	 * 
	 * @param anzahl
	 * @param richtung
	 * @param punkt
	 * @return zellen
	 */
	public List<Zelle> getZellen(int anzahl, Richtung richtung, Point punkt) {
		return getZellen(anzahl, richtung, punkt.x, punkt.y);
	}

	/**
	 * Liefert alle Fragen zurück
	 * 
	 * @return fragen
	 */
	public List<Zelle> getFrageZellen() {
		return getZellen(Zelltyp.FRAGE);
	}

	private List<Zelle> getZellen(Zelltyp typ) {
		return alleZellen.stream().filter(z -> z.hatEigenschaft(typ)).collect(Collectors.toList());
	}

}
