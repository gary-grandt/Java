package STD.Crypt.zSystem;

import STD.Output;

public class ZSystem {
	/*
	 * In GG-Crypt werden die Zeichen intern als Bytes gespeichert.
	 * Dies ist ausreichend, da selbst bei der verwendung von ASCI (128 Zeichen),
	 * bei der Verschlüsselung nie höhere werte als 256 erreicht werden.
	 */
	
	// --- Variables ---
	
	private byte system;
	private byte[] chiffre;
	
	// Objects
	private Z26 z26 = new Z26();
	private ZH7X zH7X = new ZH7X();
	private ZASCI zASCI = new ZASCI();
	
	
	// --- Meathodes ---
	public void input(String input) {
		switch(system) {
		case 26: chiffre = z26.stringToBytes(input);
			break;
		case 127: chiffre = zASCI.stringToBytes(input);
			break;
		case -128: new Output().printError("Comeing sone!");
			break;
		
		default: new Output().printError("ZSystem : input() : Can't find choosenZSystem!");
		}
	}
	
	public void clear() {
		chiffre = null;
	}
	
	// Text --> Bytes Exchange
	public byte [] textToBytes(String text) {
		switch(system) {
		case 26: return z26.stringToBytes(text);
		case 127: return zASCI.stringToBytes(text);
		case -128: new Output().printError("Comeing sone!");
		
		default: new Output().printError("ZSystem : input() : Can't find choosenZSystem!");
			return null;
		}
	}
	
	
	// Change System
	public boolean canChangeSystem(byte newSystem) {
		switch(newSystem) {
		case 26: return true; //TODO
		
		case 127: return true; //TODO
		case -128: return true; //TODO
		default: return false; // No Valid System found --> return false; 
		}
	}
	
	public void changeSystem(byte newSystem) {
		if(!canChangeSystem(newSystem)) {
			new Output().printError("ZSystem : Can't change System!");
		}else {
			this.system = newSystem;
		}
	}
	
	
	
	// Geter / Seter
	public byte getSystem() {
		return system;
	}
	public String getSystemName() {
		switch(system) {
		case 26: return "Z26";
		case 127: return "ASCI";
		case -128: return "H7X";
		default: return "Set Valid ZSystem!";
		}
	}
	
	public byte[] getChiffre() {
		return chiffre;
	}
	public String getChiffreString() {
		if(chiffre == null) {return "";}
		
		switch(system) {
		case 26: return z26.bytesToString(chiffre);
		case 127: return zASCI.bytesToString(chiffre);
		case -128: return zH7X.bytesToString(chiffre);
		
		default: new Output().printError("ZSystem : getChiffreString() : Can't find chossen ZSystem!");
		return "";
		}
	}
	public void setChiffre(byte[] newChiffre) {
		this.chiffre = newChiffre;
	}
	public void setChiffreString(String newChiffre) {
		switch(system) {
		case 26: this.chiffre = z26.stringToBytes(newChiffre);
			break;
		case 127: this.chiffre = zASCI.stringToBytes(newChiffre);
		case -128: new Output().printError("Comeing sone!");
		
		default: new Output().printError("ZSystem : setChiffreString() : Can't find chossen ZSystem!");
		}
	}
	
	
	
	
	// Testing
	private void main() {
		System.out.println(zH7X.bytesToString(chiffre));
		System.out.println(zH7X.byteToString((byte)255));
	}
	
	public static void main(String[] args) {
		ZSystem test = new ZSystem();
		test.main();
	}
}