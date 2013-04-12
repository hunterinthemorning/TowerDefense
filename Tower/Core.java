import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;

import javax.swing.JFrame;


public abstract class Core extends JFrame{
	private boolean running, runMenu, paused, start = false;
	DrawPane panel;
	TurretPane turretPanel;
	
	Core(){
		
	}
	
	public void stop(){
		running = false;
	}
	
	public void exitMenu(){
		panel.runMenu();
		start();
	}
	
	public void run(){
		try {
			init();
			do{
				Thread.sleep(100);
			}while(!start);
			gameLoop();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public boolean isMenu(){
		return start;
	}
	
	public void start(){
		start = true;
	}
	public void init(){
				
		running = true;
		panel = new DrawPane();
		turretPanel = new TurretPane();
		runMenu = true;
		paused = false;
	}
	
	public void gameLoop(){
		long startTime = System.currentTimeMillis();
		long cumTime = startTime;
		
		while(running){
			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;
			
			update(timePassed);
			
			panel.repaint();
			turretPanel.repaint();
			
			try{
				Thread.sleep(20);
			}catch(Exception e){
				System.out.println("Problem "+e);
			}
			
		}
	}
	
	public abstract void drawPauseMenu();
	
	//update animation
	public void update(long timePassed){
	//Tower_Controler.update();
	}
		
	//draw to screen
	public abstract void draw();
	
}

