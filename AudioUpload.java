package class_diagram;

public class AudioUpload {
	private int _uploadId;
	private String _fileName;
	private String _format;
	private int _lengthSeconds;
	private String _fileHash;
	private Date _uploadedOn;
	public History _history;
	public Transcription _transcription;

	public boolean validateFormat() {
		throw new UnsupportedOperationException();
	}

	public boolean checkLength() {
		throw new UnsupportedOperationException();
	}

	public boolean checkRateLimit() {
		throw new UnsupportedOperationException();
	}

	public void reduceNoise() {
		throw new UnsupportedOperationException();
	}

	public void play() {
		throw new UnsupportedOperationException();
	}
}