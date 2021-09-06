package Games;

import STD.Input;
import STD.Random;

public class Zwei48 {
	//Variablen
	private boolean gameLoop = true;
	//private boolean gameLoop_request = false;
	private int[][] spielfeld;
	private int spielfeld_length = 2;
	private int gameInput;
	
	
	//Input
	Input input = new Input();
	//Random
	Random rand = new Random();
	
	
	//------------
	//--- Main ---
	//------------
	public void main() {
		//Spielfeld Init
		System.out.println("Mit wie groß soll das Feld sein? (2, 4, 8) ");
		spielfeld_length = input.inInt_com(2, 8);
		spielfeld = new int[spielfeld_length][spielfeld_length];
		//Spielfeld fillUp
		for(int i = 0; i < spielfeld_length; i++) {
			for(int j = 0; j < spielfeld_length; j++) {
				spielfeld[i][j] = 0;
			}
		}
		//Game-Loop
		while(canFind_FreeSlot() && gameLoop) {
			//Random Number add
			generateRandom();
			//Display Spielfeld
			printSpielfeld();
			//Player MovementInput
			System.out.println("Movements : Down(1), Up(2), Right(3), Left(4) ");
			gameInput = input.inInt_com(1, 4);
			//Movement
			switch(gameInput) {
				case 1: moveDown();
					break;
				case 2: moveUp();
					break;
				case 3: moveRight();
					break;
				case 4: moveLeft();
					break;
				default: System.out.println("Error: Infalid Input!");
			}
		}
		System.out.println("Game End");
	}
	
	//----------------
	//--- MultyUse ---
	//----------------
	
	//Can Find Free Slot?
	private boolean canFind_FreeSlot() {
		for(int i = 0; i < spielfeld_length; i++) {
			for(int j = 0; j < spielfeld_length; j++) {
				if(spielfeld[i][j] == 0) return true;
			}
		}
		return false;
	}
	
	//Is this Slot free?
	private boolean isSlootFree(int x, int y) {
		if(spielfeld[x][y] == 0) return true;
		return false;
	}
	
	//----------------
	//--- Movement ---
	//----------------
	private void moveDown() {
		for(int x = 0; x < spielfeld_length; x++) {
			for(int y = 0; y < spielfeld_length; y++) {
				// Nicht letete Zahl! 
				if(x < spielfeld_length-1) {
					//Wenn untere Zahl gleich null Rücke auf
					if(spielfeld[x+1][y] == 0) {
						spielfeld[x+1][y] = spielfeld[x][y];
						spielfeld[x][y] = 0;
					//Wenn Zahl unter einen Gleich Dann Addiere
					}else if(spielfeld[x+1][y] == spielfeld[x][y]) {
						spielfeld[x+1][y] = spielfeld[x+1][y] + spielfeld[x][y];
						spielfeld[x][y] = 0;
					}	
				}
			}
		}
	}
	
	private void moveUp() {
		for(int x = spielfeld_length-1; x > 0; x--) {
			for(int y = 0; y < spielfeld_length; y++) {
				// Nicht Erste 
				if(x > 0) {
					//Wenn obere Zahl gleich null, Rücke auf
					if(spielfeld[x-1][y] == 0) {
						spielfeld[x-1][y] = spielfeld[x][y];
						spielfeld[x][y] = 0;
					//Wenn Zahl ober einen Gleich Dann Addiere
					}else if(spielfeld[x-1][y] == spielfeld[x][y]) {
						spielfeld[x-1][y] = spielfeld[x-1][y] + spielfeld[x][y];
						spielfeld[x][y] = 0;
					}	
				}
			}
		}
	}
	
	private void moveRight () {
		for(int y = 0; y < spielfeld_length; y++) {
			for(int x = 0; x < spielfeld_length; x++) {
				// Nicht letete Zahl! 
				if(y < spielfeld_length-1) {
					//Wenn untere Zahl gleich null Rücke auf
					if(spielfeld[x][y+1] == 0) {
						spielfeld[x][y+1] = spielfeld[x][y];
						spielfeld[x][y] = 0;
					//Wenn Zahl unter einen Gleich Dann Addiere
					}else if(spielfeld[x][y+1] == spielfeld[x][y]) {
						spielfeld[x][y+1] = spielfeld[x][y+1] + spielfeld[x][y];
						spielfeld[x][y] = 0;
					}	
				}
			}
		}
	}
	
	private void moveLeft () {
		for(int y = spielfeld_length-1; y > 0; y--) {
			for(int x = 0; x < spielfeld_length; x++) {
				// Nicht Erste 
				if(y > 0) {
					//Wenn obere Zahl gleich null, Rücke auf
					if(spielfeld[x][y-1] == 0) {
						spielfeld[x][y-1] = spielfeld[x][y];
						spielfeld[x][y] = 0;
					//Wenn Zahl ober einen Gleich Dann Addiere
					}else if(spielfeld[x][y-1] == spielfeld[x][y]) {
						spielfeld[x][y-1] = spielfeld[x][y-1] + spielfeld[x][y];
						spielfeld[x][y] = 0;
					}	
				}
			}
		}
	}
	
	//-----------------------
	//--- Generate Random ---
	//-----------------------
	private void generateRandom() {
		int x;
		int y;
		do {
			x = rand.randInt_inRange(0, spielfeld_length-1);
			y = rand.randInt_inRange(0, spielfeld_length-1);
		}while(!isSlootFree(x, y));
		if(rand.randInt_inRange(0, 1) == 0) {
			spielfeld[x][y] = 2;
		}else {
			spielfeld[x][y] = 4;
		}
	}
	
	//------------------------
	//--- Output SpielFeld ---
	//------------------------
	private void printSpielfeld() {
		for(int i = 0; i < spielfeld_length; i++) {
			printSpielfeld_blockLine(i);
		}
	}
	
	private void printSpielfeld_blockLine(int line) {
		//Blockline 1
		for(int i = 0; i < spielfeld_length; i++) {
			System.out.print("╔════╗ ");
		}
		System.out.print("\n");
		//Blockline 2
		for(int i = 0; i < spielfeld_length; i++) {
			System.out.print("║");
			printSpielfeld_blockInside(line, i);
			System.out.print("║ ");
		}
		System.out.print("\n");
		//Blockline 1
		for(int i = 0; i < spielfeld_length; i++) {
			System.out.print("╚════╝ ");
		}
		System.out.print("\n");
	}
	
	private void printSpielfeld_blockInside(int line, int slot) {
		switch(spielfeld[line][slot]) {
			case 0: System.out.print("    ");
				break;
			case 2: System.out.print("  2 ");
				break;
			case 4: System.out.print("  4 ");
				break;
			case 8: System.out.print("  8 ");
				break;
			case 16: System.out.print(" 16 ");
				break;
			case 32: System.out.print(" 32 ");
				break;
			case 64: System.out.print(" 64 ");
				break;
			case 128: System.out.print("128 ");
				break;
			case 256: System.out.print("256 ");
				break;
			case 512: System.out.print("512 ");
				break;
			case 1024: System.out.print("1024");
				break;
			case 2048: System.out.print("2048");
				break;
			case 4096: System.out.print("4096");
				break;
			case 8192: System.out.print("8192");
				break;
			case 16384: System.out.print(" 16k");
				break;
			case 32768: System.out.print(" 32k");
				break;
			case 65536: System.out.print(" 64k");
				break;
			default: System.out.print("Eror");
				break;
		}
	}
	
	//Ausführ Main
	public static void main(String[] args) {
		Zwei48 run = new Zwei48();
		run.main();
	}
}

//----------------
//--- Errors : ---
//----------------

//No Error-Codes