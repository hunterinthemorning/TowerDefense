
import java.util.ArrayList;
import java.awt.Graphics;
public class Monster_Controller {
	static Graphics g;
	int health = 100;
	int speed = 10;
	static ArrayList<Monster> monsters = new ArrayList();

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

		for(int i = 0; i < monsters.size(); i++){
                        Monster current_monster = monsters.get(i);
                        int current_monster_x = current_monster.x_position/32; 
                        int current_monster_y = current_monster.y_position/32; 

                        Monster_Tile temp = Monster_Map.monster_map[current_monster_x][current_monster_y];
			System.out.println("monster_map["+current_monster_x+"]["+current_monster_y+"]");
                        Monster_Map.monster_map[current_monster_x][current_monster_y].traversed = 1;
                        
                        if(Monster_Map.monster_map[current_monster_x+1][current_monster_y].traversed == 0 && 
                           Monster_Map.monster_map[current_monster_x+1][current_monster_y].tile.equals("DM")){
				System.out.println("update-monster 1");
                               monsters.get(i).x_position = (current_monster_x+1) * 32;
                        }
                        else if((current_monster_x > 0) && (Monster_Map.monster_map[current_monster_x-1][current_monster_y].traversed == 0 && 
                             Monster_Map.monster_map[current_monster_x-1][current_monster_y].tile.equals("DM"))){
				System.out.println("update-monster 2");
                                monsters.get(i).x_position = (current_monster_x-1) * 32;
                        }
                        else if(Monster_Map.monster_map[current_monster_x][current_monster_y+1].traversed == 0 && 
                           Monster_Map.monster_map[current_monster_x][current_monster_y+1].tile.equals("DM")){
				System.out.println("update-monster 3");
                              monsters.get(i).y_position = (current_monster_y+1) * 32;

                        } 
                        else if((current_monster_y > 0) && (Monster_Map.monster_map[current_monster_x][current_monster_y-1].traversed == 0 && 
                           Monster_Map.monster_map[current_monster_x][current_monster_y-1].tile.equals("DM"))){
				System.out.println("update-monster 4");
                               monsters.get(i).y_position = (current_monster_y-1) * 32;
                        } 

			System.out.println("updating monsters");
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
		if(health <= 0){
			monsters.remove(position);
//			update();
		}	
		else {
			monsters.get(position).setHealth(health);
//			update();
		}
	}//end dealDamage
}
