package MADN;

import java.util.ArrayList;

public class SpielFeld {
	public SpielFeld(int anzahlSpieler, int anzahlFelder) {
		
	}
	
	// Variables
	ArrayList<Integer[]> feldAbschnitte;
	
	
	// Methodes 
	private void generatefeldAbschnitte(int anzahlSpieler, int anzahlFelder) {
		feldAbschnitte = new ArrayList<Integer[]>();
		
		for(int i = 0; 0 < anzahlSpieler; i++) {
			
		}
	}
	
	private Integer[] getEmtyAbschnitte(int anzahlFelder) {
		Integer[] abschnitt = new Integer[anzahlFelder];
		for(int i = 0; i < anzahlFelder; i++) {
			abschnitt[i] = 0;
		}
		return abschnitt;
	}
}
