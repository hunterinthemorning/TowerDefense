import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class TurretPane extends JPanel implements ActionListener{
	JButton button;
	SpawnMonsters monsters;
	
	TurretPane(){
		button = new JButton("START");
		button.addActionListener(this);
		setLayout(null);
		button.setBounds(0,500,100,50);
		add(button);
		monsters = new SpawnMonsters();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		String level = Integer.toString(Data.getLevel());
		String gold = Integer.toString(Data.getGold());
		String life = Integer.toString(Data.getLife());
		String monstersKilled = Integer.toString(Data.monstersKilled);
		g.drawString("Level: ", 10, 10);
		g.drawString(level, 10, 30);
		g.drawString("Gold: ", 10, 50);
		g.drawString(gold, 10, 70);
		g.drawString("Life: ", 10, 90);
		g.drawString(life, 10, 110);
		g.drawString("Monsters", 10, 130);
		g.drawString("Killed:", 10, 150);
		g.drawString(monstersKilled, 10, 170);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//call spawn monsters
		monsters.start();
	}
}
