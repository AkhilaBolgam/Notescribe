package class_diagram;

public class ExportFile {
	private int _exportId;
	private String _format;
	private String _scope;
	public Transcription _transcription;

	public void generatePDF(String aScope) {
		throw new UnsupportedOperationException();
	}

	public void generateMIDI() {
		throw new UnsupportedOperationException();
	}

	public void generateMusicXML() {
		throw new UnsupportedOperationException();
	}

	public void download() {
		throw new UnsupportedOperationException();
	}
}