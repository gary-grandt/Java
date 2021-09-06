package BKTM.Althaus.Bank;

public class SparKonto extends Konto {
	public SparKonto(Kunde kd) {
		this.kontoID = kd.kundenID;
		this.name = kd.name;
		this.geburtsDatum = kd.geburtsDatum;
		
	}
	// Variablen
	protected final double kontoMin = 5;
	protected final double zinsSatz = 3.5;

	protected double guthaben = 5;

	// Geter
	public double getGuthaben() {
		return guthaben;
	}

	// Seter
	public void setGuthabne(double input) {
		guthaben = input;
	}
}
