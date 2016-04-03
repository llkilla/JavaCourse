package PPC;

public class CheckYourAutoException extends Exception{
	private Throwable th;

	public CheckYourAutoException(Throwable th) {
		this.th = th;
	}
	
	public Throwable getException(){
		return th;
	}
	@Override
	public String toString(){
		return th.getMessage();
	}
}
