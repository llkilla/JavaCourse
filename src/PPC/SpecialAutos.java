package PPC;

public enum SpecialAutos {
	AMBULANCE(1), FIRE(2), POLICE(3);
	
	int index;
	
	SpecialAutos(int index){
		this.index = index;
	}

	public String asStr(){
		switch(index) {
			case 1 : return "Ambulance";
			case 2 : return "Fire";
			case 3 : return "Police";
			default: return "Nothing";
		}
	}
}
