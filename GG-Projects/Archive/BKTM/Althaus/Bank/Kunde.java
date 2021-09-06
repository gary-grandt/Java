package BKTM.Althaus.Bank;

public class Kunde {
	//Konstructor
	public Kunde() {}
	public Kunde(int id) {
		isActive = false;
		kundenID = id;
	}
	
	//Variebalen
	protected boolean isActive;
	protected String name;
	protected String geburtsDatum;
	protected int pin;
	protected int kundenID;
	
	
	
	//Geter
	public boolean getIsActive() {
		return isActive;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGeburtsDatum() {
		return geburtsDatum;
	}
	
	public int getPin() {
		return pin;
	}
	
	public int kundenID() {
		return kundenID;
	}
	
	//Seter
	public void setIsActive(boolean input) {
		isActive = input;
	}
	
	public void setName(String input) {
		name = input;
	}
	
	public void setGeburtsDatum(String input) {
		geburtsDatum = input;
	}
	
	public void setPin(int input) {
		pin = input;
	}
	
	public void setKundenID(int input) {
		kundenID = input;
	}
}
