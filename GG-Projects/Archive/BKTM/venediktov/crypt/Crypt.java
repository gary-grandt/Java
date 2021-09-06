package BKTM.venediktov.crypt;

public class Crypt {

	// ----------------------
	// --- CAESER / Rot-X ---
	// ----------------------

	public String rotX_encrypt(String input, int rotationValue) {
		input = input.toUpperCase();
		rotationValue = rotationValue % 26;
		String ret = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 32) {
				ret += input.charAt(i);
			} else if ((int) input.charAt(i) + rotationValue > 90) {
				ret += (char) ((int) input.charAt(i) + rotationValue - 26);
			} else {
				ret += (char) ((int) input.charAt(i) + rotationValue);
			}
		}
		return ret;
	}

	public String rotX_decrypt(String input, int rotationValue) {
		input = input.toUpperCase();
		rotationValue = rotationValue % 26;
		String ret = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 32) {
				ret += input.charAt(i);
			} else if ((int) input.charAt(i) - rotationValue < 65) {
				ret += (char) ((int) input.charAt(i) - rotationValue + 26);
			} else {
				ret += (char) ((int) input.charAt(i) - rotationValue);
			}
		}
		return ret;
	}

	public String ceaser_encrypt(String input) {
		return rotX_encrypt(input, 3);
	}

	public String ceaser_decrypt(String input) {
		return rotX_decrypt(input, 3);
	}

	public String rotX_ASCI_encrypt(String input, int rotationValue) {
		rotationValue = rotationValue % 94;
		String ret = "";
		for (int i = 0; i < input.length(); i++) {
			if ((int) input.charAt(i) + rotationValue > 126) {
				ret += (char) ((int) input.charAt(i) + rotationValue - 94);
			} else {
				ret += (char) ((int) input.charAt(i) + rotationValue);
			}
		}
		return ret;
	}

	public String rotX_ASCI_decrypt(String input, int rotationValue) {
		rotationValue = rotationValue % 94;
		String ret = "";
		for (int i = 0; i < input.length(); i++) {
			if ((int) input.charAt(i) - rotationValue < 32) {
				ret += (char) ((int) input.charAt(i) - rotationValue + 94);
			} else {
				ret += (char) ((int) input.charAt(i) - rotationValue);
			}
		}
		return ret;
	}

	public String vigenre_encrypt(String input, String key) {
		input = input.toUpperCase();
		key = key.toUpperCase();
		String ret = "";
		for (int i = 0; i < input.length(); i++) {
			if (key.charAt(i %key.length()) < 65 || key.charAt(i %key.length()) > 90) return "!! :: Key only UpperCaseLetters or use ASCI!";

			if (input.charAt(i) == 32) {
				ret += (char) (input.charAt(i));
			} else if (input.charAt(i) + key.charAt(i %key.length()) - 65 > 90) {
				ret += (char) (input.charAt(i) + key.charAt(i %key.length()) - 90);
			} else {
				ret += (char) (input.charAt(i) + key.charAt(i %key.length()) - 65);
			}
		}
		return ret;
	}

	public String vigenre_decrypt(String input, String key) {
		input = input.toUpperCase();
		key = key.toUpperCase();
		String ret = "";
		for (int i = 0; i < input.length(); i++) {
			if (key.charAt(i %key.length()) < 65 || key.charAt(i %key.length()) > 90) return "!! :: Key only UpperCaseLetters or use ASCI!";

			if(input.charAt(i) == 32 ) {
				ret += (char) input.charAt(i);
			}else if(input.charAt(i) - (key.charAt(i %key.length()) -65) < 65) {
				ret += (char) (input.charAt(i) +25 -(key.charAt(i %key.length()) -65));
			} else {
				ret += (char) (input.charAt(i) - (key.charAt(i %key.length()) -65));
			}
		}
		return ret;
	}

	public String vigenre_ASCI_encrypt(String input, String key) {
		String ret = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) + key.charAt(i %key.length()) > 127) {
				
				System.out.println("  1: \n    : ");
				
				ret += (char) (input.charAt(i) + key.charAt(i %key.length()) - 127);
			} else {
				ret += (char) (input.charAt(i) + key.charAt(i %key.length()));
			}
		}
		return ret;
	}

	public String vigenre_ASCI_decrypt(String input, String key) {
		String ret = "";
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) - key.charAt(i %key.length()) < 0) {
				ret += (char) (input.charAt(i) +127 -key.charAt(i %key.length()));	
			} else {
				ret += (char) (input.charAt(i) - key.charAt(i %key.length()));
			}
		}
		return ret;
	}

	// --- MAIN ---
	public static void main(String[] args) {
		Crypt start = new Crypt();
		start.main();
	}

	private void main() {

		String s = "Ich bin uncodiert //!'$%&([|])=?#";
		int offset = (int) 'z';

		System.out.println(rotX_ASCI_encrypt(s, offset));
		String s2 = rotX_ASCI_encrypt(s, offset);
		System.out.println(rotX_ASCI_decrypt(s2, offset));

	}
}
