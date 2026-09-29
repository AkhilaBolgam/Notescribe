package class_diagram;

import java.util.Vector;
import class_diagram.MusicalNote;

public class InstrumentPart {
	private int _partId;
	private String _instrumentName;
	private int _staffNumber;
	public Transcription _transcription;
	public Vector<MusicalNote> _musicalNotes = new Vector<MusicalNote>();

	public void showPartOnly() {
		throw new UnsupportedOperationException();
	}

	public void printPreview() {
		throw new UnsupportedOperationException();
	}
}