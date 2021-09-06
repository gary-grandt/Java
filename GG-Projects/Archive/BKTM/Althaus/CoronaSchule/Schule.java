package BKTM.Althaus.CoronaSchule;

import java.util.ArrayList;

public class Schule {
	// Variables
	private String name;
	private boolean coronaVerdacht = false;
	private boolean isOffen;
	
	// Aggregationen
	private ArrayList<Person> personenList;
	private ArrayList<Klasse> klassenList;
	
	// Constructors 
	public Schule() {
		personenList = new ArrayList<Person>();
		klassenList = new ArrayList<Klasse>();
		raumList = new ArrayList<Raum>();
	}
	public Schule(String name) {
		this.name = name;
		personenList = new ArrayList<Person>();
		klassenList = new ArrayList<Klasse>();
		raumList = new ArrayList<Raum>();
		creatRaum("LehrerZimmer");
	}
	
	// Getter 
	public String getName() {
		return name;
	}
	public boolean getCoronaVerdacht() {
		return coronaVerdacht;
	}
	public boolean getIsOffen() {
		return isOffen;
	}
	// Getter Agrregationen
	public ArrayList<Person> getPersonenList() {
		return personenList;
	}
	public ArrayList<Klasse> getKlassenList() {
		return klassenList;
	}
	
	// Setter 
	public void setName(String name) {
		this.name = name;
	}
	public void setCoronaVerdacht(boolean coronaVerdacht) {
		this.coronaVerdacht = coronaVerdacht;
	}
	public void setIsOffen(boolean isOffen) {
		this.isOffen = isOffen;
	}
	// Setter Agrregationen
	public void setPersonenList(ArrayList<Person> personenList) {
		this.personenList = personenList;
	}
	public void setKlassenList(ArrayList<Klasse> klassenList) {
		this.klassenList = klassenList;
	}
	
	
	// Methods
	public boolean coronaVerdacht() {
		for(Person curent : personenList) {
			if(curent.getHatCorona()) return true;
		}
		return false;
	}
	
	public void schliessen() {
		System.out.println("");
		isOffen = false;
		for(Raum curent: raumList) {
			curent.setLichtAn(false);
			System.out.println("Licht ist AUS in : " + curent.getName());
		}
	}
	
	public void oeffnen() {
		System.out.println("");
		isOffen = true;
		for(Raum curent: raumList) {
			curent.setLichtAn(false);
			System.out.println("Licht ist AN in : " + curent.getName());
		}
	}
	
	// Merhods Agrregationen
	public void addPerson(Person person) {
		personenList.add(person);
	}
	public void removePeron(Person person) {
		personenList.remove(person);
	}
	
	public void addKlasse(Klasse klasse) {
		klassenList.add(klasse);
	}
	public void removeKlasse(Klasse klasse) {
		klassenList.remove(klasse);
	}
	
	
	
	//Raum-Variables
	private ArrayList<Raum> raumList;
	
	// Raum
	public class Raum {
		// Variables 
		private boolean lichtAn;
		private String name;
		private Klasse klasse;
		
		// Constructors 
		public Raum() {
			lichtAn=false;
			klasse = null;
		}
		public Raum(String name) {
			this.name = name;
			lichtAn=false;
			this.klasse = null;
		}
		public Raum(String name, Klasse klasse) {
			this.name = name;
			lichtAn=false;
			this.klasse = klasse;
			this.klasse.setKlassenRaum(this);
		}
		
		// Getter
		public boolean getLichtAn() {
			return lichtAn;
		}
		public String getName() {
			return name;
		}
		public Klasse getKlasse() {
			return klasse;
		}
		
		// Setter
		public void setLichtAn(boolean lichtAn) {
			this.lichtAn = lichtAn;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setKlasse(Klasse klasse) {
			this.klasse = klasse;
		}
	}
	
	// Raum-Methods
	public void creatRaum(String name) {
		raumList.add(new Raum(name));
	}
	public void creatRaum(String name, Klasse klasse) {
		raumList.add(new Raum(name, klasse));
	}
	
	public void deletRaum(Raum raum) {
		raumList.remove(raum);
	}
	public void deletRaumByNumber(int raumNumber) {
		if(raumNumber > 0 && raumNumber < raumList.size()) {
			raumList.remove(raumNumber);
		}else {
			System.out.println("Error :: deletRaumByNumber :: outOfBounce : " + raumNumber);
			return;
		}
	}
	
	public int getRaumIndex(Raum raum) {
		return raumList.indexOf(raum);
	}
	public int getRaumListSize() {
		return raumList.size();
	}
	
	// Raum-Getter
	public Raum getRaumByNumber(int raumNumber) {
		if(raumNumber > 0 && raumNumber < raumList.size()) {
			return raumList.get(raumNumber);
		}else {
			System.out.println("Error :: getRaumByNumber :: outOfBounce : " + raumNumber);
			return null;
		}
	}
	public boolean getRaumLichtAn(Raum raum) {
		return raum.getLichtAn();
	}
	public boolean getRaumLichtAnByNumber(int raumNumber) {
		return getRaumByNumber(raumNumber).getLichtAn();
	}
	
	public String getRaumName(Raum raum) {
		return raum.getName();
	}
	public String getRaumNameByNumber(int raumNumber) {
		return getRaumByNumber(raumNumber).getName();
	}
	
	// Raum-Setter
	public void setRaumByNumber(int raumNumber, Raum raum) {
		if(raumNumber > 0 && raumNumber < raumList.size()) {
			raumList.set(raumNumber, raum);
		}else {
			System.out.println("Error :: setRaumByNumber :: outOfBounce : " + raumNumber);
			return;
		}
	}
	
	public void setRaumLichtAn(Raum raum, boolean lichtAn) {
		raumList.remove(raum);
		raum.setLichtAn(lichtAn);
		raumList.add(raum);
	}
	public void setRaumLichtAnByNumber(int raumNumber, boolean lichtAn) {
		Raum helpRaum = getRaumByNumber(raumNumber);
		helpRaum.setLichtAn(lichtAn);
		setRaumByNumber(raumNumber, helpRaum);
	}
	
	public void setRaumName(Raum raum, String name) {
		raumList.remove(raum);
		raum.setName(name);
		raumList.add(raum);
	}
	public void setNameByNumber(int raumNumber, String name) {
		Raum helpRaum = getRaumByNumber(raumNumber);
		helpRaum.setName(name);
		setRaumByNumber(raumNumber, helpRaum);
	}
}









