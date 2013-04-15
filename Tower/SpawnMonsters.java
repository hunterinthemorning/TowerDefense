import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class SpawnMonsters implements ActionListener {
	Timer timer = null;
	static int health = 100;
	private int count = 0;
	int x, y; //Change this to represent the top right corner of the map
	int startingHealth = 100;
	
	public void start(){
		timer = new Timer(1000, this);
		timer.setInitialDelay(1000);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
            Monster_Controller.spawnMonster(Data.getStartX(), Data.getStartY(), startingHealth, 5);
			System.out.println(Data.getStartX()+" "+ Data.getStartY());
//			spawnMonster(0,200,startingHealth*level,5);
			count++;
			if(count == 10){
			health += 100;
			Data.increaseLevel();
			count = 0;
			}
			
			
			timer.restart();
		
		
	}
	
	public void draw(Graphics g){
//		g.drawString(level,x, y);
	}
}
