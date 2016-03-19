package PPC;

public class CheckYourAuto extends Exception{
	private Throwable th;

	public CheckYourAuto(Throwable th) {
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
