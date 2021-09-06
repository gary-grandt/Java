package BKTM.Althaus.Beziehungen.NzuM;

import java.util.ArrayList;

public class Lehrer {
	
	private String fach;
	private ArrayList<Schueler> schueler = new ArrayList<Schueler>();
	
	//Constructors 
	public Lehrer(String fach) {
		this.fach = fach;
	}
	
	public Lehrer(String fach, Schueler schueler) {
		this.fach = fach;
		this.schueler.add(schueler);
	}
	
	//Methods
	public void unterricht() {}
	
	//List Methods
	public void addSchueler(Schueler schueler) {
		schueler.setLehrer(this);
		this.schueler.add(schueler);
	}
	
	public void removerSchueler(Schueler schueler) {
		this.schueler.remove(schueler);
	}
	
	//Geter
	public String getFach() {
		return fach;
	}
	
	public ArrayList<Schueler> getSchueler() {
		return schueler;
	}
	
	//Seter
	public void setFach(String fach) {
		this.fach = fach;
	}
	
	public void setSchueler(ArrayList<Schueler> schueler) {
		this.schueler = schueler;
	}
}

