package class_diagram;

public class MusicalNote {
	private int _noteId;
	private String _pitch;
	private double _duration;
	private double _startBeat;
	private double _confidence;
	public InstrumentPart _instrumentPart;

	public boolean isLowConfidence() {
		throw new UnsupportedOperationException();
	}

	public String displayColor() {
		throw new UnsupportedOperationException();
	}

	public void editNote(String aPitch, double aDuration) {
		throw new UnsupportedOperationException();
	}
}