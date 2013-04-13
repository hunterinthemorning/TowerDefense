import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;


public class Data {
public static ArrayList<Towers> towers = new ArrayList();
	private static int startingGold = 200;
	private static int gold = startingGold;
	private static int life = 100;
	private static int level = 1;
	private static Map[][] map;
	private static ArrayList<Sprite> monsters;
	private static String grass = "Grass.png";
	private static String dirt = "Dirt.png";
	private static int startX, startY, endX, endY;
	
	private static String[][] m = {
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"DP","GP","DP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"},
			{"GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP","GP"}
	};
	public static int getLevel(){
		return level;
	}
	public static int getGold(){
		return gold;
	}
	public static int getLife(){
		return life;
	}
	public static int getStartX(){
		return startX;
	}
	
	public static int getStartY(){
		return startY;
	}
	
	public static int getEndX(){
		return endX;
	}
	
	public static int getEndY(){
		return endY;
	}
	
	public synchronized static void addGold(int amount){
		gold += amount;
	}

	public synchronized static boolean removeGold(int amount){
		if(gold - amount >= 0){
			gold -= amount;
			return true;
		}
		return false;
	}
	
	public static Map[][] getMap(){
		return map;
	}
	
	public synchronized static Map[][] getCharMap(){
		return null;
	}
	
	public static Sprite getMapSprite(int x, int y){
		if(map != null)
			return map[x][y].getMapSprite();
		return null;
	}
	
	public synchronized static void loadMap(int mapNumber){
		map = new Map[22][17];
		
		File file = new File("map" + mapNumber+".txt");
		Scanner scan = null;
		try{scan = new Scanner(file);}catch(Exception e){}
		
		for(int j = 0; j < 17; j++){
			for(int i = 0; i < 22; i++){
				String key = scan.next();
				String imgChar = Character.toString(key.charAt(0));
				Animation a = new Animation();
				a.addScene(new ImageIcon("./resources/sprites/"+imgChar+".png").getImage(), 5250);
				Sprite s = new Sprite(a);
				s.setX(32*i);
				s.setY(32*j);
				map[i][j] = new Map(key, s, imgChar);
			}
		}
		setStartPos(Integer.valueOf(scan.next()), Integer.valueOf(scan.next()));
		setEndPos(Integer.valueOf(scan.next()), Integer.valueOf(scan.next()));
		
		/*Image g = new ImageIcon(grass).getImage();
		Image d = new ImageIcon(dirt).getImage();
		Image image = null;
		
		File file = new File("map" + mapNumber+".txt");
		Scanner scan = null;
		try{scan = new Scanner(file);}catch(Exception e){}
		
		for(int j = 0; j < 17; j++){
			for(int i = 0; i < 22; i++){
				String key = scan.next();
				
				String imgKey = Character.toString(key.charAt(0));
				String patternKey = Character.toString(key.charAt(1));
				
				switch(imgKey){
					case "G":
						image = g;
						break;
					case "D":
						image = d;
						break;
				}
				Animation a = new Animation();
				a.addScene(image, 5250);
				Sprite s = new Sprite(a);
				s.setX(32*i);
				s.setY(32*j);
				map[i][j] = new Map(key, s);				
			}
		}
		setStartPos(Integer.valueOf(scan.next()), Integer.valueOf(scan.next()));
		setEndPos(Integer.valueOf(scan.next()), Integer.valueOf(scan.next()));*/
	}
	
	public static void setStartPos(int x, int y){
		startX = x;
		startY = y;
	}
	
	public static void setEndPos(int x, int y){
		endX = x;
		endY = y;
	}
	
	public static ArrayList<Sprite> getMonsters(){
		return monsters;
	}
}
