package de.mic.crossword;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CrosswordTest {

	@Test
	public void erstelleRaetsel() throws Exception {

		List<Zelle> alle = new ArrayList<>();
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				alle.add(new Zelle(new Point(i, j)));
			}
		}

	}
}
