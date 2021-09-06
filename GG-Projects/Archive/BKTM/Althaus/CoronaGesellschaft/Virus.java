package BKTM.Althaus.CoronaGesellschaft;

import java.util.ArrayList;

public class Virus {
	
	//Variable
	private String name;
	private double rnull;
	private double haerteGrad;
	private double mortalitaet;
	
	private int[] infactionKey = new int[3];
	
	// Konstruktoren
	public Virus() {
		infacted = new ArrayList<Mensch>();
		killed = new ArrayList<Mensch>();
	}
	public Virus(String name, double rnull, double haerteGrad, double mortaliteat) {
		this.name = name;
		this.rnull = rnull;
		this.haerteGrad = haerteGrad;
		this.mortalitaet = mortaliteat;
		//Generaiting infactionKey
		this.infactionKey[0] = (int) (255*this.mortalitaet);
		this.infactionKey[1] = (int) (255*this.rnull);
		this.infactionKey[2] = (int) (255*this.haerteGrad);
		
		infacted = new ArrayList<Mensch>();
		killed = new ArrayList<Mensch>();
	}
	
	// Assoziation
	private RunSimulation simulation;
	private ArrayList<Mensch> infacted;
	private ArrayList<Mensch> killed;
	
	public Virus(String name, double rnull, double haerteGrad, double mortaliteat, RunSimulation simulation) {
		this.name = name;
		this.rnull = rnull;
		this.haerteGrad = haerteGrad;
		this.mortalitaet = mortaliteat;
		//Generaiting infactionKey
		this.infactionKey[0] = (int) (255*this.mortalitaet);
		this.infactionKey[1] = (int) (255*this.rnull);
		this.infactionKey[2] = (int) (255*this.haerteGrad);
		//Assoziation
		this.simulation = simulation;
		this.simulation.addVirus(this);

		infacted = new ArrayList<Mensch>();
		killed = new ArrayList<Mensch>();
	}
	
	public ArrayList<Mensch> getInfacted() {
		return infacted;
	}
	public void addInfact(Mensch newInfact) {
		if(!infacted.contains(newInfact)) {
			infacted.add(newInfact);
		}
	}
	public void removeInfact(Mensch removeInfact) {
		infacted.remove(removeInfact);
	}
	
	public ArrayList<Mensch> getKilled() {
		return killed;
	}
	public void addKill(Mensch newKill) {
		killed.add(newKill);
		infacted.remove(newKill);
	}
	
	// Methode
	public Virus mutiere() {
		String muttationName = "Muttation: " + (simulation.getVirusList().size()-1);
		RandomS random = new RandomS();
		double newRnull = random.randMutation(rnull, (haerteGrad /10));
		double newHaerteGrad = random.randMutation(haerteGrad, (haerteGrad /10));
		double newMortaliteat = random.randMutation(mortalitaet, (haerteGrad /10));
		while(newMortaliteat > newHaerteGrad) {
			newMortaliteat = random.randMutation(mortalitaet, (haerteGrad /10));
		}
		
		Virus muttation = new Virus(muttationName, newRnull, newHaerteGrad, newMortaliteat);
		
		return muttation;
	}
	
	public boolean canInfact(Mensch mensch) {
		if(infacted.contains(mensch) || mensch.isTot()) return false;
		
		boolean canInfact = true;
		ArrayList<Virus> infationList = mensch.getInfect();
		for(Virus current : infationList) {
			double abweichung = current.getRnull() - rnull;
			if(abweichung > haerteGrad || abweichung < -haerteGrad) canInfact = false;
			abweichung = current.getHaerteGrad() - haerteGrad;
			if(abweichung > haerteGrad || abweichung < -haerteGrad) canInfact = false;
			abweichung = current.getRnull() - rnull;
			if(abweichung > haerteGrad || abweichung < -haerteGrad) canInfact = false;
		}
		return canInfact;
	}
	
	// Getter
	public String getName() {
		return name;
	}
	public double getRnull() {
		return rnull;
	}
	public double getHaerteGrad() {
		return haerteGrad;
	}
	public double getMortalitaet() {
		return mortalitaet;
	}
	
	public int[] getInfactionKey() {
		return infactionKey;
	}
	public RunSimulation getSimulation() {
		return simulation;
	}
}
