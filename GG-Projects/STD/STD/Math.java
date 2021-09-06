package STD;

import java.math.BigInteger;

public class Math {

	
	// Prime 
	public boolean isPrime(int input) {
		BigInteger probPrime = BigInteger.valueOf(input);
		return probPrime.isProbablePrime(1);
	}
	
	
	
	// Mod 
	public byte mod(int i, int m) {
		while(i < 0) {
			i = i+m;
		}
		i = (byte) (i%m);
		return (byte)i;
	}
	
	public byte modMult(byte kZahl, byte iZahl, byte mod) {
		BigInteger k = BigInteger.valueOf(kZahl);
		BigInteger i = BigInteger.valueOf(iZahl);
		BigInteger m = BigInteger.valueOf(mod);
		BigInteger c = k.multiply(i).mod(m);
		byte[] output = c.toByteArray();
		return output[0];
	}
	
	
	public byte modInverse(byte in, byte mod) {
		BigInteger i = BigInteger.valueOf(in);
		BigInteger m = BigInteger.valueOf(mod);
		BigInteger inverse = i.modInverse(m);
		byte[] output = inverse.toByteArray();
		return output[0];
	}
	
	public byte modInverse_z26(int input) {
		switch(input) {
			case 1: return 1;
			case 3: return 9;
			case 5: return 21;
			case 7: return 15;
			case 9: return 3;
			case 11: return 19;
			case 15: return 7;
			case 17: return 23;
			case 19: return 11;
			case 21: return 5;
			case 23: return 17;
			case 25: return 25;
			default: return -1;
		}	
	}
	
	public byte[][] modInverse() {
		byte[][] array =  { {23, 14, 8}, {4, 15, 11}, {13, 7, 8} };
		
		byte arrayLength = (byte)array.length;
		
		// Generate inverse Array
		byte[][] inverseArray = new byte[arrayLength][arrayLength];
		for(byte x = 0; x < arrayLength; x++) {
			for(byte y = 0; y < arrayLength; y++) {
				if(x == y) {
					inverseArray[x][y] = 1;
				}else {
					inverseArray[x][y] = 0;
				}
			}
		}
		
		// Generate the Inverse
		for(byte x = 0; x < arrayLength; x++) {
			// Sysouts
			System.out.println("\nStep : "+x);
			printArrays(array, inverseArray);
			
			// Multiply with Inverse of x=y current Line
			byte inverse = modInverse_z26(array[x][x]);
			System.out.println("\n _> Multiplye with inverse of(x : "+x+"; y : "+x+"), inverse : "+inverse);
			for(byte y = x; y < arrayLength; y++) {
				array[x][y] = mod(array[x][y] *inverse, (byte)26);
			}
			for(byte y = 0; y <= x; y++) {
				inverseArray[x][y] = mod(inverseArray[x][y] *inverse, (byte)26);
			}
			printArrays(array, inverseArray);
			
			
			System.out.println("\n _> Subtract Line("+x+") to get to 0: ");
			for(byte line = 0; line < arrayLength; line++) {
				if(line == x) continue;
				
				byte subValue = array[line][x];
				System.out.println("  ==> Line: "+line+" - ("+subValue+" * Line: "+x+")");
				
				for(byte y = x; y < arrayLength; y++) {
					array[line][y] = mod(array[line][y] -(subValue*array[x][y]), (byte)26);
				}
				for(byte y = 0; y <= x; y++) {
					inverseArray[line][y] = mod(inverseArray[line][y] -(subValue*inverseArray[x][y]), (byte)26);
					
				}
			}
			printArrays(array, inverseArray);
			
		}
		
		
		
		return null;
	}
	
	public void printArray(byte array[][]) {
		byte arrayLength = (byte) array.length;
		
		for(byte x = 0; x < arrayLength; x++) {
			for(byte y = 0; y < arrayLength; y++) {
				if(array[x][y] < 10) {
					System.out.print("| " + array[x][y] +" ");
				}else if(array[x][y] < 100) {
					System.out.print("| " + array[x][y]);
				}else {
					System.out.print("|" + array[x][y]);
				}
			}
			System.out.print("|\n");
		}
	}
	
	public void printArrays(byte array_1[][], byte array_2[][]) {
		byte arrayLength = (byte) array_1.length;
		
		for(byte x = 0; x < arrayLength; x++) {
			System.out.print("    ");
			for(byte y = 0; y < arrayLength; y++) {
				if(array_1[x][y] < 10) {
					System.out.print("| " + array_1[x][y] +" ");
				}else if(array_1[x][y] < 100) {
					System.out.print("| " + array_1[x][y]);
				}else {
					System.out.print("|" + array_1[x][y]);
				}
			}
			System.out.print(" |");
			for(byte y = 0; y < arrayLength; y++) {
				if(array_2[x][y] < 10) {
					System.out.print("| " + array_2[x][y] +" ");
				}else if(array_2[x][y] < 100) {
					System.out.print("| " + array_2[x][y]);
				}else {
					System.out.print("|" + array_2[x][y]);
				}
			}
			System.out.print("|\n");
		}
	}
	
	public static void main(String[] args) {
		Math run = new Math();
		run.modInverse();
	}
	
}
