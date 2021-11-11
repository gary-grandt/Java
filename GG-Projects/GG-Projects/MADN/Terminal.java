package MADN;

import STD.Input;

public class Terminal {
	
	// Variables
	private int spielerAnzahl;
	
	private SpielFeld spielfeld;
	private Input input = new Input();
	
	// Methodes
	private void initializeGame() {
		spielerAnzahl = input.inInt_com(1, 64);
		spielfeld = new SpielFeld(spielerAnzahl, input.inInt_com(4, 16));
		
	}
	
	
	
	
	
	// Main
	private void main() {
		
	}
	
	
	
	
	
	
	// Start main
	public static void main(String[] args) {
		Terminal run = new Terminal();
		run.main();
	}
}
