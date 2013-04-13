import java.awt.Graphics;

import javax.swing.JPanel;


public class TurretPane extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		String level = Integer.toString(Data.getLevel());
		String gold = Integer.toString(Data.getGold());
		String life = Integer.toString(Data.getLife());
		g.drawString("Level: ", 5, 10);
		g.drawString(level, 5, 15);
		g.drawString("Gold: ", 10, 10);
		g.drawString(gold, 10, 15);
		g.drawString("Life: ", 10, 20);
		g.drawString(life, 10, 25);
	}
}
