package de.mic.crossword;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 
 * @author michael
 *
 */
public class LoesungsServiceTest {

	@Test
	public void testeTemplateErsteStelle() throws Exception {

		String suchTemplate = ".aus";

		List<String> datenbank = Arrays.asList("Maus", "Laus", "Haus", "Raum", "suam", "Baum");
		List<String> result = datenbank.stream().filter(p -> p.matches(suchTemplate)).collect(Collectors.toList());

		assertEquals(3, result.size());
		assertTrue(result.contains("Maus"));
		assertTrue(result.contains("Laus"));
		assertTrue(result.contains("Haus"));
	}

	@Test
	public void testeTemplateZweiteStelle() throws Exception {

		String suchTemplate = "M.us";

		List<String> datenbank = Arrays.asList("Maus", "Laus", "Haus", "Raum", "Mause", "Baum");
		List<String> result = datenbank.stream().filter(p -> p.matches(suchTemplate)).collect(Collectors.toList());

		assertEquals(1, result.size());
		assertTrue(result.contains("Maus"));
	}

	@Test
	public void testeTemplateErsteUndDritteStelle() throws Exception {

		String suchTemplate = ".a.s";

		List<String> datenbank = Arrays.asList("Maus", "Laus", "Haus", "Raum", "Mause", "Baum");
		List<String> result = datenbank.stream().filter(p -> p.matches(suchTemplate)).collect(Collectors.toList());

		assertEquals(3, result.size());
		assertTrue(result.contains("Maus"));
		assertTrue(result.contains("Laus"));
		assertTrue(result.contains("Haus"));
	}

	@Test
	public void testeTemplateAlleStellen() throws Exception {

		String suchTemplate = "....";

		List<String> datenbank = Arrays.asList("Maus", "Laus", "Haus", "Raum", "Mause", "Baum");
		List<String> result = datenbank.stream().filter(p -> p.matches(suchTemplate)).collect(Collectors.toList());

		assertEquals(5, result.size());
		assertTrue(result.contains("Maus"));
		assertTrue(result.contains("Laus"));
		assertTrue(result.contains("Haus"));
		assertTrue(result.contains("Raum"));
		assertTrue(result.contains("Baum"));
	}
}
