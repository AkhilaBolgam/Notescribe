package class_diagram;

public class MusicalNote {
	public static final double LOW_CONFIDENCE_THRESHOLD = 0.6;

	private int _noteId;
	private String _pitch;
	private double _duration;
	private double _startBeat;
	private double _confidence;
	public InstrumentPart _instrumentPart;

	public MusicalNote(String aPitch, double aDuration, double aStartBeat, double aConfidence) {
		this._pitch = aPitch;
		this._duration = aDuration;
		this._startBeat = aStartBeat;
		this._confidence = aConfidence;
	}

	public String getPitch() {
		return this._pitch;
	}

	public double getDuration() {
		return this._duration;
	}

	public boolean isLowConfidence() {
		return _confidence < LOW_CONFIDENCE_THRESHOLD;
	}

	public String displayColor() {
		return isLowConfidence() ? "red" : "black";
	}

	public void editNote(String aPitch, double aDuration) {
		if (aDuration <= 0) {
			throw new IllegalArgumentException("Duration must be positive");
		}
		this._pitch = aPitch;
		this._duration = aDuration;
		this._confidence = 1.0; // the user corrected it, so we are now sure
	}
}
