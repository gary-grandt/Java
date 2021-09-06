package BKTM.Althaus.Beziehungen.be_1zu1;

import STD.Input;

public class Main {
	//Variables
	private Kunde kunde = new Kunde();
	private Konto konto = kunde.getKonto();
	
	private boolean end = false;
	private int auswahl;
	
	//Input
	Input input = new Input();
	
	//Main
	private void main() {
		//InitKunde
		System.out.println("Wie heiﬂen sie?");
		kunde.setName(input.in());
		System.out.println("Wann worde sie geobren (Jahr/Monat/Tag) ?");
		kunde.setAlter(input.in());
		
		//InitKonto
		System.out.println("Bitte legen sie ihren Pin fest: ");
		konto.setPIN(input.inInt_com(0, 9999));
		System.out.println("Bitte geben sie die IBAN ein: ");
		konto.setIBAN(input.in());
		
		while(!end) {
			System.out.println("  ");
			System.out.println("0 Beenden");
			System.out.println("1 Kontostand anzeigen");
			System.out.println("2 Einzahlen");
			System.out.println("3 Auszahlen");
			auswahl = input.inInt_com(0, 3);
			
			switch(auswahl) {
			case 0:
				beenden();
				break;
			case 1: 
				kontostand();
				break;
			case 2: 
				einzahlen();
				break;
			case 3:
				auszahlen();
				break;
				
				default :
					System.out.println("\n    ERROR: Main_WHilE_SWITCH_auswahl-FAIL");
			}
		}
	}
	
	//Methods
	private void beenden() {
		System.out.println("\nWollen sie das Program wirklich beeden?");
		end = input.inBoolean_com();
	}
	
	private void kontostand() {
		System.out.println("\nIhr Kontostand betr‰gt : ");
		System.out.println("    " + konto.getGuthaben());
	}
	
	private void einzahlen() {
		System.out.println("Wie viel wollen sie einzahlen?");
		if(!konto.einzahlen(input.inInt_com(0, 999999999))) {
			System.out.println("Einzahlen ist fehlgeschlagen");
		}
	}
	
	private void auszahlen() {
		System.out.println("Bitte geben sie ihren PIN ein : ");
		if(input.inInt_com(0, 9999) == konto.getPIN())  {
			System.out.println("Wie viel wollen sie auszahlen?");
			if(!konto.auszaheln(input.inInt_com(0, 999999999))) {
				System.out.println("Auszahlen ist fehlgeschlagen");
			}
		}else {
			System.out.println("Ihr PIN ist falsch!");
		}
	}
	
	//Main-run
	public static void main(String arges[]) {
		Main run = new Main();
		run.main();
	}
}