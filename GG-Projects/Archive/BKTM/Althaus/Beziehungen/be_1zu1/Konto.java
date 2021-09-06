package BKTM.Althaus.Beziehungen.be_1zu1;

public class Konto {
	//Variables
	private Kunde kunde = null;
	private int guthaben = 0;
	private int pin;
	private int kontoMin = -5000;
	private String IBAN;
	
	//Constructors
	public Konto() {
		kunde = new Kunde();
	}
	
	public Konto(Kunde kunde) {
		this.kunde = kunde;
	}
	
	//Geter
	public Kunde getKunde() {
		return kunde;
	}
	
	public int getGuthaben() {
		return guthaben;
	}
	
	public int getPIN() {
		return pin;
	}
	
	public int getKontoMin() {
		return kontoMin;
	}
	
	public String getIBAN() {
		return IBAN;
	}
	
	//Seter
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	
	public void setGuthaben(int guthaben) {
		this.guthaben = guthaben;
	}
	
	public void setPIN(int pin) {
		this.pin = pin;
	}
	
	//KontoMin soll nicht gestzt werden können!
	
	public void setIBAN(String iban) {
		this.IBAN = iban;
	}
	
	//Methoden
	public boolean einzahlen(int amount) {
		if(amount > -1) {
			guthaben = guthaben + amount;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean auszaheln(int amount) {
		if(amount > -1 && guthaben - amount >= kontoMin) {
			System.out.println(guthaben - amount);
			guthaben = guthaben - amount;
			return true;
		}else {
			System.out.println("Bitte ueberpruefen sie ihren Kontostand!");
			return false;
		}
	}
	
}
