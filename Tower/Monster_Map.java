import java.io.*;
import java.util.*;
import java.awt.Graphics;

public class Monster_Map {

  Monster_Tile[][] monster_map = new Monster_Tile[22][17];
  Monster_Map(int mapNumber){
    //Monster_Tile[][] monster_map = new Monster_Tile[22][17];
    File file = new File("map1.txt");
    Scanner scan = null;
    try{scan = new Scanner(file);}catch(Exception e){}

    for(int j = 0; j < 17; j++){
      for(int i = 0; i < 22; i++){
        String key = scan.next();
        Monster_Tile tile = new Monster_Tile(key,0);
        monster_map[i][j] = tile;
      }
    }
  } 

}

class Monster_Tile{
  String tile;
  int traversed;

  Monster_Tile(String tile, int traversed){
    this.tile = tile;
    this.traversed = traversed;
  }

}
