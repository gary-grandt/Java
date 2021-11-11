package GGcrypt.fileManagement;

import java.io.File;
import java.io.Reader;

public class cryptReader {
	
	public cryptReader(String path) {
		file = new File(path);
	}
	
	// Variables
	private File file;
	private Reader reader;
	
	
	
	
	
	
	// Main for Testing
	private void main() {
		
	}
	
	public static void main(String[] args) {
		cryptReader run = new cryptReader("");
		run.main();
	}
	
}
