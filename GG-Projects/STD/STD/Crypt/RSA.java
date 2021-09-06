package STD.Crypt;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import STD.Output;
public class RSA {
	
	public BigInteger encrypt(BigInteger e, BigInteger n, BigInteger k) {
		return k.modPow(e, n);
	}
	
	public BigInteger decrypt(BigInteger d, BigInteger n, BigInteger k) {
		return k.modPow(d, n);
	}
	
	
	public boolean isValidBlockSize(int blockSize) {
		switch(blockSize) {
		case 32: return true;
		case 64: return true;
		case 128: return true;
		case 256: return true;
		case 512: return true;
		case 1024: return true;
		case 2048: return true;
		case 4096: return true;
		}
		return false;
	}
	
	
	public BigInteger[] generateKeyPair(int blockSize) {
		BigInteger p, q, n, phi, e, d;
		Random rnd = new SecureRandom();
		
		p = BigInteger.probablePrime(blockSize/2, rnd);
		q = BigInteger.probablePrime((blockSize/2), rnd);
		
		n = p.multiply(q);
		phi = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
		
		e = BigInteger.probablePrime(blockSize-2, rnd);
		d = e.modInverse(phi);
		
		BigInteger[] keyPair = {p, q, n, phi, e, d};
		return keyPair;
	}
	
	public BigInteger[] makeBlocks(byte[] text,int blockSize) {
		int charsPerBlock = (blockSize /8) -1;
		int blocksNeeded = 0;
		BigInteger[] blocksRSA;
		for(int i = text.length; i > 0; i = i -charsPerBlock) blocksNeeded++;
		
		// --- MakeBlocks --- 
		blocksRSA = new BigInteger[blocksNeeded];
		byte[][] blockChars = new byte[blocksNeeded][charsPerBlock]; 
		
		// Split into Bocks
		int counter = 0;
		for(int i = 0; i < blocksNeeded; i++) {
			for(int j = 0; j < charsPerBlock; j++) {
				if(counter < text.length) {
					blockChars[i][j] = text[counter];
				}else {
					blockChars[i][j] = -128;
				}
				counter++;
			}
		}
		
		// Pack the Blocks
		for(int i = 0; i < blocksNeeded; i++) {
			new Output().printArray(blockChars[i]);
			blocksRSA[i] = new BigInteger(blockChars[i]);
		}
		System.out.println("");
		return blocksRSA;
	}
	
	public byte[] unmakeBlocks(BigInteger[] blocksRSA) {
		int blocksCount = blocksRSA.length;
		byte[] text;
		// RSA to Blocks
		byte[][] blocks = new byte[blocksCount][];
		for(int i = 0; i < blocksCount; i++) {
			blocks[i] = blocksRSA[i].toByteArray();
		}
		// Megre Blocks
		text = blocks[0];
		new Output().printArray(blocks[0]);
		if(blocksCount != 1) {
			for(int i = 1; i < blocksCount; i++) {
				
				new Output().printArray(blocks[i]);
				text = mergeByteArrays(text, blocks[i]);
			}
		}
		System.out.println("");
		return text;
	}
	
	private byte[] mergeByteArrays(byte[] one, byte[] tow) { 
		int length = one.length + tow.length;
		// Kick Fill elements
		for(int i = 0; i < tow.length; i++) if(tow[i] == -128) length--;
		
		byte[] output = new byte[length];
		
		for(int i = 0; i < length; i++) {
			if( i < one.length) {
				output[i] = one[i];
			}else {
				output[i] = tow[i -one.length];
			}
		}
		return output;
	}
}
