
import java.util.ArrayList;
import java.awt.Graphics;
public class Monster_Controller {
	static Graphics g;
	int health = 100;
	int speed = 10;
	static ArrayList<Monster> monsters = new ArrayList();

	public static void spawnMonster(int x, int y, Graphics g, int health, int speed) {
		// do x and y conversion here
		/////////////////////////////
		
		/////////////////////////////
		// create new tower when called
		//System.out.println((x/32) * 32  + " " +(y/32) *32);
		Monster monster = new Monster((x/32)*32, (y/32) *32, g, health, speed);
		monsters.add(monster);
	}
	
	public static void update(){

		for(int i = 0; i < monsters.size(); i++){
			monsters.get(i).paint();
			try{
			//Thread.sleep(2000);
			//System.out.println(i);
			}
			catch(Exception e){
			}
		}
	}

	public static void dealDamage(int position, int damage) {
		int health;	
		health = (monsters.get(position).getHealth()) - damage;
		if(health <= 0){
			monsters.remove(position);
			update();
		}	
		else {
			monsters.get(position).setHealth(health);
			update();
		}
	}//end dealDamage
}
