package SEHELL;


import STD.Input;
import STD.Tools;

public class SEHELL {
	
	// --- Variables ---
	
	private boolean endProcessLoop = false;
	
	private String comand;
	
	// --- Objects ---
	
	Input processInput = new Input();
	Tools processTools = new Tools();
	
	// --- Process-Loop ---
	private void main() {
		printStart();
		
		while(!endProcessLoop) {
			
			comand = processInput.in();
			
			switch(comand) {
			case "-1": //Help
				println("\nDid you realy want to end SEHELL? \n");
				endProcessLoop = processInput.inBoolean_com();
				break;
			case "0":
			case "00":
				mainMethod_help();
				break;
			
			case "1":
			case "01": 
				processTools.cls();
				break;
			case "2":
			case "02":
				
				break;
			case "3":
			case "03":
				
				break;
			case "4":
			case "04":
				
				break;
			
			case "5":
			case "05":
				
				break;
			default: mainMethod_help();
				break;
			}
			
			
		}
	}
	
	
	// --- Methods ---
	
	private void println(String input) {
		System.out.println(input);
	}
	
	private void printStart() {
		println("\n ---------------- SEHELL ---------------- \n");
	}
	
	// Main Methods
	
	private void mainMethod_help() {
		println("\n --- SEHELL-HELP ---\n");
		
		println(" -1 : To end SEHELL? \n");
		
		println(" 00 : Help \n");
		
		println(" 01 : cls (CLear Screen) ");
		println(" 02 : Pictures ");
		println(" 03 : Music ");
		println(" 04 : Video ");
		println("\n");
		
		println(" 01 : Text ");
		println(" 02 : Pictures ");
		println(" 03 : Music ");
		println(" 04 : Video ");
		println("\n");
		
		println(" 05 : cls");
		
	}
	
	
	// StartMainMethod
	public static void main(String[] args) {
		SEHELL start = new SEHELL();
		start.main();
	}
}
