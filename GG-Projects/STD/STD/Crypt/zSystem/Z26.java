package STD.Crypt.zSystem;

import STD.Output;

public class Z26 {
	Output output = new Output();
	
	public byte charToByte(char input) {
		switch(input) {
		case 'a': case 'A':
			return 0;
		case 'b': case 'B':
			return 1;
		case 'c': case 'C':
			return 2;
		case 'd': case 'D':
			return 3;
		case 'e': case 'E':
			return 4;
		case 'f': case 'F':
			return 5;
		case 'g': case 'G':
			return 6;
		case 'h': case 'H':
			return 7;
		case 'i': case 'I':
			return 8;
		case 'j': case 'J':
			return 9;
		case 'k': case 'K':
			return 10;
		case 'l': case 'L':
			return 11;
		case 'm': case 'M':
			return 12;
			
		case 'n': case 'N':
			return 13;
		case 'o': case 'O':
			return 14;
		case 'p': case 'P':
			return 15;
		case 'q': case 'Q':
			return 16;
		case 'r': case 'R':
			return 17;
		case 's': case 'S':
			return 18;
		case 't': case 'T':
			return 19;
		case 'u': case 'U':
			return 20;
		case 'v': case 'V':
			return 21;
		case 'w': case 'W':
			return 22;
		case 'x': case 'X':
			return 23;
		case 'y': case 'Y':
			return 24;
		case 'z': case 'Z':
			return 25;
		default: 
			output.printError("Conversion: Z-26:");
			output.printComand("Can't find char in Z26!", 2);
			return -1;
		}
	}
	
	public char byteToChar(byte input) {
		switch(input) {
		case 0:
			return 'A';
		case 1:
			return 'B';
		case 2:
			return 'C';
		case 3:
			return 'D';
		case 4:
			return 'E';
		case 5:
			return 'F';
		case 6:
			return 'G';
		case 7:
			return 'H';
		case 8:
			return 'I';
		case 9:
			return 'J';
		case 10:
			return 'K';
		case 11:
			return 'L';
		case 12:
			return 'M';

		case 13:
			return 'N';
		case 14:
			return 'O';
		case 15:
			return 'P';
		case 16:
			return 'Q';
		case 17:
			return 'R';
		case 18:
			return 'S';
		case 19:
			return 'T';
		case 20:
			return 'U';
		case 21:
			return 'V';
		case 22:
			return 'W';
		case 23:
			return 'X';
		case 24:
			return 'Y';
		case 25:
			return 'Z';
		default:
			//output.printError("Conversion: Z-26:");
			//output.printComand("Can't find byte in Z26!", 2);
			return ' ';
		}
	}
	
	public byte[] stringToBytes(String inputString) {
		char[] input = inputString.toCharArray();
		byte[] output = new byte[inputString.length()];
		
		for(int i = 0; i < inputString.length(); i++) {
			if(input[i] != ' ') {
				output[i] = charToByte(input[i]);
			}
		}
		
		return output;
	}
	
	public String bytesToString(byte[] input) {
		String output = "";
		
		for(int i = 0; i < input.length; i++) {
			output += byteToChar(input[i]);
		}
		
		return output;
	}
	
}
