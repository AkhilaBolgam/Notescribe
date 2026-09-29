package class_diagram;

import java.util.Vector;
import class_diagram.AudioUpload;

public class History {
	private int _historyId;
	private int _itemCount;
	public User _user;
	public Vector<AudioUpload> _audioUploads = new Vector<AudioUpload>();

	public List<AudioUpload> listUploads() {
		throw new UnsupportedOperationException();
	}

	public Transcription openItem(int aId) {
		throw new UnsupportedOperationException();
	}

	public void deleteItem(int aId) {
		throw new UnsupportedOperationException();
	}

	public void clearAll() {
		throw new UnsupportedOperationException();
	}
}