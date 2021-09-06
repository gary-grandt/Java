package BKTM.Althaus.uml;

public class Mensch {
    private String alter;
    private String vorname;
    private String nachname;
    
    // Konstruktor
    public Mensch() {}
    public Mensch(String alter, String vorname, String nachname) {
    	this.alter = alter;
    	this.vorname = vorname;
    	this.nachname = nachname;
    }
    
    // Getter / Setter
	public String getAlter() {
		return alter;
	}
	public void setAlter(String alter) {
		this.alter = alter;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}

