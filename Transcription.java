package class_diagram;

import java.util.Vector;
import class_diagram.InstrumentPart;
import class_diagram.PracticeLoop;
import class_diagram.ExportFile;
import class_diagram.Feedback;
import class_diagram.SharedLink;

public class Transcription {
	private int _transcriptionId;
	private String _status;
	private boolean _musicDetected;
	private int _tempoBPM;
	private String _key;
	private Date _completedOn;
	public AudioUpload _audioUpload;
	public Vector<InstrumentPart> _instrumentParts = new Vector<InstrumentPart>();
	public Vector<PracticeLoop> _practiceLoops = new Vector<PracticeLoop>();
	public Vector<ExportFile> _exportFiles = new Vector<ExportFile>();
	public Vector<Feedback> _feedback = new Vector<Feedback>();
	public Vector<SharedLink> _sharedLinks = new Vector<SharedLink>();

	public void start() {
		throw new UnsupportedOperationException();
	}

	public String getStatus() {
		return this._status;
	}

	public void buildScore(String aJson) {
		throw new UnsupportedOperationException();
	}

	public void detectTempoAndKey() {
		throw new UnsupportedOperationException();
	}

	public void showPianoRoll() {
		throw new UnsupportedOperationException();
	}
}