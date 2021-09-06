package BKTM.Althaus.CoronaSchule;

import java.util.Random;
import java.util.Scanner;

public class Test {
	
	double p;
	double a;
	
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);
	
	private void main() {
		
		p = random.nextDouble();
		System.out.println(p);
		
		
		
		System.out.println(0.01 > p);
		
	}
	
	
	public static void main(String[] args) {
		Test run = new Test();
		run.main();
	}
}
