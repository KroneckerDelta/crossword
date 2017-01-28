package de.mic.crossword;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	 * Liefert alle Felder mit Gewinnbuchstaben zurück.
	 * 
	 * @return Liste aller Felder mit Gewinnbuchstaben
	 */
	public List<Zelle> getGewinnerfelder() {
		return alleZellen.stream().filter(p -> p.hatEigenschaft(Zelltyp.GEWINNFELD)).collect(Collectors.toList());
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

	/**
	 * Liefert das Lösungswort zurück.
	 * 
	 * @return Lösungswort kann Lücken haben.
	 */
	public String getLoesungsWort() {
		String result = "";
		for (int i = 1; i <= getGewinnerfelder().size(); i++) {
			Zelle gewinnerfeld = getGewinnerfeld(i);
			if (gewinnerfeld.hatBuchstaben()) {
				result += gewinnerfeld.getBuchstabe();
			} else {
				result += "_";
			}
		}

		return result;
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		List<Zelle> alle = getAlleZellen();
		Collections.sort(alle, new Comparator<Zelle>() {

			@Override
			public int compare(Zelle o1, Zelle o2) {
				if (o1.getPosition().y == o2.getPosition().y) {
					return Integer.valueOf(o1.getPosition().x).compareTo(Integer.valueOf(o2.getPosition().x));
				}

				return Integer.valueOf(o1.getPosition().y).compareTo(Integer.valueOf(o2.getPosition().y));
			}
		});
		int oldPosition = -1;
		for (Zelle zelle : alle) {

			// DerVesuch ASCII Grafik zu erzeugen...
			if (oldPosition < zelle.getPosition().x) {
				oldPosition = zelle.getPosition().x;
			} else {
				sb.append("\n");
				oldPosition = -1;
			}

			if (zelle.hatEigenschaft(Zelltyp.FRAGE)) {
				sb.append("#");
			} else if (zelle.hatEigenschaft(Zelltyp.BUCHSTABE)) {
				if (zelle.hatBuchstaben()) {
					sb.append(zelle.getBuchstabe());
				} else {
					sb.append("_");

				}
			}
		}

		return sb.toString();
	}

	/**
	 * Zeigt das ganze Rätsel
	 * 
	 * @return Darstellung des Rätsels
	 */
	public String show() {
		return toString();
	}
}
