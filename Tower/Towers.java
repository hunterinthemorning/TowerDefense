import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Towers
  implements ActionListener
{
  static File file = new File("b.png");
  File file2 = new File("./image2.txt");
  static int sleep = 1000;
  public Graphics g = null;
  public int x_position = 0;
  public int y_position = 0;
  private int aoe = 50;
  static boolean live = false;
  static BufferedImage image1 = null;
  public int attacking;
  Timer timer = null;

  public void actionPerformed(ActionEvent paramActionEvent)
  {
    if (Monster_Controller.monsters.size() > 0)
    {
      for (int i = 0; i < Monster_Controller.monsters.size(); i++) {
        if (((((Monster)Monster_Controller.monsters.get(i)).x_position <= this.x_position - this.aoe + this.aoe * 2) && (((Monster)Monster_Controller.monsters.get(i)).y_position <= this.y_position - this.aoe)) || ((((Monster)Monster_Controller.monsters.get(i)).x_position <= this.x_position - this.aoe + this.aoe * 2) && (((Monster)Monster_Controller.monsters.get(i)).y_position <= this.y_position - this.aoe)) || ((((Monster)Monster_Controller.monsters.get(i)).x_position <= this.x_position + this.aoe) && (((Monster)Monster_Controller.monsters.get(i)).y_position <= this.y_position - this.aoe + this.aoe * 2)) || ((((Monster)Monster_Controller.monsters.get(i)).x_position <= this.x_position - this.aoe) && (((Monster)Monster_Controller.monsters.get(i)).y_position <= this.y_position - this.aoe + this.aoe * 2)))
        {
          this.attacking = i;
	paint2();
//          System.out.println(((Monster)Monster_Controller.monsters.get(this.attacking)).health);
          Monster_Controller.dealDamage(attacking, 10);
        }

      }

    }

    this.timer.restart();
  }

  public Towers(int paramInt1, int paramInt2, Graphics paramGraphics)
  {
    start_attack();
    set_tower(paramInt1, paramInt2, paramGraphics);
    live = true;
  }

  public void set_tower(int paramInt1, int paramInt2, Graphics paramGraphics)
  {
    this.x_position = paramInt1;
    this.y_position = paramInt2;
    this.g = paramGraphics;
    paint(paramGraphics);
    Data.gold -= 40;
    attack();
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
    paramGraphics.drawImage(image1, this.x_position - 12, this.y_position - 12, null);
    paramGraphics.setColor(Color.black);
    paramGraphics.drawOval(this.x_position - this.aoe, this.y_position - this.aoe, this.aoe * 2, this.aoe * 2);
    attack();
  }

  public void paint2()
  {
    this.g.setColor(Color.magenta);
    this.g.drawOval(this.x_position - this.aoe + 75, this.y_position - this.aoe + 75, this.aoe * 2 - 150, this.aoe * 2 - 150);
    try {
      Thread.sleep(20L);
    }
    catch (InterruptedException localInterruptedException1) {
      localInterruptedException1.printStackTrace();
    }
    this.g.drawOval(this.x_position - this.aoe + 50, this.y_position - this.aoe + 50, this.aoe * 2 - 100, this.aoe * 2 - 100);
    try {
      Thread.sleep(20L);
    }
    catch (InterruptedException localInterruptedException2) {
      localInterruptedException2.printStackTrace();
    }
    this.g.drawOval(this.x_position - this.aoe + 12, this.y_position - this.aoe + 12, this.aoe * 2 - 25, this.aoe * 2 - 25);
    try {
      Thread.sleep(20L);
    }
    catch (InterruptedException localInterruptedException3) {
      localInterruptedException3.printStackTrace();
    }
    this.g.drawOval(this.x_position - this.aoe, this.y_position - this.aoe, this.aoe, this.aoe);
  }

  public void start_attack() {
    this.timer = new Timer(500, this);
    this.timer.setInitialDelay(500);
    this.timer.start();
  }

  private void attack()
  {
  }
}
