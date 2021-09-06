package BKTM.Althaus.CoronaSchule;

import java.util.ArrayList;
import java.util.Random;

public class Lehrer extends Person {
	//Variables
	private String fach;
	
	private ArrayList<Klasse> klassenList;
	
	private Random random = new Random();
	
	// Constructor
	public Lehrer() {
		this.klassenList = new ArrayList<Klasse>();
	}
	public Lehrer(String name, String fach) {
		super.name = name;
		this.fach = fach;
		this.klassenList = new ArrayList<Klasse>();
	}
	public Lehrer(String name, String fach, ArrayList<Klasse> klassenList) {
		super.name = name;
		this.fach = fach;
		this.klassenList = klassenList;
		for(Klasse tmp : this.klassenList) {
			tmp.addLehrer(this);
		}
	}
	
	// Getter
	public String getFach() {
		return fach;
	}
	
	public ArrayList<Klasse> getKlassenList() {
		return klassenList;
	}
	
	// Setter
	public void setFach(String fach) {
		this.fach = fach;
	}
	
	//Methods 
	public int bewerten() {
		return random.nextInt((15 - 1) + 1) + 1;
	}
	
	public void addKlasse(Klasse klasse) {
		klassenList.add(klasse);
	}
	public void removeKlasse(Klasse klasse) {
		klassenList.remove(klasse);
	}
}
