package class_diagram;

import java.util.Vector;

public class User {
	private int _userId;
	private String _fullName;
	private String _email;
	private String _passwordHash;
	private String _mainInstrument;
	private boolean _aiTrainingOptIn;
	public History _history;
	public Vector<Feedback> _feedback = new Vector<Feedback>();
	public Vector<SharedLink> _sharedLinks = new Vector<SharedLink>();

	public boolean register() {
		throw new UnsupportedOperationException();
	}

	public boolean login(String aEmail, String aPassword) {
		throw new UnsupportedOperationException();
	}

	public void logout() {
		throw new UnsupportedOperationException();
	}

	public void updateProfile() {
		throw new UnsupportedOperationException();
	}
}
