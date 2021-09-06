package BKTM.Althaus.CoronaGesellschaft;

import java.util.ArrayList;

public class Mensch {

	// Variables
	private String name;
	private double alter;
	private double koerperlicheVerfassung;

	private int[] positionInGrid;

	private boolean wirdBehandelt;
	private boolean tot;

	// ArrayList
	private ArrayList<Virus> infect;
	private ArrayList<Virus> immun;

	// Konstruktoren
	public Mensch() {
		this.name = "STD"; // STD Name
		this.alter = 45; // DurschnittsAlter
		this.koerperlicheVerfassung = 0.5; // STD Wert
		this.tot = false;

		// Assoziation
		infect = new ArrayList<Virus>();
		immun = new ArrayList<Virus>();

		// Komposistion
		this.immunReaktion = new Immunreaktion(koerperlicheVerfassung - (1 - (alter / 100)));
	}

	public Mensch(String name, double alter, double koerperlicheVerfassung, int[] positionInGrid) {
		this.name = name;
		this.alter = alter;
		this.tot = false;

		this.positionInGrid = positionInGrid;

		// Assoziation
		infect = new ArrayList<Virus>();
		immun = new ArrayList<Virus>();

		// Komposistion
		this.immunReaktion = new Immunreaktion(koerperlicheVerfassung - (1 -(alter / 100)));
	}

	// Methodes
	private void sterben() {
		tot = true;
	}

	public void sysOutLN() {
		System.out.println(" _> [" + positionInGrid[0] + "][" + positionInGrid[1] + "] " + name);
	}

	// Getter & Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getAlter() {
		return alter;
	}

	public void setWirdBehandelt(boolean wirdBehandelt) {
		this.wirdBehandelt = wirdBehandelt;
	}

	public boolean isTot() {
		return tot;
	}

	public boolean isActive() {
		if (isTot()) return false;
		return (infect.size() > immun.size() && infect.size() != 0);
	}

	public ArrayList<Virus> getInfect() {
		return infect;
	}

	public void addInfect(Virus newInfect) {
		infect.add(newInfect);
	}

	public ArrayList<Virus> getimmun() {
		return immun;
	}

	public void addImmun(Virus newImmun) {
		immun.add(newImmun);
	}

	public int[] getPositionInGrid() {
		return positionInGrid;
	}

	// --- immunreaktion ---
	public class Immunreaktion {
		// Variables
		private double auslastung;
		private double schwaeschungsGrad;
		private double kapazitaet;
		private double staerke;

		// Konstruktor
		public Immunreaktion(double immunStaerke) {
			if(immunStaerke < 0.1) immunStaerke = 0.1;
			setAuslastung(0);
			setSchwaeschungsGrad(0);
			setKapazitaet(immunStaerke);
			setStaerke(immunStaerke);
		}

		public double getAuslastung() {
			return auslastung;
		}
		public void setAuslastung(double auslastung) {
			this.auslastung = auslastung;
		}

		public double getSchwaeschungsGrad() {
			return schwaeschungsGrad;
		}
		public void setSchwaeschungsGrad(double schwaeschungsGrad) {
			this.schwaeschungsGrad = schwaeschungsGrad;
		}

		public double getKapazitaet() {
			return kapazitaet;
		}
		public void setKapazitaet(double kapazitaet) {
			this.kapazitaet = kapazitaet;
		}

		public double getStaerke() {
			return staerke;
		}
		public void setStaerke(double staerke) {
			this.staerke = staerke;
		}
	}

	// Komposition
	private Immunreaktion immunReaktion;

	public Immunreaktion getImmunReaktion() {
		return immunReaktion;
	}
	public void setImmunReaktion(Immunreaktion immunReaktion) {
		this.immunReaktion = immunReaktion;
	}

	public double getImmunAuslastung() {
		return immunReaktion.getAuslastung();
	}
	public void setImmunAuslastung(double auslastung) {
		immunReaktion.setAuslastung(auslastung);
	}

	public double getImmunSchwaeschungsGrad() {
		return immunReaktion.getSchwaeschungsGrad();
	}
	public void setImmunSchwaeschungsGrad(double schwaeschungsGrad) {
		immunReaktion.setSchwaeschungsGrad(schwaeschungsGrad);
	}

	public double getImmunKapazitaet() {
		return immunReaktion.getKapazitaet();
	}
	public void setImmunKapazitaet(double kapazitaet) {
		immunReaktion.setKapazitaet(kapazitaet);
	}

	public double getImmunStaerke() {
		return immunReaktion.getStaerke();
	}
	public void setImmunStaerke(double staerke) {
		immunReaktion.setStaerke(staerke);
	}

	// Methodes
	public boolean immunreaktion(Virus virus, boolean namenAusgabe) {
		// if ist Immun
		if (immun.contains(virus))
			return false;
		// if wird Immun
		if (21 * virus.getHaerteGrad() < new RandomS().randDouble(0, 21)) {
			immun.add(virus);
			setImmunAuslastung(0);
			// Nach einer Gensung wird auf die Immunauslastung auf 0 gestzt unabhängig von anderen infektionen
			if(namenAusgabe) {
				System.out.print("    ==> " + virus.getName() +" : Immun ");
				sysOutLN();
			}
			return false;
		}

		// Set ImmunSystem Auslastung
		setImmunAuslastung(getImmunAuslastung() + (new RandomS().randDouble() *virus.getHaerteGrad()));

		// Set ImmunSystem Kapazitaet
		setImmunKapazitaet((getImmunStaerke() * (1 - getImmunSchwaeschungsGrad())) - getImmunAuslastung());

		// After Reaktion
		if (getImmunKapazitaet() < 0 && !wirdBehandelt || new RandomS().randDouble() < virus.getMortalitaet()) {
			sterben();
			System.out.print("    ==> " + virus.getName() + " : Kills");
			sysOutLN();
			return true;
		}
		return false;
	}

	public void generateSchwaeschungsGrad() {
		double newSchwaeschungsGrad = 0;
		for (Virus current : immun) {
			newSchwaeschungsGrad = newSchwaeschungsGrad + (current.getHaerteGrad() / 5);
		}
		if (newSchwaeschungsGrad > 1)
			newSchwaeschungsGrad = 1;
		setImmunSchwaeschungsGrad(newSchwaeschungsGrad);
	}

}