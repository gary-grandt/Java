package BKTM.Althaus.CoronaGesellschaft;

import java.util.ArrayList;

public class Gesundheitssystem {
	
	// Variables 
	private int kapazitaet;
	private ArrayList<Mensch> behandlung;
	private ArrayList<Mensch> warteList;
	
	// Konstruktoren
	public Gesundheitssystem() {
		kapazitaet = 0;
		behandlung = new ArrayList<Mensch>();
		warteList = new ArrayList<Mensch>();
	}
	
	public Gesundheitssystem(int kapazitaet) {
		this.kapazitaet = kapazitaet;
		behandlung = new ArrayList<Mensch>();
		warteList = new ArrayList<Mensch>();
	}
	
	public Gesundheitssystem(int kapazitaet, ArrayList<Mensch> behandlung ,ArrayList<Mensch> warteList) {
		this.kapazitaet = kapazitaet;
		this.behandlung = behandlung;
		this.warteList = warteList;
	}
	
	// Methodes
	public void behandeln(boolean namenAusgabe) {
		while(behandlung.size() < kapazitaet && warteList.size() != 0) {
			Mensch current = warteList.get(0);
			warteList.remove(current);
			if(!current.isTot()) {
				behandlung.add(current);
				current.setWirdBehandelt(true);
				
				if(namenAusgabe) {
					System.out.print("    inBehandlung");
				current.sysOutLN();
				}
			}
		}
		
		ArrayList<Mensch> removeBehandlung = new ArrayList<Mensch>();
		for(Mensch current : behandlung) if(!current.isActive()) removeBehandlung.add(current);
		for(Mensch current : removeBehandlung) behandlung.remove(current);
	}
	
	// Getter & Setter
	public int getKapazitaet() {
		return kapazitaet;
	}
	public void setKapazitaet(int kapazitaet) {
		this.kapazitaet = kapazitaet;
	}
	
	public ArrayList<Mensch> getBehandlung() {
		return behandlung;
	}
	public void removeBehandlung(Mensch mensch) {
		behandlung.remove(mensch);
	}
	
	public ArrayList<Mensch> getWarteList() {
		return warteList;
	}
	public void addWarteList(Mensch mensch) {
		warteList.add(mensch);
	}
}
