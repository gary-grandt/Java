package BKTM.Althaus.Bank;

public class Logik {
	//Variablen
	boolean k_1_isActive;
	boolean k_2_isActive;
	boolean k_3_isActive;
	boolean k_4_isActive;
	
	
	//--------------
	//--- Kunden ---
	//--------------
	Kunde k_1 = new Kunde(001);
	
	Kunde k_2 = new Kunde(002);
	
	Kunde k_3 = new Kunde(003);
	
	Kunde k_4 = new Kunde(004);
	
	//Creat
	public void Kunde_1_creat(String name, int pin, String geburtsDatum) {
		k_1.setIsActive(true);
		k_1.setName(name);
		k_1.setPin(pin);
		k_1.setGeburtsDatum(geburtsDatum);
		
	}
	
	public void Kunde_2_creat(String name, int pin, String geburtsDatum) {
		k_2.setIsActive(true);
		k_2.setName(name);
		k_2.setPin(pin);
		k_2.setGeburtsDatum(geburtsDatum);
		
	}
	
	public void Kunde_3_creat(String name, int pin, String geburtsDatum) {
		k_3.setIsActive(true);
		k_3.setName(name);
		k_3.setPin(pin);
		k_3.setGeburtsDatum(geburtsDatum);
		
	}
	
	public void Kunde_4_creat(String name, int pin, String geburtsDatum) {
		k_4.setIsActive(true);
		k_4.setName(name);
		k_4.setPin(pin);
		k_4.setGeburtsDatum(geburtsDatum);
		
	}
	
	//Delete
	public void Kunde_1_create() {
		k_1.setIsActive(false);
	}
	
	public void Kunde_2_create() {
		k_2.setIsActive(false);
	}
	
	public void Kunde_3_create() {
		k_3.setIsActive(false);
	}
	
	public void Kunde_4_create() {
		k_4.setIsActive(false);
	}
	
	
	
	//-----------------
	//--- GiroKonto ---
	//-----------------
	GiroKonto k_1_gk_1 = new GiroKonto(k_1);
	GiroKonto k_1_gk_2 = new GiroKonto(k_1);
	GiroKonto k_1_gk_3 = new GiroKonto(k_1);
	GiroKonto k_1_gk_4 = new GiroKonto(k_1);
	
	GiroKonto k_2_gk_1 = new GiroKonto(k_2);
	GiroKonto k_2_gk_2 = new GiroKonto(k_2);
	GiroKonto k_2_gk_3 = new GiroKonto(k_2);
	GiroKonto k_2_gk_4 = new GiroKonto(k_2);
	
	GiroKonto k_3_gk_1 = new GiroKonto(k_3);
	GiroKonto k_3_gk_2 = new GiroKonto(k_3);
	GiroKonto k_3_gk_3 = new GiroKonto(k_3);
	GiroKonto k_3_gk_4 = new GiroKonto(k_3);
	
	GiroKonto k_4_gk_1 = new GiroKonto(k_4);
	GiroKonto k_4_gk_2 = new GiroKonto(k_4);
	GiroKonto k_4_gk_3 = new GiroKonto(k_4);
	GiroKonto k_4_gk_4 = new GiroKonto(k_4);
	
	//Creat
	public void k_1_gk_1_creat(double starGuthaben) {
		k_1_gk_1.setIsActive(true);
		k_1_gk_1.setGuthabne(starGuthaben);
	}
	
	public void k_1_gk_2_creat(double starGuthaben) {
		k_1_gk_1.setIsActive(true);
		k_1_gk_1.setGuthabne(starGuthaben);
	}
	
	public void k_1_gk_3_creat(double starGuthaben) {
		k_1_gk_1.setIsActive(true);
		k_1_gk_1.setGuthabne(starGuthaben);
	}
	
	public void k_1_gk_4_creat(double starGuthaben) {
		k_1_gk_1.setIsActive(true);
		k_1_gk_1.setGuthabne(starGuthaben);
	}
	
	
	public void k_2_gk_1_creat(double starGuthaben) {
		k_2_gk_1.setIsActive(true);
		k_2_gk_1.setGuthabne(starGuthaben);
	}
	
	public void k_2_gk_2_creat(double starGuthaben) {
		k_2_gk_2.setIsActive(true);
		k_2_gk_2.setGuthabne(starGuthaben);
	}
	
	public void k_2_gk_3_creat(double starGuthaben) {
		k_2_gk_3.setIsActive(true);
		k_2_gk_3.setGuthabne(starGuthaben);
	}
	
	public void k_2_gk_4_creat(double starGuthaben) {
		k_2_gk_4.setIsActive(true);
		k_2_gk_4.setGuthabne(starGuthaben);
	}
	
	
	public void k_3_gk_1_creat(double starGuthaben) {
		k_3_gk_1.setIsActive(true);
		k_3_gk_1.setGuthabne(starGuthaben);
	}
	
	public void k_3_gk_2_creat(double starGuthaben) {
		k_3_gk_2.setIsActive(true);
		k_3_gk_2.setGuthabne(starGuthaben);
	}
	
	public void k_3_gk_3_creat(double starGuthaben) {
		k_3_gk_3.setIsActive(true);
		k_3_gk_3.setGuthabne(starGuthaben);
	}
	
	public void k_3_gk_4_creat(double starGuthaben) {
		k_3_gk_4.setIsActive(true);
		k_3_gk_4.setGuthabne(starGuthaben);
	}
	
	
	public void k_4_gk_1_creat(double starGuthaben) {
		k_4_gk_1.setIsActive(true);
		k_4_gk_1.setGuthabne(starGuthaben);
	}
	
	public void k_4_gk_2_creat(double starGuthaben) {
		k_4_gk_2.setIsActive(true);
		k_4_gk_2.setGuthabne(starGuthaben);
	}
	
	public void k_4_gk_3_creat(double starGuthaben) {
		k_4_gk_3.setIsActive(true);
		k_4_gk_3.setGuthabne(starGuthaben);
	}
	
	public void k_4_gk_4_creat(double starGuthaben) {
		k_4_gk_4.setIsActive(true);
		k_4_gk_4.setGuthabne(starGuthaben);
	}
	
	
	//Delete
	public void k_1_gk_1_delete() {
		k_1_gk_1.setIsActive(false);
	}
	
	public void k_1_gk_2_delete() {
		k_1_gk_2.setIsActive(false);
	}
	
	public void k_1_gk_3_delete() {
		k_1_gk_3.setIsActive(false);
	}
	
	public void k_1_gk_4_delete() {
		k_1_gk_4.setIsActive(false);
	}
	
	
	public void k_2_gk_1_delete() {
		k_2_gk_1.setIsActive(false);
	}
	
	public void k_2_gk_2_delete() {
		k_2_gk_2.setIsActive(false);
	}
	
	public void k_2_gk_3_delete() {
		k_2_gk_3.setIsActive(false);
	}
	
	public void k_2_gk_4_delete() {
		k_2_gk_4.setIsActive(false);
	}
	
	
	public void k_3_gk_1_delete() {
		k_3_gk_1.setIsActive(false);
	}
	
	public void k_3_gk_2_delete() {
		k_3_gk_2.setIsActive(false);
	}
	
	public void k_3_gk_3_delete() {
		k_3_gk_3.setIsActive(false);
	}
	
	public void k_3_gk_4_delete() {
		k_3_gk_4.setIsActive(false);
	}
	
	
	public void k_4_gk_1_delete() {
		k_4_gk_1.setIsActive(false);
	}
	
	public void k_4_gk_2_delete() {
		k_4_gk_2.setIsActive(false);
	}
	
	public void k_4_gk_3_delete() {
		k_4_gk_3.setIsActive(false);
	}
	
	public void k_4_gk_4_delete() {
		k_4_gk_4.setIsActive(false);
	}
	
	
	//Einzahlen
	public void k_1_gk_1_einzahlen(double input) {
		k_1_gk_1.setGuthabne(k_1_gk_1.getGuthaben() + input);
	}
	
	public void k_1_gk_2_einzahlen(double input) {
		k_1_gk_2.setGuthabne(k_1_gk_2.getGuthaben() + input);
	}
	
	public void k_1_gk_3_einzahlen(double input) {
		k_1_gk_3.setGuthabne(k_1_gk_3.getGuthaben() + input);
	}
	
	public void k_1_gk_4_einzahlen(double input) {
		k_1_gk_4.setGuthabne(k_1_gk_4.getGuthaben() + input);
	}
	
	
	public void k_2_gk_1_einzahlen(double input) {
		k_2_gk_1.setGuthabne(k_2_gk_1.getGuthaben() + input);
	}
	
	public void k_2_gk_2_einzahlen(double input) {
		k_2_gk_2.setGuthabne(k_2_gk_2.getGuthaben() + input);
	}
	
	public void k_2_gk_3_einzahlen(double input) {
		k_2_gk_3.setGuthabne(k_2_gk_3.getGuthaben() + input);
	}
	
	public void k_2_gk_4_einzahlen(double input) {
		k_2_gk_4.setGuthabne(k_2_gk_4.getGuthaben() + input);
	}
	
	
	public void k_3_gk_1_einzahlen(double input) {
		k_3_gk_1.setGuthabne(k_3_gk_1.getGuthaben() + input);
	}
	
	public void k_3_gk_2_einzahlen(double input) {
		k_3_gk_2.setGuthabne(k_3_gk_2.getGuthaben() + input);
	}
	
	public void k_3_gk_3_einzahlen(double input) {
		k_3_gk_3.setGuthabne(k_3_gk_3.getGuthaben() + input);
	}
	
	public void k_3_gk_4_einzahlen(double input) {
		k_3_gk_4.setGuthabne(k_3_gk_4.getGuthaben() + input);
	}
	
	
	public void k_4_gk_1_einzahlen(double input) {
		k_4_gk_1.setGuthabne(k_4_gk_1.getGuthaben() + input);
	}
	
	public void k_4_gk_2_einzahlen(double input) {
		k_4_gk_2.setGuthabne(k_4_gk_2.getGuthaben() + input);
	}
	
	public void k_4_gk_3_einzahlen(double input) {
		k_4_gk_3.setGuthabne(k_4_gk_3.getGuthaben() + input);
	}
	
	public void k_4_gk_4_einzahlen(double input) {
		k_4_gk_4.setGuthabne(k_4_gk_4.getGuthaben() + input);
	}
	
	//Auszahlen
	public boolean k_1_gk_1_auszahlen(double amount) {
		if(k_1_gk_1.getGuthaben() - amount > k_1_gk_1.getKontoMin()) {
			k_1_gk_1.setGuthabne(k_1_gk_1.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_1_gk_2_auszahlen(double amount) {
		if(k_1_gk_2.getGuthaben() - amount > k_1_gk_2.getKontoMin()) {
			k_1_gk_2.setGuthabne(k_1_gk_2.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_1_gk_3_auszahlen(double amount) {
		if(k_1_gk_3.getGuthaben() - amount > k_1_gk_3.getKontoMin()) {
			k_1_gk_3.setGuthabne(k_1_gk_3.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_1_gk_4_auszahlen(double amount) {
		if(k_1_gk_4.getGuthaben() - amount > k_1_gk_4.getKontoMin()) {
			k_1_gk_4.setGuthabne(k_1_gk_4.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean k_2_gk_1_auszahlen(double amount) {
		if(k_2_gk_1.getGuthaben() - amount > k_2_gk_1.getKontoMin()) {
			k_1_gk_1.setGuthabne(k_2_gk_1.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_2_gk_2_auszahlen(double amount) {
		if(k_1_gk_2.getGuthaben() - amount > k_2_gk_2.getKontoMin()) {
			k_1_gk_2.setGuthabne(k_2_gk_2.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_2_gk_3_auszahlen(double amount) {
		if(k_2_gk_3.getGuthaben() - amount > k_2_gk_3.getKontoMin()) {
			k_2_gk_3.setGuthabne(k_2_gk_3.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_2_gk_4_auszahlen(double amount) {
		if(k_2_gk_4.getGuthaben() - amount > k_2_gk_4.getKontoMin()) {
			k_2_gk_4.setGuthabne(k_2_gk_4.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean k_3_gk_1_auszahlen(double amount) {
		if(k_3_gk_1.getGuthaben() - amount > k_3_gk_1.getKontoMin()) {
			k_3_gk_1.setGuthabne(k_3_gk_1.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_3_gk_2_auszahlen(double amount) {
		if(k_3_gk_2.getGuthaben() - amount > k_3_gk_2.getKontoMin()) {
			k_3_gk_2.setGuthabne(k_3_gk_2.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_3_gk_3_auszahlen(double amount) {
		if(k_3_gk_3.getGuthaben() - amount > k_3_gk_3.getKontoMin()) {
			k_3_gk_3.setGuthabne(k_3_gk_3.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_3_gk_4_auszahlen(double amount) {
		if(k_3_gk_4.getGuthaben() - amount > k_3_gk_4.getKontoMin()) {
			k_3_gk_4.setGuthabne(k_3_gk_4.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean k_4_gk_1_auszahlen(double amount) {
		if(k_4_gk_1.getGuthaben() - amount > k_4_gk_1.getKontoMin()) {
			k_4_gk_1.setGuthabne(k_4_gk_1.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_4_gk_2_auszahlen(double amount) {
		if(k_4_gk_2.getGuthaben() - amount > k_4_gk_2.getKontoMin()) {
			k_4_gk_2.setGuthabne(k_4_gk_2.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_4_gk_3_auszahlen(double amount) {
		if(k_4_gk_3.getGuthaben() - amount > k_4_gk_3.getKontoMin()) {
			k_4_gk_3.setGuthabne(k_4_gk_3.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean k_4_gk_4_auszahlen(double amount) {
		if(k_4_gk_4.getGuthaben() - amount > k_4_gk_4.getKontoMin()) {
			k_4_gk_4.setGuthabne(k_4_gk_4.getGuthaben() - amount);
			return true;
		}else {
			return false;
		}
	}
	
	
	//-----------------
	//--- SparKonto ---
	//-----------------
	
	
	
	
	
	
	
	
}