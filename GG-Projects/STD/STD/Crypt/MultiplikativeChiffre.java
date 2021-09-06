package STD.Crypt;

import STD.Math;

public class MultiplikativeChiffre {
	private Math math = new Math();

	public byte[] encrypt(byte[] text, byte key, byte zSystem) {
		byte[] output = new byte[text.length];
		if (zSystem == 26) {
			for (int i = 0; i < text.length; i++) {
				output[i] = math.modMult(text[i], key, zSystem);
			}
			return output;
		} else if (zSystem == 127) {
			for (int i = 0; i < text.length; i++) {
				output[i] = math.modMult(text[i], key, zSystem);
			}
			return output;
		} else {
			return null;

		}
	}

	public byte[] decrypt(byte[] text, int key, byte zSystem) {
		if (zSystem == 26) {

			return null;
		} else if (zSystem == 127) {
			return null;
		} else {
			return null;
		}
	}

	// Tools
	public void printArray(byte[] output) {
		if (output == null) {
			System.out.println("Array: null");
		} else {
			System.out.print("[");
			for (int i = 0; i < output.length; i++) {
				System.out.print("," + output[i]);
			}
			System.out.println("]");
		}
	}

	private void main() {
		byte[] test = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 23, 24, 25 };

		test = encrypt(test, (byte) 7, (byte) 26);
		printArray(test);

		test = encrypt(test, (byte) 15, (byte) 26);
		printArray(test);

	}

	public static void main(String[] args) {
		MultiplikativeChiffre run = new MultiplikativeChiffre();
		run.main();
	}
}
