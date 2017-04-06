package hello;

public class ErrorMessage{

	private final long incrementAndGet;
	private String errors;

	public ErrorMessage(long incrementAndGet, String errors) {
		this.incrementAndGet = incrementAndGet;
		this.errors=errors;


	}

	public long getIncrementAndGet() {
		return incrementAndGet;
	}

	public String getErrors() {
		return errors;
	}
	
	

}
