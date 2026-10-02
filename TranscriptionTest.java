package class_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

/**
 * Transcription tests using a MOCK (Mockito).
 * A mock records how it was called, so we can verify Transcription
 * talks to the AI engine correctly, not just check the result.
 */
class TranscriptionTest {

	@Test
	void validUploadIsSentToEngineOnceAndCompletes() {
		TranscriptionEngine engine = mock(TranscriptionEngine.class);
		AudioUpload upload = new AudioUpload("twinkle.mp3", "mp3", 30);
		when(engine.transcribe(upload)).thenReturn("{\"notes\":[\"C4\",\"C4\",\"G4\"]}");

		Transcription transcription = new Transcription(upload, engine);
		transcription.start();

		verify(engine, times(1)).transcribe(upload);
		assertEquals("COMPLETED", transcription.getStatus());
		assertTrue(transcription.isMusicDetected());
	}

	@Test
	void invalidFormatIsNeverSentToEngine() {
		TranscriptionEngine engine = mock(TranscriptionEngine.class);
		AudioUpload upload = new AudioUpload("notes.txt", "txt", 30);

		Transcription transcription = new Transcription(upload, engine);
		transcription.start();

		verify(engine, never()).transcribe(any());
		assertEquals("FAILED", transcription.getStatus());
	}

	@Test
	void silentRecordingReportsNoMusic() {
		TranscriptionEngine engine = mock(TranscriptionEngine.class);
		AudioUpload upload = new AudioUpload("silence.wav", "wav", 10);
		when(engine.transcribe(upload)).thenReturn("");

		Transcription transcription = new Transcription(upload, engine);
		transcription.start();

		assertEquals("NO_MUSIC", transcription.getStatus());
		assertFalse(transcription.isMusicDetected());
	}
}
