package BKTM.Althaus.CoronaSchule;

public class Person {
	// Variables
	protected String name;
	private boolean hatCorona = false;
	
	
	//Constructors
	public Person() {}
	public Person(String name) {
		this.name = name;
	}
	
	
	// Getter 
	public String getName() {
		return name;
	}
	public boolean getHatCorona() {
		return hatCorona;
	}
	
	// Setter
	public void setName(String name) {
		this.name = name;
	}
	public void setHatCorona(boolean hatCorona) {
		this.hatCorona = hatCorona;
	}
}
