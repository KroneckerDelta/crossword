package de.mic.crossword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Frage {

	private String frage;
	private List<Zelle> loesungsZellen = new ArrayList<>();
	private List<String> antworten;

	public Frage(String frage) {
		this.frage = frage;
	}

	/**
	 * Fügt die Zellen hinzu, die für die LÃ¶sung sind
	 * 
	 * @param z1
	 * @param z2
	 * @param z3
	 * @param z4
	 * @param z5
	 */
	public void addZellen(Zelle... zellen) {
		addZellen(Arrays.asList(zellen));

	}

	public void addZellen(List<Zelle> zellen) {

		zellen.stream().forEach(z -> fuegeZurLoesungHinzu(z));
	}

	private void fuegeZurLoesungHinzu(Zelle z) {
		loesungsZellen.add(z);
		z.addFrage(this);
	}

	/**
	 * Liefert die Lösungszellen zurück.
	 * 
	 * @return zellen für die Buchstaben.
	 */
	public List<Zelle> getZellen() {
		return loesungsZellen;
	}

	/**
	 * Liefert die Frage als zurück.
	 * 
	 * @return Frage
	 */
	public String getFrage() {
		return frage;
	}

	/**
	 * Liefert die Länger der Anworten zurüc.k
	 * 
	 * @return Antwortlänge
	 */
	public int getAntwortLaenge() {
		return loesungsZellen.size();
	}

	/**
	 * Setzt die Antworten an die Frage
	 * 
	 * @param antworten
	 */
	public void setAntworten(List<String> antworten) {
		this.antworten = antworten;
	}

}
