package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testCanAdd() {
		String actual = queryProcessor.process("1 plus 3");
		if (!actual.contains("4")) {
			fail("The QueryProcessor has not been to preschool yet");
		}
	}

	@Test
	void testCanMul() {
		String actual = queryProcessor.process("1 times 3");
		if (!actual.contains("3")) {
			fail("The QueryProcessor has not been to preschool yet");
		}
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void testKnowsAboutTUM() {
		String actual = queryProcessor.process("TUM");
		if (!actual.contains("Uni")) {
			fail("The QueryProcessor does not know about TUM.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

}
