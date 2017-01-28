package de.mic.crossword;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TemplateMatchingTest {

	List<String> antworten = Arrays.asList("GABUNER", "GHANAER", "GHANESE", "GUINEER");

	@Test
	public void shouldMatchCosFirstCharsIsEqual() {
		String template = "G......";
		String antwort = "GABUNER";

		assertTrue(antwort.matches(template));

	}

	@Test
	public void shouldMatchCosSecondCharsIsEqual() {
		String template = ".A.....";
		String antwort = "GABUNER";

		assertTrue(antwort.matches(template));

	}

	@Test
	public void simple() throws Exception {
		String abc = "abcabc";
		String pattern = "a.....";
		assertTrue(abc.matches(pattern));

	}
}
