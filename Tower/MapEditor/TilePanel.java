import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TilePanel extends JPanel implements MouseMotionListener,MouseListener,ActionListener{
	JButton dirt, grass, stone, water;
	DrawPanel panel;
	
	TilePanel(){
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(50,572));
		
		dirt = new JButton("");
		grass = new JButton("");
		stone = new JButton("");
		water = new JButton("");
	
		dirt.setPreferredSize(new Dimension(32,32));
		dirt.setIcon(new ImageIcon("./resources/Sprites/D.png"));
		grass.setPreferredSize(new Dimension(32,32));
		grass.setIcon(new ImageIcon("./resources/Sprites/G.png"));
		stone.setPreferredSize(new Dimension(32,32));
		stone.setIcon(new ImageIcon("./resources/Sprites/S.png"));
		water.setPreferredSize(new Dimension(32,32));
		water.setIcon(new ImageIcon("./resources/Sprites/W.png"));

		dirt.addActionListener(this);
		grass.addActionListener(this);
		stone.addActionListener(this);
		water.addActionListener(this);
		
		add(dirt);
		add(grass);
		add(stone);
		add(water);
	}
	
	public void setPanel(DrawPanel panel){
		this.panel = panel;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(e.getSource() == dirt){
			panel.setClicked("D");
		}else if(e.getSource() == water){
			panel.setClicked("W");
		}else if(e.getSource() == stone){
			panel.setClicked("S");
		}else if(e.getSource() == grass){
			panel.setClicked("G");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
