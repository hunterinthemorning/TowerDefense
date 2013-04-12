import java.util.ArrayList;


public class Map {
	Sprite monster, mapSprite;
	String charString, charMapSprite;
	
	Map(String charString, Sprite mapSprite, String charMapSprite){
		this.charString = charString;
		this.mapSprite = mapSprite;
		this.charMapSprite = charMapSprite;
	}
	
	public void setMapSprite(Sprite mapSprite, String tile){
		this.mapSprite = mapSprite;
		charMapSprite = tile;
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
	}
	
	public float getX(){
		return mapSprite.getX();
	}
	
	public float getY(){
		return mapSprite.getY();
	}
}
