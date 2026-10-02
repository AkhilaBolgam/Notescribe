package class_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/** Plain unit tests (no test doubles) for MusicalNote. */
class MusicalNoteTest {

	@Test
	void lowConfidenceNoteIsShownInRed() {
		MusicalNote note = new MusicalNote("C4", 1.0, 0.0, 0.4);

		assertTrue(note.isLowConfidence());
		assertEquals("red", note.displayColor());
	}

	@Test
	void highConfidenceNoteIsShownInBlack() {
		MusicalNote note = new MusicalNote("G4", 0.5, 2.0, 0.95);

		assertFalse(note.isLowConfidence());
		assertEquals("black", note.displayColor());
	}

	@Test
	void editingANoteUpdatesItAndMarksItConfident() {
		MusicalNote note = new MusicalNote("C4", 1.0, 0.0, 0.3);

		note.editNote("D4", 2.0);

		assertEquals("D4", note.getPitch());
		assertEquals(2.0, note.getDuration());
		assertFalse(note.isLowConfidence());
	}

	@Test
	void editingWithInvalidDurationIsRejected() {
		MusicalNote note = new MusicalNote("C4", 1.0, 0.0, 0.9);

		assertThrows(IllegalArgumentException.class, () -> note.editNote("D4", 0));
	}
}
