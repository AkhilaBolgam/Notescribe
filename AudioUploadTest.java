package class_diagram;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * AudioUpload tests using a STUB.
 * A stub is a fake object that just returns a fixed, pre-programmed answer,
 * so we can test AudioUpload without a real database of past uploads.
 */
class AudioUploadTest {

	/** Stub: always reports the same number of recent uploads. */
	static class StubRateLimiter implements RateLimiter {
		private final int uploadsInLastHour;

		StubRateLimiter(int uploadsInLastHour) {
			this.uploadsInLastHour = uploadsInLastHour;
		}

		@Override
		public int countUploadsInLastHour() {
			return uploadsInLastHour;
		}
	}

	@Test
	void userUnderTheLimitCanUpload() {
		AudioUpload upload = new AudioUpload("song.mp3", "mp3", 120);
		upload.setRateLimiter(new StubRateLimiter(2));

		assertTrue(upload.checkRateLimit());
	}

	@Test
	void userAtTheLimitIsBlocked() {
		AudioUpload upload = new AudioUpload("song.mp3", "mp3", 120);
		upload.setRateLimiter(new StubRateLimiter(AudioUpload.MAX_UPLOADS_PER_HOUR));

		assertFalse(upload.checkRateLimit());
	}

	@Test
	void supportedFormatsAreAccepted() {
		assertTrue(new AudioUpload("a.wav", "WAV", 60).validateFormat());
		assertFalse(new AudioUpload("a.txt", "txt", 60).validateFormat());
	}

	@Test
	void recordingsLongerThanTenMinutesAreRejected() {
		assertTrue(new AudioUpload("a.mp3", "mp3", 600).checkLength());
		assertFalse(new AudioUpload("a.mp3", "mp3", 601).checkLength());
	}
}
