package PPC;

public class Truck extends Vehicle{
	private boolean withTrailer;
	
	public Truck(String name, double speed, double height, double carrying, boolean withTrailer){
		super(name, speed, height, carrying);
		this.withTrailer = withTrailer;
	};
	public boolean isWithTrailer() {
		return withTrailer;
	}
	public void setWithTrailer(boolean withTrailer) {
		this.withTrailer = withTrailer;
	}
}
