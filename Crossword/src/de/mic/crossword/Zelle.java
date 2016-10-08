package de.mic.crossword;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse entspricht einer Zelle in einem schwedenrätsel. Die Zelle kann
 * 1-4 Fragen enthalten, einen Buchstaben, einen Gewinnerbuchstaben oder einfach
 * nur leer sein und damit blockieren. (Ende eines Wort)
 * 
 * @author thomasmichael
 *
 */
public class Zelle {

	private Point position;
	private int stelle;
	private List<Zelltyp> eigenschaften = new ArrayList<>();
	private List<Frage> fragen = new ArrayList<>();

	public Zelle(Point position) {
		this.position = position;
	}

	public boolean isPosition(int x, int y) {
		return position.x == x && position.y == y;
	}

	public void addEigenschaft(Zelltyp typ) {
		eigenschaften.add(typ);

	}

	/**
	 * Fügt dieser Zelle die Eigenschaft GEWINNFELD hinzu mit der Position.
	 * 
	 * @param stelle
	 */
	public void addGewinnfeld(int stelle) {
		this.stelle = stelle;
		addEigenschaft(Zelltyp.GEWINNFELD);
	}

	/**
	 * Prüft, ob die Zelle die geforderte Eigenschaft hat.
	 * 
	 * @return true, wenn die Eigenschaft vorhanden ist.
	 */
	public boolean hatEigenschaft(Zelltyp typ) {
		return eigenschaften.contains(typ);
	}

	/**
	 * Liefert die Stelle zurück. Geht nur bei Gewinnderfeldern
	 * 
	 * @return 0 oder die Stelle
	 */
	public int getStelle() {
		return stelle;
	}

	/**
	 * Fügt eine Frage hinzu.
	 * 
	 * @param frage
	 */
	public void addFrage(Frage frage) {
		fragen.add(frage);
	}
}
