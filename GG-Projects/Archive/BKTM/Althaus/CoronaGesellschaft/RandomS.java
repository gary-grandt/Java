package BKTM.Althaus.CoronaGesellschaft;

import java.util.Random;

public class RandomS {
	Random random;
	//random.nextInt(x-y)+y
	
	// Konstruktoren
	public RandomS() {
		random = new Random();
	}
	
	public RandomS(long randomSeed) {
		random = new Random(randomSeed);
	}
	
	public int randInt(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
	
	public double randDouble() {
		return random.nextDouble();
	}
	
	public double randDouble(double min, double max) {
		return min + (max - min) * random.nextDouble();
	}
	
	public double randMutation(double current, double mutationRange) {
		double returnValue = current;
		
		if(random.nextBoolean()) {
			returnValue -= randDouble(0, mutationRange);
		}else {
			returnValue -= randDouble(0, mutationRange);
		}
		
		if(returnValue < 0) returnValue = 0;
		if(returnValue > 1) returnValue = 1;
		
		return returnValue;
	}
}
