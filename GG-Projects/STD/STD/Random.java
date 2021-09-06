package STD;

public class Random {
	java.util.Random random = new java.util.Random();
	//random.nextInt(x-y)+y
	
	public int randInt_inRange(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
}
