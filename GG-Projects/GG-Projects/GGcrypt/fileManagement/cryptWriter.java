package GGcrypt.fileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class cryptWriter {
	
	public cryptWriter(String path) {
		file = new File(path);
	}
	
	// Variables
	private File file;
	private PrintWriter writter;
	
	
	
	private void main() {
		try {
			writter = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		cryptWriter run = new cryptWriter("");
		run.main();
	}
}
