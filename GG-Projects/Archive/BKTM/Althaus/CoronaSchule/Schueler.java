package BKTM.Althaus.CoronaSchule;

public class Schueler extends Person{
	// Variables
	private int[][] noten;
	
	// Constructor
	public Schueler() {
		noten = null;
	}
	public Schueler(String name) {
		super.name = name;
		noten = null;
	}
	
	// Getter
	public int[][] getNoten() {
		return noten;
	}
	
	// Setter 
	public void setNoten(int[][] noten) {
		this.noten = noten;
	}
	
	//Methods
	public void arbeiten() {}
	
	public void schlafen() {}
	
}
