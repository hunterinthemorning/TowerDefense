
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
		// create new monster when called
		//System.out.println((x/32) * 32  + " " +(y/32) *32);
		Monster monster = new Monster((x/32)*32, (y/32) *32, g, health, speed);
		monsters.add(monster);
	}
	
	public static void update(Graphics g){
		for(int i = 0; i < monsters.size(); i++){
                        Monster current_monster = monsters.get(i);
                        int current_monster_x = current_monster.x_position/32; 
                        int current_monster_y = current_monster.y_position/32; 
                        Monster_Tile temp = Monster_Map.monster_map[current_monster_x][current_monster_y];
                        Monster_Map.monster_map[current_monster_x][current_monster_y].traversed = 1;
                        
                        if(Monster_Map.monster_map[current_monster_x+1][current_monster_y].traversed == 0 && 
                           Monster_Map.monster_map[current_monster_x+1][current_monster_y].tile.equals("DM")){
				System.out.println("update1");
                               monsters.get(i).x_position = (current_monster_x+1) * 32;
                        }
                        else if((current_monster_x > 0) && (Monster_Map.monster_map[current_monster_x-1][current_monster_y].traversed == 0 && 
                             Monster_Map.monster_map[current_monster_x-1][current_monster_y].tile.equals("DM"))){
				System.out.println("update2");
                                monsters.get(i).x_position = (current_monster_x-1) * 32;
                        }
                        else if(Monster_Map.monster_map[current_monster_x][current_monster_y+1].traversed == 0 && 
                           Monster_Map.monster_map[current_monster_x][current_monster_y+1].tile.equals("DM")){
				System.out.println("update3");
                              monsters.get(i).y_position = (current_monster_y+1) * 32;

                        } 
                        else if((current_monster_y > 0) && (Monster_Map.monster_map[current_monster_x][current_monster_y-1].traversed == 0 && 
                           Monster_Map.monster_map[current_monster_x][current_monster_y-1].tile.equals("DM"))){
				System.out.println("update4");
                               monsters.get(i).y_position = (current_monster_y-1) * 32;
                        } 
			else {
				System.out.println("monster not moving");
			}

			monsters.get(i).paint(g);
			try{
			//System.out.println(i);
			}
			catch(Exception e){
			}
		}



/*		for(int i = 0; i < monsters.size(); i++){
                        Monster current_monster = monsters.get(i);
                        int current_monster_x = current_monster.x_position/32; 
                        int current_monster_y = current_monster.y_position/32; 
                        Monster_Tile temp = Monster_Map.monster_map[current_monster_x][current_monster_y];
                        Monster_Map.monster_map[current_monster_x][current_monster_y].traversed = 1;
                        
                        if(Monster_Map.monster_map[current_monster_x+1][current_monster_y].traversed == 0 && 
                           Monster_Map.monster_map[current_monster_x+1][current_monster_y].tile.equals("DM")){
				System.out.println("update1");
                               monsters.get(i).x_position = (current_monster_x+1) * 32;
                        }
                        else if(current_monster_x > 0){
                          if(Monster_Map.monster_map[current_monster_x-1][current_monster_y].traversed == 0 && 
                             Monster_Map.monster_map[current_monster_x-1][current_monster_y].tile.equals("DM")){
				System.out.println("update2");
                                monsters.get(i).x_position = (current_monster_x-1) * 32;
                          }
			  else {
				System.out.println("in update 2 but failed");
			  }
                        }
                        else if(Monster_Map.monster_map[current_monster_x][current_monster_y+1].traversed == 0 && 
                           Monster_Map.monster_map[current_monster_x][current_monster_y+1].tile.equals("DM")){
				System.out.println("update3");
                              monsters.get(i).y_position = (current_monster_y+1) * 32;

                        } 
                        else if(current_monster_y > 0){
                          if(Monster_Map.monster_map[current_monster_x][current_monster_y-1].traversed == 0 && 
                           Monster_Map.monster_map[current_monster_x][current_monster_y-1].tile.equals("DM")){
				System.out.println("update4");
                               monsters.get(i).y_position = (current_monster_y-1) * 32;
                          }
			  else {
				System.out.println("in update 2 but failed");
			  }
                        } 
			else {
				System.out.println("monster not moving");
			}

			monsters.get(i).paint();
			try{
			Thread.sleep(3000);
			//System.out.println(i);
			}
			catch(Exception e){
			}
		}*/
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
