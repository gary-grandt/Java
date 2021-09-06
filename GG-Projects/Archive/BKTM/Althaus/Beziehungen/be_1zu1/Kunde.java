package BKTM.Althaus.Beziehungen.be_1zu1;

public class Kunde {
	//Variables
	private Konto konto = null;
	private String name;
	private String alter;
	private String wohnOrt;
	
	//Constructors
	public Kunde() {
		konto = new Konto(this);
	}
	
	public Kunde(Konto konto) {
		this.konto = konto;
	}
	
	//Geter
	public Konto getKonto() {
		return konto;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAlter() {
		return alter;
	}
	
	public String getWohnOrt() {
		return wohnOrt;
	}
	
	//Seter
	public void setKonto(Konto konto) {
		this.konto = konto;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAlter(String alter) {
		this.alter = alter;
	}
	
	public void setWohnOrt(String wohnOrt) {
		this.wohnOrt = wohnOrt;
	}
	
	//Methods
	
}
