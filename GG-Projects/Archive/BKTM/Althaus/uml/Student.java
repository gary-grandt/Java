package BKTM.Althaus.uml;
import java.util.ArrayList;

public class Student extends Mensch {
	//Variables
	private String studiengang;
	
	// Konstruktoren
	public Student() {
		dozentenList = new ArrayList<Dozent>();
	}
	public Student(String studiengang) {
		this.studiengang = studiengang;
		dozentenList = new ArrayList<Dozent>();
	}
	
	// Assoziation 
	private ArrayList<Dozent> dozentenList;
	
	public Student(ArrayList<Dozent> dozentenList) {
		this.dozentenList = dozentenList;
		for(Dozent current : dozentenList) {
			current.addStudent(this);
		}
	}
	
	// Methodes 
	public void anwesendsein() {}
	
	public void addDozent(Dozent dozent) {
		dozentenList.add(dozent);
	}
	public void removeDozent(Dozent dozent) {
		dozentenList.remove(dozent);
	}
	
	// Getter / Setter
	
	public String getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}
}
