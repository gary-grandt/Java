package BKTM.Althaus.CoronaGesellschaft;

import java.util.ArrayList;

public class Gesellschaft {
	
	//Variables
	private Mensch[][] population;
	private double massnahmen;
	private double wohlstand;
	
	private Gesundheitssystem gesundheitssystem;
	
	private boolean namenAusgabe;
	
	//Constructor
	public Gesellschaft() {
		population = null;
		massnahmen = 0;
		wohlstand = 0;
		namenAusgabe = false;
	}
	
	public Gesellschaft(Mensch[][] population, Gesundheitssystem gesundheitssystem, double wohlstand, boolean namenAusgabe) {
		this.population = population;
		this.gesundheitssystem = gesundheitssystem;
		
		massnahmen = 0;
		if(0 <= wohlstand && wohlstand <= 1) {
			this.wohlstand = wohlstand;
		}else {
			System.out.println("Error :: Wohlstand must be 0 >= wohlstand <= 1 !");
		}
		
		this.namenAusgabe = namenAusgabe;
	}
	
	// --- Methodes ---
	public void massnahmen() {
		double infactionCount = 0;
		for(int x = 0; x < population.length; x++) {
			for(int y = 0; y < population[x].length; y++) {
				if(population[x][y].isActive()) infactionCount++;
			}
		}
		System.out.println("  ==> Massnahmen : ");
		System.out.println("    Active infections : " + infactionCount);
		
		double maxKapazitaet = gesundheitssystem.getKapazitaet();
		System.out.println("    Max-Kapazität : " + maxKapazitaet);
		double inBehadlung = gesundheitssystem.getBehandlung().size();
		System.out.println("    Kapazität : " + inBehadlung);
		
		massnahmen = infactionCount /maxKapazitaet;
		if(massnahmen > 1) massnahmen = 1;
		
		System.out.println("    Massnamen : " +massnahmen);
	}
	
	public void kapazitaetenAusbauen() {
		// Max 10% a Week
		gesundheitssystem.setKapazitaet((int)(gesundheitssystem.getKapazitaet() +(gesundheitssystem.getKapazitaet() *(massnahmen*wohlstand /10 /7))));
		// (Ka /10 /7) * wohlstand * massnahmen
		
	}
	
	// Gesundheitssystem
	
	public void gesundheissystemBehandeln() {
		gesundheitssystem.behandeln(namenAusgabe);
	}
	
	// Mensch
	public void addInfact(Virus virus, int gridX, int gridY) {
		Mensch mensch = population[gridX][gridY];
		if(virus.canInfact(mensch)) {
			mensch.addInfect(virus);
			virus.addInfact(mensch);
			
			gesundheitssystem.addWarteList(mensch);
			
			if(namenAusgabe) {
				System.out.print("    new Infect: " + virus.getName());
				mensch.sysOutLN();
			}
		}
	}
	
	public ArrayList<Mensch> newInfact(Virus virus, int gridX, int gridY, double effekt) {
		ArrayList<Mensch> returnList= new ArrayList<Mensch>();
		
		for(int x = gridX-1; x <= gridX+1; x++) {
			if(x >= 0 && x < population.length) { // isInGrid(x)
				
				for(int y = gridY-1; y <= gridY+1; y++) {
					if(y >= 0 && y < population[0].length) { // isInGrid(y)
						
						if(((virus.getRnull() *(1 -massnahmen*effekt)) > new RandomS().randDouble()) && virus.canInfact(population[x][y])) { // isNewInfection
							
							Mensch mensch = population[x][y];
							mensch.addInfect(virus);
							gesundheitssystem.addWarteList(mensch);
							returnList.add(mensch);
							
							if(namenAusgabe) {
								System.out.print("    new Infect: " + virus.getName());
								mensch.sysOutLN();
							}
						}
						
					}
				}
				
			}
		}
		
		return returnList;
	}
	
	public void immunreaktion(Virus virus) {
		ArrayList<Mensch> newKills = new ArrayList<Mensch>();
		for(Mensch current : virus.getInfacted()) {
			if(current.immunreaktion(virus, namenAusgabe)) newKills.add(current);
		}
		for(Mensch current : newKills) virus.addKill(current);
	}
	
	public void generateSchwaeschungsGrad() {
		for(int x = 0; x < population.length; x++) {
			for(int y = 0; y < population[x].length; y++) {
				population[x][y].generateSchwaeschungsGrad();
			}
		}
	}
	
	// --- Getter & Setter --- 
	
	public Gesundheitssystem getGesundheitssystem() {
		return gesundheitssystem;
	}
	
	// Aggregation
	
	// Gesundheitssystem
	
	/*public int getGesundheitssystemKapazitaet() {
		return gesundheitssystem.getKapazitaet();
	}
	public void setGesundheitssystemKapazitaet(int kapazitaet) {
		gesundheitssystem.setKapazitaet(kapazitaet);
	}*/		// Wird über KapazitaetenAusbauen() & massnahmen geregelt
	
	public ArrayList<Mensch> getBehandlungs() {
		return gesundheitssystem.getBehandlung();
	}
	public void removeBehandlung(Mensch mensch) {
		gesundheitssystem.removeBehandlung(mensch);
	}
	
	public ArrayList<Mensch> getWarteList() {
		return gesundheitssystem.getWarteList();
	}
	public void addWarteList(Mensch mensch) {
		gesundheitssystem.addWarteList(mensch);
	}
	
	// Print Picture
	public void printPicture(int round) {
		new PrintSimulation(population, round).print();
	}
	
}
