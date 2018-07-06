package net.a.g.brms.dat.model.fact;

public class ExecutionResult {

	public static ExecutionResult builder() {
		return new ExecutionResult();
	}

	private boolean adult;

	private String message;

	private boolean ok;

	public ExecutionResult() {
	}

	public ExecutionResult addAdult(boolean adult) {
		this.adult = adult;
		return this;
	}

	public ExecutionResult addMessage(String message) {
		this.message = message;
		return this;
	}

	public ExecutionResult addOk(boolean ok) {
		this.ok = ok;
		return this;
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
