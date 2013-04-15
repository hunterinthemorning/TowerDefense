import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class SpawnMonsters implements ActionListener {
	Timer timer = null;
	private int count = 0;
	int x, y; //Change this to represent the top right corner of the map
	int startingHealth = 100;
	
	public void start(){
		timer = new Timer(500, this);
		timer.setInitialDelay(500);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(count != 10){
//			spawnMonster(startingHealth*level, );
			count++;
			timer.restart();
		}
		else{
			count = 0;
//			incrase level of the game
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			timer.restart();
		}
	}
	
	public void draw(Graphics g){
//		g.drawString(level,x, y);
	}
}
