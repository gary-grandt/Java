package ggCrypt;

import java.math.BigInteger;

import STD.Input;
import STD.Output;

public class Terminal {
	// --- Variables ---
	private boolean end = false;
	private String in;

	// Objects
	private Logic logic = new Logic();

	private Input input = new Input();
	private Output output = new Output();

	// --- Methodes ---

	private void main() {
		output.printComand("GG-Crypt", 0);

		while (!end) {
			output.printComandLine("--- Pleas enter your input! ---");
			output.printSubComandLine("Z-System : " + logic.getZSystemName());
			output.printSubComandLine("Chiffre  : " + logic.getChiffreString());
			// TODO //output.printSubComandLine("KeyList  : " + logic.getKeyList_String());
			output.endLine();
			output.print(" _> ");

			in = input.in();
			verarbeitung(in);

		}
	}

	private void verarbeitung(String in) {
		switch (in) {
		case "-1":
		case "end":
			end = true;
			break;
		case "0":
		case "00":
		case "help":
			help();
			break;
		case "1":
		case "01":
		case "zsystem":
			changeZSystem();
			break;
		case "2":
		case "02":
		case "clear":
			clearSeesion();
			break;
		case "3":
		case "03":
		case "load":
			loadSeesion();
			break;
		case "4":
		case "04":
		case "save":
			saveSeesion();
			break;
		case "5":
		case "05":
		case "input":
			inputSeesion();
			break;
		case "6":
		case "06":
		case "autoEncrypt":
			autoEncrypt();
			break;
		case "7":
		case "07":
		case "autoDecrypt":
			autoDecrypt();
			break;
		case "8":
		case "08":
		case "changePath":
			changePath();
			break;
		case "9":
		case "09":
		case "encrypt":
			encrypt();
			break;
		case "10":
		case "decrypt":
			decrypt();
			break;
		default:
			output.printError("Invalid Input!");
			output.printComand("00 : help ", 2);
		}
	}

	// Methodes

	// 00 - help
	private void help() {
		output.printComand("Help : ", 1);
		output.printComand("-1 end", 2);
		output.printComand("00 Help", 2);
		output.printComand("01 Change Z-System", 2);
		output.printComand("02 Clear Session", 2);
		output.printComand("03 >Load Session", 2);
		output.printComand("04 >Save Session", 2);
		output.printComand("05 Input Session", 2);
		output.printComand("06 Auto Encrypt File", 2);
		output.printComand("07 Auto Decrypt File", 2);
		output.printComand("08 Change Path", 2);
		output.printComand("09 Encrypt", 2);
		output.printComand("10 Decrypt", 2);
	}
	
	// 01 - Change System
	private void changeZSystem() {
		output.printComand("Change System", 1);
		output.printComand("Z-26", 2);
		output.printComand("Z-ASCI",2);
		
		output.printInput("",3);
		byte newSystem = input.inByte_com((byte)26, (byte)127);
		if(logic.canChangeZSystem(newSystem)) {
			logic.changeZSystem(newSystem);
		}else {
			output.printError("Invalid ZSystem!");
		}
	}
	
	// 02 - Clear Seesion
	private void clearSeesion() {
		output.printComand("Did you really want to clear the Seesion? (y/n)", 1);
		if (input.inBoolean_com()) {
			logic.clear();
		}
	}

	// 03 - Load Seesion
	private void loadSeesion() {
		output.printComand("Coming sone!", 1);
	}

	// 04 - Save Seesion
	private void saveSeesion() {
		output.printComand("Coming sone!", 1);
	}

	// 05 - Input Seesion
	private void inputSeesion() {
		output.printComand("Plaese enter your Text : ", 1);
		output.print(" ==>");
		logic.input(input.in());
	}

	// 06 - Auto Encrypt File
	private void autoEncrypt() {
		output.printComand("Coming sone!", 1);
	}

	// 07 - Auto Decrypt File
	private void autoDecrypt() {
		output.printComand("Coming sone!", 1);
	}

	// 08 - Change Path
	private void changePath() {
		output.printComand("Coming sone!", 1);
	}

	// 09 - Encrypt
	private void encrypt() {
		output.printComand("Encrypte : ", 1);
		output.endLine();
		output.printComand("-1 BreakUp", 2);
		// output.printComand("00 Diffie-Hellman Key-Exchange",2);
		// output.endLine();
		output.printComand("01 Cesar / Rot-X", 2);
		output.printComand("02 Vigenere", 2);
		output.printComand("03 Multiplikative Chiffre", 2);
		// output.printComand("04 Polybios",2);
		// output.printComand("05 MegaBuck",2);
		output.endLine();
		// output.printComand("06 Bifid Chiffre",2);
		// output.printComand("07 Playfair",2);
		// output.printComand("08 Nihilisten-Subsrirution",2);
		// output.printComand("09 Nihilisten-Transposition",2);
		// output.printComand("10 Hill",2);
		output.printComand("11 RSA", 2);
		output.endLine();
		output.print("  ==> ");
		byte in = input.inByte_com((byte) -1, (byte) 11);
		switch (in) {
		case -1:
			return;
		case 00:
			return;

		case 1:
			encryptCesar();
			break;
		case 2:
			encryptVigenere();
			break;
		case 3:
			//encryptMultiplikativeChiffre();
		case 4:
			return;
		case 5:
			return;

		case 6:
			return;
		case 7:
			return;
		case 8:
			return;
		case 9:
			return;
		case 10:
			return;

		case 11:
			encryptRSA();
			break;
		}
	}

	// 10 - Decrypt
	private void decrypt() {
		output.printComand("Decrypte : ", 1);
		output.endLine();
		output.printComand("-1 BreakUp", 2);
		output.printComand("00 Diffie-Hellman Key-Exchange", 2);
		// output.endLine();
		output.printComand("01 Cesar / Rot-X", 2);
		output.printComand("02 Vigenere", 2);
		output.printComand("03 Multiplikative Chiffre", 2);
		// output.printComand("04 Polybios",2);
		// output.printComand("05 MegaBuck",2);
		output.endLine();
		// output.printComand("06 Bifid Chiffre",2);
		// output.printComand("07 Playfair",2);
		// output.printComand("08 Nihilisten-Subsrirution",2);
		// output.printComand("09 Nihilisten-Transposition",2);
		// output.printComand("10 Hill",2);
		output.printComand("11 RSA", 2);
		output.endLine();
		output.print("  ==> ");
		byte in = input.inByte_com((byte) -1, (byte) 11);
		switch (in) {
		case -1:
			return;
		case 00:
			return;

		case 1:
			decryptCesar();
			break;
		case 2:
			decryptVigenere();
			break;
		case 3:
			//decryptMultiplikativeChiffre();
		case 4:
			return;
		case 5:
			return;

		case 6:
			return;
		case 7:
			return;
		case 8:
			return;
		case 9:
			return;
		case 10:
			return;

		case 11:
			//decryptRSA();
			break;
		}
	}
	
	
	// --- Encrypt / Decrypt --- 
	
	// Cesar
	private void encryptCesar() {
		output.printComand("Encrypt : Cesar : ",1);
		output.printInput("Key", 2);
		logic.encryptCesar(input.inInt());
	}
	private void decryptCesar() {
		output.printComand("Decrypt : Cesar : ",1);
		output.printInput("Key", 2);
		logic.decryptCesar(input.inInt());
	}
	
	// Vigenere
	private void encryptVigenere() {
		output.printComand("Encrypt : Vigenere : ",1);
		output.printInput("Key", 2);
		logic.encryptVigenere(input.in());
	}
	private void decryptVigenere() {
		output.printComand("Decrypt : Vigenere : ",1);
		output.printInput("Key", 2);
		logic.decryptVigenere(input.in());
	}
	
	
	
	
	
	// RSA
	private void encryptRSA() {
		output.printComand("Encrypt : RSA : ",1);
		output.printWarning("This will Change the ZSystem to H7X (Hex-7Bit) you can't encrypt anymore after this! (-1 for BreakUP)");
		int blockSize;
		do {
			output.print(" ==> BockSize (min 32, max 4096) : ");
			blockSize = input.inInt();
			if(blockSize == -1) return;
		}while(!logic.isValidRSA_BlockSize(blockSize));
		
		// Change ZSystem
		//logic.changeZSystem((byte) -128);
		
		// Genrate Key Pair?
		BigInteger[] keyPair;
		output.printInput("Genreate Key-Pair? (yes/no)", 2);
		if(input.inBoolean_com()) {
			keyPair = logic.gerateKeyPair(blockSize);
			
			output.printComand("New RSA Key-Pair : ", 2);
			output.printComand("p = "+keyPair[0].toString() 
							+" * q = "+keyPair[1].toString() 
							+" ==> n "+keyPair[2].toString() 
							+" --> phi = "+keyPair[3].toString(), 3);
			output.printComand("e : "+keyPair[4].toString(), 3);
			output.printComand("d : "+keyPair[5].toString(), 3);
			
			logic.encryptRSA(blockSize, keyPair[4], keyPair[2]);
			
			
			logic.changeZSystem((byte) -128);
			System.out.println(logic.getChiffreString());
			logic.changeZSystem((byte) 26);
			
			logic.encryptRSA(blockSize, keyPair[5], keyPair[2]);
			
			System.out.println(logic.getChiffreString());
		}else {
			
		}
	}
	

	// Public Static Main
	public static void main(String[] args) {
		Terminal run = new Terminal();
		run.main();
	}

}
