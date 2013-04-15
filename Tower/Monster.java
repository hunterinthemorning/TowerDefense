import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Monster
{
  static File file = new File("./1.png");
  File file2 = new File("./monster2.png");
  static int sleep = 1000;
  public Graphics g = null;
  public int x_position = 0;
  public int y_position = 0;
  int health = 0;
  int starting_health = 0;
  private int speed = 0;
  private static boolean live = false;
  private static BufferedImage image1 = null;
  public Monster_Tile[][] monster_map = new Monster_Tile[22][17];
  //public static Monster_Map monster_map;

  public Monster(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { set_monster(paramInt1, paramInt2, paramInt3, paramInt4); }


  public void set_monster(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.x_position = paramInt1;
    this.y_position = paramInt2;
    
    this.health = SpawnMonsters.health;
    this.starting_health = health;
    this.speed = paramInt4;
    Monster_Map monster_Map = new Monster_Map(1);
    this.monster_map = monster_Map.monster_map;
    try
    {
      image1 = ImageIO.read(file);
    }
    catch (IOException localIOException)
    {
    }
  }

  public void paint(Graphics paramGraphics)
  {
    if(health <= starting_health && health > starting_health * .75){
    file = new File("./1.png");
    try
    {
      image1 = ImageIO.read(file);
    }
    catch (IOException localIOException)
    {
    }
    paramGraphics.drawImage(image1, this.x_position, this.y_position, null);
    }
    if(health <= starting_health * .75 && health > starting_health * .50){
      file = new File("./3.png");
    try
    {
      image1 = ImageIO.read(file);
    }
    catch (IOException localIOException)
    {
    }
    paramGraphics.drawImage(image1, this.x_position, this.y_position, null);
    }
    if(health <= starting_health * .50 && health > starting_health * .25){
      file = new File("./4.png");
    try
    {
      image1 = ImageIO.read(file);
    }
    catch (IOException localIOException)
    {
    }
    paramGraphics.drawImage(image1, this.x_position, this.y_position, null);
    }
    if(health <= starting_health * .25 && starting_health > 0){
      file = new File("./2.png");
    try
    {
      image1 = ImageIO.read(file);
    }
    catch (IOException localIOException)
    {
    }
    paramGraphics.drawImage(image1, this.x_position, this.y_position, null);
    }

  }

  public int getHealth()
  {
    return this.health;
  }

  public void setHealth(int paramInt) {
    this.health = paramInt;
  }
}
