package STD;

import java.io.IOException;

public class Tools {
	
	// --- Clear Screen ---
	
	public void cls() {
		String penguinClearConsole = "clear";
		String windowsClearConsole = "cls";

		String os = "Windows";
		
		if(os.startsWith("Linux")){
			try {
				Runtime.getRuntime().exec(penguinClearConsole);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(os.startsWith("Windows")){
			try {
				Runtime.getRuntime().exec(windowsClearConsole);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void cls2() {
		try {
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void cls3() {
		for(int i = 0; i < 16; i++) System.out.println("\n\n\n\n\n\n\n\n");
	}
	
	public void clearConsol() {
		
	}
	
	public static void main(String[] arges) {
		Tools start = new Tools();
		System.out.println("Hello World");
		start.cls3();
	}
	
}
