package de.mic.crossword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Frage {

	private String frage;
	private List<Zelle> loesungsZellen = new ArrayList<>();

	public Frage(String frage) {
		this.frage = frage;
	}

	/**
	 * FÃ¼gt die Zellen hinzu, die fÃ¼r die LÃ¶sung sind
	 * 
	 * @param z1
	 * @param z2
	 * @param z3
	 * @param z4
	 * @param z5
	 */
	public void addZellen(Zelle... zellen) {
		List<Zelle> listeDerZellen = Arrays.asList(zellen);
		listeDerZellen.stream().forEach(z -> loesungsZellen.add(z));
	}

	public void addZellen(List<Zelle> zellen) {
		addZellen((Zelle[]) zellen.toArray());
	}

	/**
	 * Liefert die Lösungszellen zurück.
	 * 
	 * @return zellen für die Buchstaben.
	 */
	public List<Zelle> getZellen() {
		return loesungsZellen;
	}

}
