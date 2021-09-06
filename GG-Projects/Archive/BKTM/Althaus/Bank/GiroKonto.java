package BKTM.Althaus.Bank;

public class GiroKonto extends Konto{
	public GiroKonto(Kunde kd) {
		this.kontoID = kd.kundenID;
		this.name = kd.name;
		this.geburtsDatum = kd.geburtsDatum;
		
	}
	//Variablen
	protected final double kontoMin = -5000;
	protected final double sollZinsatz = 0.1308;
	
	protected double guthaben;
	
	//Geter 
	public double getKontoMin() {
		return kontoMin;
	}
	
	public double getGuthaben() {
		return guthaben;
	}
	
	
	//Seter
	//KontoMin soll nicht neu gestzt werden können
	
	public void setGuthabne(double input) {
		guthaben = input;
	}
}
