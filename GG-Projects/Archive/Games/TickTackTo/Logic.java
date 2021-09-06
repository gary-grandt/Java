package Games.TickTackTo;



public class Logic {

	// Varialbes
	private GUI gui;
	
	private int activePlayer = 1;
	private int anzahlPlayer = 2;
	private int[][] playGround = new int[3][3];

	// Konstructoren
	public Logic() {
		setGui(null);
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				playGround[x][y] = -1;
			}
		}
	}
	public Logic(GUI gui) {
		this.setGui(gui);
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				playGround[x][y] = -1;
			}
		}
	}

	// Methodes
	public boolean checkWin() {
		boolean returnBoolean = false;
		for (int x = 0; x < 3; x++) {
			if(playGround[x][0] == playGround[x][1] && playGround[x][1] == playGround[x][2]) {
				if(playGround[x][0] != -1 && playGround[x][1] != -1 && playGround[x][2] != -1) returnBoolean = true;
			}
		}

		for (int y = 0; y < 3; y++) {
			if(playGround[0][y] == playGround[1][y] && playGround[1][y] == playGround[2][y]) {
				if(playGround[0][y] != -1 && playGround[1][y] != -1 && playGround[2][y] != -1) returnBoolean = true;
			}
		}
		
		if(playGround[0][0] == playGround[1][1] && playGround[1][1] == playGround[2][2]) {
			if(playGround[0][0] != -1 && playGround[1][1] != -1 && playGround[2][2] != -1) returnBoolean = true;
		}
		if(playGround[0][2] == playGround[1][1] && playGround[1][1] == playGround[2][0]) {
			if(playGround[0][2] != -1 && playGround[1][1] != -1 && playGround[2][0] != -1) returnBoolean = true;
		}
		return returnBoolean;
	}
	
	public int buttonPress(int x, int y) {
		playGround[x][y] = activePlayer;
		return activePlayer;
	}
	
	public int getActivePlayer() {
		return activePlayer;
	}
	
	public void turn() {
		if(activePlayer == anzahlPlayer) {
			activePlayer = 1;
		}else {
			activePlayer++;
		}
	}
	public GUI getGui() {
		return gui;
	}
	public void setGui(GUI gui) {
		this.gui = gui;
	}
	
}
