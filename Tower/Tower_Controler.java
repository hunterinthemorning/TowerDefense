import java.awt.Graphics;
import java.util.ArrayList;

public class Tower_Controler
{
  static Graphics g;
  static boolean live = false;

  public static void recieve_position(int paramInt1, int paramInt2)
  {
    Map[][] arrayOfMap = Data.getMap();

    if (arrayOfMap[(paramInt1 / 32)][(paramInt2 / 32)].getCharString().equals("GP")) {
      Towers localTowers = new Towers(paramInt1 / 32 * 32, paramInt2 / 32 * 32, g);
      Data.towers.add(localTowers);
      arrayOfMap[(paramInt1 / 32)][(paramInt2 / 32)].setCharString("B");
    }
  }

  public static void update(Graphics paramGraphics)
  {
    for (int i = 0; i < Data.towers.size(); i++)
      Data.towers.get(i).paint(paramGraphics);
  }
}