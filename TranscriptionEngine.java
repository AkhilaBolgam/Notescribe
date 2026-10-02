package class_diagram;

/**
 * The AI service that turns audio into notes. Returns the score as JSON,
 * or an empty string when no music is detected. In tests it is replaced by a mock.
 */
public interface TranscriptionEngine {
	String transcribe(AudioUpload aUpload);
}
