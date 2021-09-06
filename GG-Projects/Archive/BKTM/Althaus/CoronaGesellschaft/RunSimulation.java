package BKTM.Althaus.CoronaGesellschaft;

import java.util.ArrayList;
import java.util.Scanner;

public class RunSimulation {

	// Varialbes
	private Gesellschaft simulationsGesellschaft;		// Todo replace all simulationsGesellschaft with simulationsGesellschaft !

	private Mensch[][] population;

	private ArrayList<Virus> virusList;
	
	private boolean namenAusgabe;

	private void main() {
		// setting Up
		setUP();
		
		int durchleufe = 64;
		for(int i = 0; i < durchleufe; i++) {
			System.out.println("\n --- Sim - Round : " + i + " --- ");
			
			// Behandlung
			if(namenAusgabe) System.out.println("  ==> Behandlung ");
			simulationsGesellschaft.gesundheissystemBehandeln();
			
			// Generate Schwaeschungs Grad
			System.out.println("  ==> Generate SchwaeschungsGrad ...");
			simulationsGesellschaft.generateSchwaeschungsGrad();
			
			// ImmunStrugel
			for(Virus current: virusList) simulationsGesellschaft.immunreaktion(current);
			
			// New Infacts
			if(namenAusgabe) System.out.println("  ==> New Infactions");
			genrateNewInfactions(0.8);
				// _> effekt der Massnahmen ( min: 0, max: 1)
			
			// Massnamen
			simulationsGesellschaft.massnahmen();
			
			// KapazitaetenAusbauen
			simulationsGesellschaft.kapazitaetenAusbauen();
			
			// Print all Infections
			printTotalInfactions();
			// Print Deaths
			printTotalDeaths();
			
			// Print Picture 
			//simulationsGesellschaft.printPicture(i);
			
			System.out.println(" --- End : Round : " + i + " --- ");
		}
		
		System.out.println("\n --- End : Simulation --- \n");
	}
	
	// SetUP
	@SuppressWarnings("resource")
	private void setUP() {
		System.out.println(" --- SetUP --- ");
		// Namen Ausgabe
		System.out.println("  Wollen Sie eine Namenausgabe?");
		namenAusgabe = new Scanner(System.in).nextBoolean();
		
		// Population
		int pop = 1000;
		population = new Mensch[pop][pop];
			// _> population von 10.000 Menschen
		for(int i = 0; i < pop; i++) {
			for(int j = 0; j < pop; j++) {
				int[] positionInGrid = {i, j};
				population[i][j] = new Mensch(nameGenrator(), new RandomS().randInt(18, 80), new RandomS().randDouble(0.4, 1), positionInGrid);
			}
		}
		
		// Gesundheitssystem
		Gesundheitssystem gesundheitsSystem = new Gesundheitssystem(pop*2);
			// _> pop*2 = 20% der Population an Kapazitaet
		
		// simulationsGesellschaft
		simulationsGesellschaft = new Gesellschaft(population, gesundheitsSystem, 0.8, namenAusgabe);
		// pupulation, gesundheitsSystem, wohlstand (default) 0.8
		
		// Virus
		virusList = new ArrayList<Virus>();
		virusList.add(new Virus("Corona", 0.5, 0.2, 0.05));
		// _> rnull Menschen können 8 umliegende mit Warscheinlich keit rnull invizieren
		//			8*0.5 = 4, zu beginn lag der R wert bei umgefähr 4
		// _> haereGrad (default) 0.2
		// _> mortalitaet (default) 0.05
		
		genrateStartInfactions(4, pop);
		
		simulationsGesellschaft.printPicture(-1);
	}
	
	// Methodes
	private String nameGenrator() {
		// Achim Harz4, Kappitän zuSee, 
		String[] vorName  = {"Elvira", "Simon", "Grumpy", "Tom", "Jiggo", "Johnny", "Laura", "Heinrich", "Lena", "Achim", "Günter", "Joel", "Klaus", "Susanne", "Jami", "Friedrich", "Elon", "Bernd", "Tyrion", "Robert", "Jeri", "Dagmar", "Lea", "Monika",                     "Arnold", "Patrick", "Norbert", "Manfred", "Tom", "Emma", "Anton", "Hans", "Kapatiän"};
		String[] nachName = {"Bauer", "Backer", "Cat", "Cruise", "Derckx", "Depp", "Fischer", "Glawitzka", "Heuter", "Harz4", "Jauch", "Kinnaman", "Kinski", "Lange", "Lennister", "Müller", "Musk", "Neuman", "Poser", "Richter", "Ryan", "Schmidt", "Schneider", "Schumacher", "Schwarzenegger", "Stewart", "Wolff", "Vogel","Wember", "Watson", "Ziegler","Zimmer", "ZurSee"};
		return vorName[new RandomS().randInt(0, 32)] +" "+ nachName[new RandomS().randInt(0, 7)];
	}
	
	private void genrateStartInfactions(int startInfactions, int pop) {
		Virus virus = virusList.get(0);
		for(int i = 0; i < startInfactions; i++) {
			simulationsGesellschaft.addInfact(virus, new RandomS().randInt(0, pop-1), new RandomS().randInt(0, pop-1));
		}
	}
	
	private void genrateNewInfactions(double effekt) {
		for(Virus virus : virusList) {
			ArrayList<Mensch> newInfections = new ArrayList<Mensch>();
			for(Mensch current : virus.getInfacted()) {
				int pos[] = current.getPositionInGrid();
				newInfections.addAll(simulationsGesellschaft.newInfact(virus, pos[0], pos[1], effekt));
			}
			for(Mensch current : newInfections) {
				virus.addInfact(current);
			}
		}
	}
	
	private void printTotalInfactions() {
		int totalInfactions = 0;
		for(Virus current : virusList) {
			totalInfactions = totalInfactions + current.getInfacted().size();
		}
		System.out.println("  Total Infactions : " + totalInfactions);
	}
	private void printTotalDeaths() {
		int deaths = 0;
		for(Virus current : virusList) {
			deaths = deaths + current.getKilled().size();
		}
		System.out.println("  Total Deaths : " + deaths);
	}
	
	// Getter & Setter
	public ArrayList<Virus> getVirusList() {
		return virusList;
	}
	public void setVirusList(ArrayList<Virus> virusList) {
		this.virusList = virusList;
	}
	public void addVirus(Virus newVirus) {
		virusList.add(newVirus);
	}

	// Start Main
	public static void main(String[] args) {
		RunSimulation run = new RunSimulation();
		run.main();
	}

}
