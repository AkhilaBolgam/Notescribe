package class_diagram;

import java.util.Date;

public class AudioUpload {
	public static final int MAX_LENGTH_SECONDS = 600;
	public static final int MAX_UPLOADS_PER_HOUR = 5;
	private static final String[] SUPPORTED_FORMATS = {"mp3", "wav", "m4a", "flac"};

	private int _uploadId;
	private String _fileName;
	private String _format;
	private int _lengthSeconds;
	private String _fileHash;
	private Date _uploadedOn;
	private RateLimiter _rateLimiter;
	public History _history;
	public Transcription _transcription;

	public AudioUpload(String aFileName, String aFormat, int aLengthSeconds) {
		this._fileName = aFileName;
		this._format = aFormat;
		this._lengthSeconds = aLengthSeconds;
		this._uploadedOn = new Date();
	}

	public void setRateLimiter(RateLimiter aRateLimiter) {
		this._rateLimiter = aRateLimiter;
	}

	public String getFileName() {
		return this._fileName;
	}

	public boolean validateFormat() {
		if (_format == null) {
			return false;
		}
		for (String supported : SUPPORTED_FORMATS) {
			if (supported.equalsIgnoreCase(_format)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkLength() {
		return _lengthSeconds > 0 && _lengthSeconds <= MAX_LENGTH_SECONDS;
	}

	public boolean checkRateLimit() {
		if (_rateLimiter == null) {
			return true;
		}
		return _rateLimiter.countUploadsInLastHour() < MAX_UPLOADS_PER_HOUR;
	}

	public void reduceNoise() {
		throw new UnsupportedOperationException();
	}

	public void play() {
		throw new UnsupportedOperationException();
	}
}
