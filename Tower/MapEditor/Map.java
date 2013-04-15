package MapEditor;
import java.util.ArrayList;


public class Map {
	Sprite monster, mapSprite;
	String charString, charMapSprite;
	String mapString;
	
	Map(String charString, Sprite mapSprite, String charMapSprite){
		this.charString = charString;
		this.mapSprite = mapSprite;
		this.charMapSprite = charMapSprite;
		mapString = charMapSprite.concat(charString);
	}
	
	public void setMapSprite(Sprite mapSprite, String tile){
		this.mapSprite = mapSprite;
		charMapSprite = tile;
		mapString = charMapSprite.concat(charString);
	}
	
	public void setMapSprite(Sprite mapSprite, String tile, String key){
		this.mapSprite = mapSprite;
		charMapSprite = tile;
		charString = key;
		mapString = charMapSprite.concat(charString);
	}
	
	public String getMapString(){
		return mapString;
	}
	
	public Sprite getMapSprite(){
		return mapSprite;
	}
	
	public Sprite getMonster(){
		return monster;
	}
	
	public String getCharString(){
		return charString;
	}
	
	public void setMonster(Sprite monster){
		this.monster = monster;
	}
	
	public void setCharString(String charString){
		this.charString = charString;
		mapString = charMapSprite.concat(charString);
	}
	
	public float getX(){
		return mapSprite.getX();
	}
	
	public float getY(){
		return mapSprite.getY();
	}
}
