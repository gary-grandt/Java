package STD;
import java.util.Scanner;

public class Input {
	private Scanner scanner;
	
	//default Boolean Input
	public boolean inBoolean() {
		boolean no_mistakes = false;
		boolean input_bool = false;
		do {
			try {
				scanner = new Scanner(System.in);
				input_bool = scanner.nextBoolean();
				no_mistakes = true;
			}catch (Exception e){
				System.out.println("Pleas enter: 'true' or 'false' ");
				no_mistakes = false;
			}
		}while(!no_mistakes);
		return input_bool;
	}
	
	//Boolean Input mit Ja / Nein 
	public boolean inBoolean_com() {
		String input_String_for_bool = " ";
		do {
			try {
				scanner = new Scanner(System.in);
				input_String_for_bool = scanner.next();
				
				if(input_String_for_bool.equals("Ja") || input_String_for_bool.equals("ja") || input_String_for_bool.equals("j")) {
					return true;
				}else if(input_String_for_bool.equals("Nein") || input_String_for_bool.equals("nein") || input_String_for_bool.equals("n")) {
					return false;
				}
				if(input_String_for_bool.equals("Yes") || input_String_for_bool.equals("yes") || input_String_for_bool.equals("y")) {
					return true;
				}else if(input_String_for_bool.equals("No") || input_String_for_bool.equals("no") || input_String_for_bool.equals("n")) {
					return false;
				}
			}catch (Exception e){
				System.out.println("Please enter: 'Ja/Nein' or 'Yes/no' (j/n || y/n) ");
			}
		}while(true);
	}
	
	//Stander Byte Input
	public byte inByte() {
		boolean no_mistakes = false;
		byte input_byte = -1;
		do {
			try {
				scanner = new Scanner(System.in);
				input_byte = scanner.nextByte();
				no_mistakes = true;
			}catch (Exception e) {
				System.out.println("Error: Please ente1 a number!");
			}
		}while(!no_mistakes);
		return input_byte;
	}
	
	//Integer Input mit Min / Max
		public byte inByte_com(byte min, byte max) {
			boolean no_mistakes = false;
			byte input_byte = -1;
			do {
				try {
					scanner = new Scanner(System.in);
					input_byte = scanner.nextByte();
					if(input_byte >= min && input_byte <= max) {
						no_mistakes = true;
					}else {
						System.out.println("Please enter input with: ");
						System.out.println("Min: " + min);
						System.out.println("Max: " + max);
					}
				}catch(Exception e) {
					System.out.println("Error: Pleas enter a Number!");
				}
			}while(!no_mistakes);
			return input_byte;
		}
	
	//Standert Double Input
	public double inDouble() {
		boolean no_mistakes = false;
		double input_double = -1;
		do {
			try {
				scanner = new Scanner(System.in);
				input_double = scanner.nextFloat();
				no_mistakes = true;
			}catch(Exception e){
				System.out.println("Error: Plaes enter a Number!");
			}
		}while(!no_mistakes);
		return input_double;
	}
	
	//Double Input with Min / Max
	public double inDouble_com(double min, double max) {
		boolean no_mistakes = false;
		double input_double = -1;
		do {
			try {
				scanner = new Scanner(System.in);
				input_double = scanner.nextFloat();
				if(input_double >= min && input_double <= max) {
					no_mistakes = true;
				}else {
					System.out.println("Please enter input with: ");
					System.out.println("Min: " + min);
					System.out.println("Max: " + max);
				}
			}catch(Exception e){
				System.out.println("Error: Plaes enter a Number!");
			}
		}while(!no_mistakes);
		return input_double;
	}
	
	//Standert Float Input
	public float inFloat() {
		boolean no_mistakes = false;
		float input_float = -1;
		do {
			try {
				scanner = new Scanner(System.in);
				input_float = scanner.nextFloat();
				no_mistakes = true;
			}catch(Exception e){
				System.out.println("Error: Plaes enter a Number!");
			}
		}while(!no_mistakes);
		return input_float;
	}
	
	//Float Input with Min / Max
	public float inFloat_com(float min, float max) {
		boolean no_mistakes = false;
		float input_float = -1;
		do {
			try {
				scanner = new Scanner(System.in);
				input_float = scanner.nextFloat();
				if(input_float >= min && input_float <= max) {
					no_mistakes = true;
				}else {
					System.out.println("Please enter input with: ");
					System.out.println("Min: " + min);
					System.out.println("Max: " + max);
				}
			}catch(Exception e){
				System.out.println("Error: Plaes enter a Number!");
			}
		}while(!no_mistakes);
		return input_float;
	}
	
	//Stander Integer Input
	public int inInt() {
		boolean no_mistakes = false;
		int input_int = -1;
		do {
			try {
				scanner = new Scanner(System.in);
				input_int = scanner.nextInt();
				no_mistakes = true;
			}catch (Exception e) {
				System.out.println("Error: Please ente1 a number!");
			}
		}while(!no_mistakes);
		return input_int;
	}
	
	//Integer Input mit Min / Max
	public int inInt_com(int min, int max) {
		boolean no_mistakes = false;
		int input_int = -1;
		do {
			try {
				scanner = new Scanner(System.in);
				input_int = scanner.nextInt();
				if(input_int >= min && input_int <= max) {
					no_mistakes = true;
				}else {
					System.out.println("Please enter input with: ");
					System.out.println("Min: " + min);
					System.out.println("Max: " + max);
				}
			}catch(Exception e) {
				System.out.println("Error: Pleas enter a Number!");
			}
		}while(!no_mistakes);
		return input_int;
	}
	
	//String Input
	public String in() {
		boolean no_mistakes = false;
		String input_string = null;
		do {
			try {
				scanner = new Scanner(System.in);
				input_string = scanner.next();
				no_mistakes = true;
			}catch(Exception e) {
				System.out.println("Error: !");
			}
		}while(!no_mistakes);
		return input_string;
	}
	
	public static void main(String[] arges) {
		Input ausfüren = new Input();
		System.out.println(ausfüren.inInt());
	}
	
}

