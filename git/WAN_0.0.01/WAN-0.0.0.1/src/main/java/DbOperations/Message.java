package DbOperations;

import java.util.ArrayList;

public class Message {
	private ArrayList<String> message = new ArrayList<String>();
	private ArrayList<String> From = new ArrayList<String>();
	public ArrayList<String> getMessage() {
		return message;
	}

	public void setMessage(ArrayList<String> message) {
		this.message = message;
	}

	public ArrayList<String> getFrom() {
		return From;
	}

	public void setFrom(ArrayList<String> from) {
		this.From = from;
	}
}
