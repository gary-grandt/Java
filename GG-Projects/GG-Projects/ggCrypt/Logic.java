package ggCrypt;

import java.math.BigInteger;

import STD.Crypt.*;
import STD.Crypt.zSystem.ZSystem;
import STD.Output;

public class Logic {
	
	// Objects
	private ZSystem zsystem = new ZSystem();
	
	
	// --- ZSystem --- 
	public void input(String input) {zsystem.input(input);}
	public void clear() {zsystem.clear();}
	
	public byte[] textToBytes(String text) {return zsystem.textToBytes(text);}
	
	// Chane / Get - System
	public boolean canChangeZSystem(byte newSystem) {return zsystem.canChangeSystem(newSystem);}
	public void changeZSystem(byte newSystem) {zsystem.changeSystem(newSystem);}
	public byte getZSystem() {return zsystem.getSystem();}
	public String getZSystemName() {return zsystem.getSystemName();}
	
	// Get / Set - Chiffre
	public byte[] getChiffre() {return zsystem.getChiffre();}
	public String getChiffreString() {return zsystem.getChiffreString();}
	public void setChiffre(byte[] newChiffre) {zsystem.setChiffre(newChiffre);}
	public void setChiffreString(String newChiffre) {zsystem.setChiffreString(newChiffre);}
	
	
	// --- Encrypt / Decrypt --- 
	
	// Cesar 
	public void encryptCesar(int key) {
		setChiffre(new Cesar().encrypt(getChiffre(), key, getZSystem()));
	}
	public void decryptCesar(int key) {
		setChiffre(new Cesar().decrypt(getChiffre(), key, getZSystem()));
	}
	
	// Vigenere
	public void encryptVigenere(String key) {
		setChiffre(new Vigenere().encrypt(getChiffre(), textToBytes(key), getZSystem()));
	}
	public void decryptVigenere(String key) {
		setChiffre(new Vigenere().decrypt(getChiffre(), textToBytes(key), getZSystem()));
	}
	
	
	// RSA
	public void encryptRSA(int blockSize, BigInteger e, BigInteger n) {
		RSA rsa = new RSA();
		BigInteger[] blocksRSA = makeBlocksRSA(blockSize);
		
		System.out.println("\nEncrypt RSA -->Debug!");
		for(int i = 0; i < blocksRSA.length; i++) {
			BigInteger k = blocksRSA[i];
			System.out.println("K1 : "+k);
			k = rsa.encrypt(e, n, k);
			System.out.println("K2 : "+k+"\n");
			blocksRSA[i] = k;
		}
		
		setChiffre(unmakeBlocksRSA(blocksRSA));
	}
	
	public void decryptRSA() {
		
	}
	
	public boolean isValidRSA_BlockSize(int blockSize) {
		return new RSA().isValidBlockSize(blockSize);
	}
	public BigInteger[] gerateKeyPair(int blockSize) {
		return new RSA().generateKeyPair(blockSize);
	}
	
	public BigInteger[] makeBlocksRSA(int blockSize) {
		return new RSA().makeBlocks(getChiffre(), blockSize);
	}
	public byte[] unmakeBlocksRSA(BigInteger[] blocksRSA) {
		return new RSA().unmakeBlocks(blocksRSA);
	}
	
	private void main() {
		int blockSize = 32;
		byte[] text = {-128};
		new Output().printArray(text);
		text = unmakeBlocksRSA(new RSA().makeBlocks(text, blockSize));
		new Output().printArray(text);
		
		
	}
	
	public static void main(String[] args) {new Logic().main();}
}
