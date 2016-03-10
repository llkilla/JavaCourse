
public class Men {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean Feed(Pet aPet){
		boolean ret;
		if (aPet.isHungry()) {
			ret = true;
			System.out.println(aPet.getName() + " is feeded by "+this.name);
		} else {
			ret = false;
			System.out.println(aPet.getName() + " is not feeded by "+this.name);
		}
		return ret;
	}
}
