package BKTM.Althaus.CoronaGesellschaft;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class PrintSimulation {
	// Variables
	private Mensch[][] population;
	private int round;
	private int m = 1;
	
	public PrintSimulation (Mensch[][] population, int round) {
		this.population = population;
		this.round = round;
	}
	
	public void print() {
		BufferedImage bufferedImage = new BufferedImage(population.length *m, population[0].length *m, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D graphics2D = bufferedImage.createGraphics();
		graphics2D.setColor(Color.white);
		graphics2D.fillRect(0, 0, population.length *m, population[0].length *m);
		
		// drow Population
	    for(int x = 0; x < population.length *m; x = x +m) {
	    	for(int y = 0; y < population.length *m; y = y +m) {
	    		graphics2D.setPaint(Color.white);
	    		
	    		if(population[x/m][y/m].isTot()) {
	    			graphics2D.setPaint(Color.black);
	    		}else if(population[x/m][y/m].isActive()) {
	    			graphics2D.setPaint(Color.red);
	    		}
	    		
	    		graphics2D.fillRect(x, y, x +m, y +m);
		    }
	    }
	    
	    
		String path = "e:\\Simulation\\SimulationRound_" +(round+1) +".PNG";
	    try {
			ImageIO.write(bufferedImage, "PNG", new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
}
