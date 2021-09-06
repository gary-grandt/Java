package BKTM.Althaus.uml;

public class Universitaetsleiter extends Mensch {
    // Varialbes
	private boolean hauptschluessel;
    
	// Konsturktor
	public Universitaetsleiter() {}
	
	// Aggregation
    private Universitaet unversiteat;
	
    public Universitaetsleiter(Universitaet unversiteat) {
    	this.unversiteat = unversiteat;
    }
    
    // Aggregation - Methodes
    public void unversiteatSchliessen() {
    	unversiteat.schliessen();
    }
    public void unversiteatOEffnen() {
    	unversiteat.oeffnen();
    }
    
    public String unversiteatGetName() {
    	return unversiteat.getName();
    }
    public void unversiteatSetName(String name) {
    	unversiteat.setName(name);
    }
    
    public boolean unversiteatGetIstAuf() {
    	return unversiteat.getIstAuf();
    }
    public void unversiteatSetIstAuf(boolean istAuf) {
    	unversiteat.setIstAuf(istAuf);
    }
    
    // Aggregation - Komposition - Methodes
    public String unversiteatGetGebaeudeName(Universitaet.Gebaeude gebaeude) {
		return unversiteat.getGebaeudeName(gebaeude);
	}
    public void unversiteatSetGebaeudeName(Universitaet.Gebaeude gebaeude, String name) {
		unversiteat.setGebaeudeName(gebaeude, name);
	}
    
    // Getter - Setter
	public boolean getHauptschluessel() {
		return hauptschluessel;
	}

	public void setHauptschluessel(boolean hauptschluessel) {
		this.hauptschluessel = hauptschluessel;
	}

	public Universitaet getUnversiteat() {
		return unversiteat;
	}

	public void setUnversiteat(Universitaet unversiteat) {
		this.unversiteat = unversiteat;
	}
}

