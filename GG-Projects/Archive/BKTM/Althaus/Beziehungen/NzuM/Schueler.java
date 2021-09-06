package BKTM.Althaus.Beziehungen.NzuM;

public class Schueler {
	
	//Variables
	private String name;
	private Lehrer lehrer;
	
	//Constructors 
	public Schueler () {}
	
	public Schueler (String name) {
		this.name = name;
	}
	
	public Schueler(String name, Lehrer lehrer) {
		this.name = name;
		this.lehrer = lehrer;
		lehrer.addSchueler(this);
	}
	
	//Methods
	public void lesen() {}
	
	//Geter
	public String getName() {
		return name;
	}
	
	public Lehrer getLehrer() {
		return lehrer;
	}
	
	//Seter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLehrer(Lehrer lehrer) {
		this.lehrer = lehrer;
	}
}
