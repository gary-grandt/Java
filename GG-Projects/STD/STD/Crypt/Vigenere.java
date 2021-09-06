package STD.Crypt;

import STD.Math;

public class Vigenere {
	private Math math = new Math();
	
	public byte[] encrypt(byte[] text, byte[] key, byte zSystem) {
		byte currentKeyChar;
		if(zSystem == 26) {
			for(int i = 0; i < text.length; i++) {
				currentKeyChar = key[math.mod(i, key.length)];
				
				text[i] = math.mod(text[i]+currentKeyChar, 26);
				
			}
			return text;
		}else {
			return null;
		}
	}
	
	public byte[] decrypt(byte[] text, byte[] key, byte zSystem) {
		byte currentKeyChar;
		if(zSystem == 26) {
			for(int i = 0; i < text.length; i++) {
				currentKeyChar = key[math.mod(i, key.length)];
				
				text[i] = math.mod(text[i]-currentKeyChar, 26);
				
			}
			return text;
		}else {
			return null;
		}
	}
}
