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

	public Zelle(Point position) {
		this.position = position;
	}

	private List<Zelltyp> eigenschaften = new ArrayList<>();

	public boolean isPosition(int x, int y) {
		return position.x == x && position.y == y;
	}

	public void addEigenschaft(Zelltyp typ) {
		eigenschaften.add(typ);

	}

}
