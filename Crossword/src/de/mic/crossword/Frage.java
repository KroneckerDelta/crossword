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

	public void addZellen() {
		// TODO Auto-generated method stub

	}

	/**
	 * Fügt die Zellen hinzu, die für die Lösung sind
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

}
