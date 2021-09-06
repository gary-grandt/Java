package BKTM.venediktov.crypt;

import java.util.Scanner;

public class TERM {
	//Variables
	private boolean end = false;
	private boolean enDeCrypt;
	private int choose;
	//Objects
	private Scanner scanner = new Scanner(System.in);
	
	private void main() {
		System.out.println("--- CryptTerminal : ---");
		
		while(!end) {
			System.out.println("Please choose the Crypt-Algo : ");
			
			System.out.println("(1 Ceaser, 2 RotX, RotX-ASCI)");
			choose = scanner.nextInt();
			
			System.out.println("Encrypt = ture; Decrypt = false;");
			enDeCrypt = scanner.nextBoolean();
			if(enDeCrypt) {
				switch(choose) {
				case 1: 
					break;
				case 2:
					break;
				case 3: 
					break;
				default: System.out.println("Error : No Cryp-Algo choosen!");
				}
			}else {
				switch(choose) {
				case 1: 
					break;
				case 2:
					break;
				case 3: 
					break;
				default: System.out.println("Error : No Cryp-Algo choosen!");
				}
			}
			System.out.println("Did you want to end? (true/false)");
			end = scanner.nextBoolean();
		}
		System.out.println("- CryptTerminal End -");
	}
	
	public static void main(String[] arges) {
		TERM start = new TERM();
		start.main();
	}
}
