package STD.Crypt;

import STD.Math;

public class Cesar {
	Math math = new Math();
	
	public byte[] encrypt(byte[] text, int inputKey, byte zSystem) {
		byte key;
		key = math.mod(inputKey, (byte)zSystem);
		
		for(int i = 0; i < text.length; i++) {
			text[i] = math.mod(text[i]+key, (byte)zSystem);
		}
		
		return text;
	}
	
	public byte[] decrypt(byte[] text, int inputKey, byte zSystem) {
		byte key;
		key = math.mod(inputKey, (byte)zSystem);
		
		for(int i = 0; i < text.length; i++) {
			text[i] = math.mod(text[i]-key, (byte)zSystem);
		}
		
		return text;
	}
}
