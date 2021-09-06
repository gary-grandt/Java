package STD;

public class Output {
	
	public void endLine() {
		System.out.println();
	}
	
	public void print(String output) {
		System.out.print(output);
	}
	
	public void println(String output) {
		System.out.println(output);
	}
	
	
	public void printInput(String output, int i) {
		switch(i) {
		case 2:
			print("  ==> " +output + " : ");
			break;
		case 3: 
			print("  --> " +output+ " : ");
		}
	}
	
	
	// print Comands
	
	public void printComand(String output, int i) {
		switch(i) {
		case 0:
			printTopLine(output);
			break;
		case 1:
			printComandLine(output);
			break;
		case 2:
			printSubComandLine(output);
			break;
		case 3:
			printUnderSubComandLine(output);
		}
	}
	
	public void printTopLine(String output) {
		int length = output.length();
		print("\n-----");
		for(int i = 0; i < length; i++) print("-");
		println("-----");
		
		println(" --- "+output+" --- ");
		
		print("-----");
		for(int i = 0; i < length; i++) print("-");
		println("-----\n");
	}
	
	public void printComandLine(String output) {
		println("\n _> "+output);
	}
	
	public void printSubComandLine(String output) {
		println("  ==> "+output);
	}
	
	public void printUnderSubComandLine(String output) {
		println("  --> "+output);
	}
	
	// Other
	
	public void printError(String output) {
		println("\n<!> Error : "+output);
	}
	
	public void printWarning(String output) {
		println("\n<!> Warning : "+output);
	}
	
	
	
	// Print Array
	public void printArray(byte[] output) {
		print("[");
		for(int i = 0; i < output.length; i++) {
			print(output[i]+"");
			if((i+1) < output.length) {print(", ");}
		}
		print("]");
	}
	
	
}