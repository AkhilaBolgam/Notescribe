package class_diagram;

import java.util.Date;
import java.util.Vector;

public class Transcription {
	private int _transcriptionId;
	private String _status;
	private boolean _musicDetected;
	private int _tempoBPM;
	private String _key;
	private Date _completedOn;
	private String _scoreJson;
	private TranscriptionEngine _engine;
	public AudioUpload _audioUpload;
	public Vector<InstrumentPart> _instrumentParts = new Vector<InstrumentPart>();
	public Vector<PracticeLoop> _practiceLoops = new Vector<PracticeLoop>();
	public Vector<ExportFile> _exportFiles = new Vector<ExportFile>();
	public Vector<Feedback> _feedback = new Vector<Feedback>();
	public Vector<SharedLink> _sharedLinks = new Vector<SharedLink>();

	public Transcription(AudioUpload aAudioUpload, TranscriptionEngine aEngine) {
		this._audioUpload = aAudioUpload;
		this._engine = aEngine;
		this._status = "PENDING";
	}

	public void start() {
		if (_audioUpload == null || !_audioUpload.validateFormat() || !_audioUpload.checkLength()) {
			_status = "FAILED";
			return;
		}
		_status = "PROCESSING";
		String json = _engine.transcribe(_audioUpload);
		if (json == null || json.isEmpty()) {
			_musicDetected = false;
			_status = "NO_MUSIC";
			return;
		}
		_musicDetected = true;
		buildScore(json);
		_completedOn = new Date();
		_status = "COMPLETED";
	}

	public String getStatus() {
		return this._status;
	}

	public boolean isMusicDetected() {
		return this._musicDetected;
	}

	public void buildScore(String aJson) {
		this._scoreJson = aJson;
	}

	public void detectTempoAndKey() {
		throw new UnsupportedOperationException();
	}

	public void showPianoRoll() {
		throw new UnsupportedOperationException();
	}
}
