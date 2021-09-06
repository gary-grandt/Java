package BKTM.Althaus.CoronaSchule;

import java.util.ArrayList;

public class Klasse {
	// Variables
	private String name;
	private Schule.Raum klassenRaum;
	private ArrayList<Schueler> schuelerList;
	private ArrayList<Lehrer> lehrerList;
	
	// Constructors 
	public Klasse() {
		this.klassenRaum = null;
		this.schuelerList = new ArrayList<Schueler>();
		this.lehrerList = new ArrayList<Lehrer>();
	}
	public Klasse(String name) {
		this.name = name;
		this.klassenRaum = null;
		this.schuelerList = new ArrayList<Schueler>();
		this.lehrerList = new ArrayList<Lehrer>();
	}
	public Klasse(String name, Schule.Raum klassenRaum) {
		this.name = name;
		this.klassenRaum = klassenRaum;
		this.klassenRaum.setKlasse(this);
		this.schuelerList = new ArrayList<Schueler>();
		this.lehrerList = new ArrayList<Lehrer>();
	}
	public Klasse(String name, Schule.Raum klassenRaum, ArrayList<Lehrer> lehrerList) {
		this.name = name;
		this.klassenRaum = klassenRaum;
		this.klassenRaum.setKlasse(this);
		this.schuelerList = new ArrayList<Schueler>();
		this.lehrerList = lehrerList;
		for(Lehrer current : this.lehrerList) {
			current.addKlasse(this);
		}
	}
	
	// Methods
	public void addSchueler(Schueler schueler) {
		schuelerList.add(schueler);
	}
	public void removeSchuler(Schueler schueler) {
		schuelerList.remove(schueler);
	}
	
	public void addLehrer(Lehrer lehrer) {
		lehrerList.add(lehrer);
	}
	public void removeLehrer(Lehrer lehrer) {
		lehrerList.remove(lehrer);
	}
	
	// Getter
	public String getName() {
		return name;
	}
	
	public Schule.Raum getKlassenRaum() {
		return klassenRaum;
	}
	
	public ArrayList<Schueler> getSchuelerList(){
		return schuelerList;
	}
	public ArrayList<Lehrer> getLehrerList() {
		return lehrerList;
	}

	
	// Setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setKlassenRaum(Schule.Raum klassenRaum) {
		this.klassenRaum = klassenRaum;
	}
}
