package net.a.g.brms.dat.model;

public class Result {

	private boolean adult;

	private String message;

	private boolean ok;

	public Result() {
	}

	public String getMessage() {
		return message;
	}

	public boolean isAdult() {
		return adult;
	}

	public boolean isOk() {
		return ok;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public void setError(boolean error) {
		this.ok = error;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
