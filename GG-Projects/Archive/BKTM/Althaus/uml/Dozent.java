package BKTM.Althaus.uml;

import java.util.ArrayList;

public abstract class Dozent extends Mensch {
	
	public Dozent() {
		studentenList = new ArrayList<Student>();
	}
	
	// Assoziation - Student 
	private ArrayList<Student> studentenList;
	
	public Dozent(ArrayList<Student> studentenList) {
		this.studentenList = studentenList;
		for(Student current : studentenList) {
			current.addDozent(this);
		}
		
	}
	
	// Assoziation - Universitaet
	private Universitaet universitaet;
	
	public Dozent(Universitaet universitaet) {
		this.universitaet = universitaet;
		this.universitaet.addDozent(this);
	}
	
	public Dozent(Universitaet universitaet, ArrayList<Student> studentenList) {
		this.universitaet = universitaet;
		this.universitaet.addDozent(this);
		
		this.studentenList = studentenList;
		for(Student current : studentenList) {
			current.addDozent(this);
		}
		
	}
	
	// Methodes
	public void unterrichten() {}
	
	public void addStudent(Student student) {
		studentenList.add(student);
	}
	
	public void removeStudent(Student student) {
		studentenList.remove(student);
	}
	
	public Universitaet getUniversitaet() {
		return universitaet;
	}
	
	public void setUniversitaet(Universitaet universitaet) {
		this.universitaet = universitaet;
	}
	
}
