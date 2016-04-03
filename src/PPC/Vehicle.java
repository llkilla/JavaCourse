package PPC;

public abstract class Vehicle implements Payment{
	private String name;
	private double speed;
	private double carrying;
	private double height;
	private specCat spec = specCat.ORDINARY;
	
	public enum specCat {AMBULANCE, FIRE, POLICE, ORDINARY};
	
	public boolean isOfSpecCat(){
		if ((this.spec == null)||(this.spec == specCat.ORDINARY)){
			return false;
		} else {
			try{
				specCat sp = specCat.valueOf(this.spec.name());
				return true;
			}
			catch(IllegalArgumentException e){
				return false;
			}
			
		}
	}

	public specCat getSpec() {
		return spec;
	}
	public void setSpec(specCat spec) {
		this.spec = spec;
	}

	private Vehicle(){};
	
	public Vehicle(String name, double speed, double height, double carrying){
		this.name = name.equals(null) ? this.toString() : name;
		this.speed = speed;
		this.height = height;
		this.carrying = carrying;
	}
	
	public Vehicle(String name, specCat spec, double speed, double height, double carrying){
		this.name = name.equals(null) ? this.toString() : name;
		this.spec = spec; 
		this.speed = speed;
		this.height = height;
		this.carrying = carrying;
	}
	
	public double getCarrying() {
		return carrying;
	}
	public void setCarrying(double carrying) {
		this.carrying = carrying;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	@Override
	public String toString(){
		return this.getName() + "; " + this.getClass()+"; speed: "+this.speed+"; carrying: "+this.carrying+"; height: "+this.height+"; ";
	}
	public void calculateBill() throws CheckYourAutoException{
		double cost = 0;
		double fine = 0;
		
		double pCost = 1000.0;
		double tCost = 2000.0;
		
		double trailerFine = 500.0;
		double carryingFine = 800.0;
		double speedFine = 1500.0;
		
		double maxCarrying = 10.0;
		double maxSpeed = 180.0;
		double maxHeight = 4.0;
		double fineSpeed = 80.0;
		
		if (this.isOfSpecCat()){
			System.out.println(this.toString() + "Автомобиль специального назначения: проезд свободный!");
			return;
		} 
		
		if (this.getSpeed() > maxSpeed){
			//System.out.print(this.toString());
			throw new CheckYourAutoException(new IllegalArgumentException(this.toString() +"Превышена максимальная скорость! Вызов патруля ГИБДД!"));
		}
		if (this.getSpeed() > fineSpeed){
			fine = fine + speedFine;
		}
		
		if (this instanceof PassengerCar){
			cost = cost + pCost;
		}
		else if (this instanceof Truck){
			if (this.getHeight() > maxHeight){
				System.out.print(this.toString());
				throw new CheckYourAutoException(new IllegalArgumentException(this.toString() +"Превышена максимальная высота автомобиля! Проезд запрещен."));
			}
			if (this.getCarrying() > maxCarrying){
				fine = fine + carryingFine;
			}
			cost = cost + tCost;
			if (((Truck)this).isWithTrailer()){
				fine = fine + trailerFine;
			}
		}
		System.out.println(this.toString() + "cost: "+cost+"; fine: "+fine+"; full: "+(cost+fine));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
}
