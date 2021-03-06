import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Monster_Controller {
	int health = 100;
	int speed = 10;
	static int endX;
	static int endY;
	static ArrayList<Monster> monsters = new ArrayList();
	static File flame = new File("./Burn.png");
	static BufferedImage image1 = null;

	public static void spawnMonster(int x, int y, int health, int speed) {
		// do x and y conversion here
		/////////////////////////////
		
		/////////////////////////////
		// create new monster when called
		//System.out.println((x/32) * 32  + " " +(y/32) *32);
		Monster monster = new Monster((x/32)*32, (y/32) *32, health, speed);
				monsters.add(monster);
	}
		
	public static void draw(Graphics g) {
	
		for(int i = 0; i < monsters.size(); i++){
			monsters.get(i).paint(g);
		}

	}

	
	public static void update(){
		int monstersKilled = 0;

		for(int i = 0; i < monsters.size(); i++){
                        Monster current_monster = monsters.get(i);
                        int current_monster_x = current_monster.x_position/32; 
                        int current_monster_y = current_monster.y_position/32; 
			endX = Data.getEndX()/32;
			endY = Data.getEndY()/32;
//			System.out.println("curX "+current_monster_x+" curY "+current_monster_y);
//			System.out.println("endX "+endX+" endY "+endY);


			if((current_monster_x == (endX)) && (current_monster_y == (endY))) {
				monsters.remove(i);
				Data.life -= 20;
				if(Data.life <= 0){
		        		JOptionPane.showMessageDialog(null, "Game over!!! "+"\nGood Job!! You killed "+Data.monstersKilled+" monsters!!");
					System.exit(0);
				}
			}
			else {

//					System.out.println("monster_map["+current_monster_x+"]["+current_monster_y+"]");
                                      current_monster.monster_map[current_monster_x][current_monster_y].traversed = 1;
                                      
                                      if(current_monster.monster_map[current_monster_x+1][current_monster_y].traversed == 0 && 
                                         current_monster.monster_map[current_monster_x+1][current_monster_y].tile.equals("DM")){
//						System.out.println("update-monster 1");
                                             monsters.get(i).x_position = (current_monster_x+1) * 32;
                                      }
                                      else if((current_monster_x > 0) && (current_monster.monster_map[current_monster_x-1][current_monster_y].traversed == 0 && 
                                           current_monster.monster_map[current_monster_x-1][current_monster_y].tile.equals("DM"))){
//						System.out.println("update-monster 2");
                                              monsters.get(i).x_position = (current_monster_x-1) * 32;
                                      }
                                      else if(current_monster.monster_map[current_monster_x][current_monster_y+1].traversed == 0 && 
                                         current_monster.monster_map[current_monster_x][current_monster_y+1].tile.equals("DM")){
//						System.out.println("update-monster 3");
                                            monsters.get(i).y_position = (current_monster_y+1) * 32;
                      
                                      } 
                                      else if((current_monster_y > 0) && (current_monster.monster_map[current_monster_x][current_monster_y-1].traversed == 0 && 
                                         current_monster.monster_map[current_monster_x][current_monster_y-1].tile.equals("DM"))){
//						System.out.println("update-monster 4");
                                             monsters.get(i).y_position = (current_monster_y-1) * 32;
                                      } 
			}

//			System.out.println("updating monsters");
			try{
			//Thread.sleep(200);
			//System.out.println(i);
			}
			catch(Exception e){
			}
		}
	}

	public static void dealDamage(int position, int damage) {
		int health;	
		health = (monsters.get(position).getHealth()) - damage;
//		System.out.println("Monster "+position+" health "+health);
		if(health <= 0){
			monsters.remove(position);
			Data.gold += 10;
			Data.monstersKilled++;
//			update();
		}	
		else {
			monsters.get(position).setHealth(health);
//			update();
		}
	}//end dealDamage
}
