package class_diagram;

import java.util.Date;

public class Feedback {
	private int _feedbackId;
	private int _rating;
	private String _comment;
	private Date _submittedOn;
	public User _user;
	public Transcription _transcription;

	public void submit() {
		throw new UnsupportedOperationException();
	}

	public void edit() {
		throw new UnsupportedOperationException();
	}
}