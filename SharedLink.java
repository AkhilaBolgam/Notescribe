package class_diagram;

public class SharedLink {
	private int _shareId;
	private String _recipientEmail;
	private String _accessLevel;
	private Date _sharedOn;
	public User _user;
	public Transcription _transcription;

	public void share(String aEmail) {
		throw new UnsupportedOperationException();
	}

	public void revoke() {
		throw new UnsupportedOperationException();
	}
}