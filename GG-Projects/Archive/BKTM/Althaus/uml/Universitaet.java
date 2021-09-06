package BKTM.Althaus.uml;
import java.util.ArrayList;

public class Universitaet {
	// Variables
	private String name;
	private boolean istAuf;
	
	// Konstuktor 
	public Universitaet() {}
	
	// Assoziation - Dozent
	private ArrayList<Dozent> dozentenList;
	
	public Universitaet(ArrayList<Dozent> dozentenList) {
		this.setDozentenList(dozentenList);
		for(Dozent current : this.dozentenList) {
			current.setUniversitaet(this);
		}
	}
	
	public void addDozent(Dozent dozent) {
		dozentenList.add(dozent);
	}
	public void removeDozent(Dozent dozent) {
		dozentenList.remove(dozent);
	}
	
	
	// Methodes
	public void schliessen() {}

	public void oeffnen() {}
	
	// Getter / Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIstAuf() {
		return istAuf;
	}

	public void setIstAuf(boolean istAuf) {
		this.istAuf = istAuf;
	}
	
	public ArrayList<Dozent> getDozentenList() {
		return dozentenList;
	}

	public void setDozentenList(ArrayList<Dozent> dozentenList) {
		this.dozentenList = dozentenList;
	}
	
	// --- Komposition --- 
	public class Gebaeude {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public String getGebaeudeName(Gebaeude gebaeude) {
		return gebaeude.getName();
	}
	
	public void setGebaeudeName(Gebaeude gebaeude, String name) {
		gebaeude.setName(name);
	}
	
}
