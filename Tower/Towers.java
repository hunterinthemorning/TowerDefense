import java.awt.Graphics;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Towers{
	static File file = new File("b.png");
	File file2 = new File("./image2.txt");
	static int sleep = 1000;
	public Graphics g = null;
	public int x_position = 0;
	public int y_position = 0;
	private int aoe = 10;
	static boolean live = false;
	static BufferedImage image1 = null;
	public int attacking;
	public Towers(int x, int y, Graphics g){
		set_tower(x, y, g);
		attack(live);
	}
	//sets the private position variables with the ones
	//passed from the map
	public void set_tower(int x, int y, Graphics g){
		this.x_position = x;
		this.y_position = y;
		this.g = g;
		paint();
		attack(live);
	
		try{
			image1 = ImageIO.read(file);
			//BufferedImage image2  = ImageIO.read(file2);
			}
		catch(IOException e){
			
		}
	}
	
	//draws the tower on the map
	public void paint(){
	//System.out.println(x_position + " " + y_position);
		g.drawImage(image1, x_position, y_position, null);

	}
	
	//draws attack animation
	/*public static void paint2(){
		
		g.drawImage(image1, x_position, y_position, null);
	}*/
	// this gets called after placement of first tower
		private void attack(boolean live) {
			//while live and if monsters exist
			
			while (live == true) {
			/*	if(Monsters.monster.size() > 0){
				//check if a monster is in range
				for(int i = 0; i < Monsters.monster.size(); i++){
					if((Monsters.monster[i].x <= x_position + 10 && Monsters.monster[i].y <= y_position + 10) ||
							(Monsters.monster[i].x <= x_position - 10 && Monsters.monster[i].y <= y_position + 10)||
							(Monsters.monster[i].x <= x_position + 10 && Monsters.monster[i].y <= y_position - 10)||
							(Monsters.monster[i].x <= x_position - 10 && Monsters.monster[i].y <= y_position - 10)){
						attacking = i;
					}
				}
				//call attack animation here
				////////////////////////////
				
				paint2();
				//take life away from attacked monster
				Monsters.monster[attacking].life -= 10;
				//sleep
				Thread.sleep(sleep);
			
			}	*/
			}
		}
}