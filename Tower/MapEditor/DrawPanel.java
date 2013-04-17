import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseMotionListener,MouseListener{
	Map[][] map;
	public String tile;
	private Image d = null;
	private boolean drawingClicked = false;
	private boolean showKeys, showStartAndEnd, fill, isPoint = false;
	private String k;
	int StartX, StartY, EndX, EndY;
	String[][] key;
	
	DrawPanel(){
		addMouseListener(this);
		addMouseMotionListener(this);
		Image im = new ImageIcon("./resources/sprites/B.png").getImage();
		System.out.println();
		map = new Map[22][17];
		key = new String[22][17];
		showKeys = false;
		showStartAndEnd = false;
		fill = false;
		this.setFont(new Font("sansserif", Font.BOLD, 20));
		for(int j = 0; j < 17; j++){
			for(int i = 0; i < 22; i++){
				key[i][j] = new String("N");
				Animation a = new Animation();
				a.addScene(im, 5250);
				Sprite s = new Sprite(a);
				s.setX(32*i);
				s.setY(32*j);
				map[i][j] = new Map("P", s, "B");
			}
		}
	}
	
	public Map getMap(int x, int y){
		return map[x][y];
	}
	
	public void setKey(String key){
		drawingClicked = false;
		k = key;
		if(key.equals("EP") || key.equals("SP"))
			isPoint = true;
		else
			isPoint = false;
	}
	
	public void fill(){
		if(fill)
			fill = false;
		else
			fill = true;
	}
	
	public void loadMap(int mapNumber){
		
	}
	
	public void setKeysClicked(){
		if(showKeys){
			showKeys = false;
		}else
			showKeys = true;
	}
	
	public void setClicked(String tileClicked){
		tile = tileClicked;
		ImageIcon im = null;
		
		switch(tileClicked){
			case "D": im = new ImageIcon("./resources/Sprites/D.png");
				break;
			case "G": im = new ImageIcon("./resources/Sprites/G.png");
				break;
			case "W": im = new ImageIcon("./resources/Sprites/W.png");
				break;
			case "S": im = new ImageIcon("./resources/Sprites/S.png");
				break;
		}
		d = im.getImage();
		drawingClicked = true;
		isPoint = false;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
//		g.setColor(Color.WHITE);
//		g.fillRect(0, 0, getWidth(), getHeight());
		for(int j = 0; j < 17; j++){
			for(int i = 0; i < 22; i++){
				if(map != null){
					Sprite s = map[i][j].getMapSprite();
				
					g.drawImage(s.getImage(), Math.round(s.getX()), Math.round(s.getY()), null);
					
					if(showKeys){
						setFont(new Font("sansserif", Font.BOLD, 20));
						g.drawString(map[i][j].getCharString(), Math.round(s.getX()) + 10 , Math.round(s.getY()) + 23);
					}
					else{
						setFont(new Font("sansserif", Font.BOLD, 10));
						
//						g.drawString(Integer.toString(StartX) + " " +Integer.toString(StartY), StartX, StartY);
						g.drawString("START", StartX, StartY);
//						g.drawString(Integer.toString(EndX) + " " +Integer.toString(EndY), EndX-40, EndY);
						g.drawString("END", EndX-20, EndY);
					}
				}
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public String getStart(){
		String startPos;
		
		startPos = Integer.toString(StartX).concat(" " +Integer.toString(StartY));
		
		return startPos;
	}
	public String getEnd(){
		String endPos;
		
		endPos = Integer.toString(EndX).concat(" " +Integer.toString(EndY));
		
		return endPos;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX() > 0 && e.getX() < getWidth() && e.getY() > 0 && e.getY() < getHeight() && d != null){
			Animation a = new Animation();
			a.addScene(d, 50);
			if(fill && drawingClicked && !isPoint){
				fill = false;
				for(int j = 0; j < 17; j++){
					for(int i = 0; i < 22; i++){
						Sprite mapSprite = new Sprite(a);
						mapSprite.setX(i * 32);
						mapSprite.setY(j * 32);
						map[i][j].setMapSprite(mapSprite, tile);
					}
				}
			}else if(drawingClicked && !isPoint){
				Sprite mapSprite = new Sprite(a);
				mapSprite.setX((e.getX()/32) * 32);
				mapSprite.setY((e.getY()/32)*32);
				map[e.getX()/32][e.getY()/32].setMapSprite(mapSprite, tile);	
			}else{
				if(fill && !isPoint){
					for(int j = 0; j < 17; j++){
						for(int i = 0; i < 22; i++){
							map[i][j].setCharString(k);
						}
					}
				}
				else
					if(!isPoint)
						map[e.getX()/32][e.getY()/32].setCharString(k);
					else{
						if(k.equals("EP")){
							EndX = e.getX();
							EndY = e.getY();
						}else if(k.equals("SP")){
							StartX = e.getX();
							StartY = e.getY();
						}
					}
			}
		}
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getX() > 0 && e.getX() < getWidth() && e.getY() > 0 && e.getY() < getHeight() && d != null){
			if(drawingClicked){
				Animation a = new Animation();
				a.addScene(d, 50);
				Sprite mapSprite = new Sprite(a);
				mapSprite.setX((e.getX()/32) * 32);
				mapSprite.setY((e.getY()/32)*32);
				map[e.getX()/32][e.getY()/32].setMapSprite(mapSprite, tile);	
			}else{
				
				map[e.getX()/32][e.getY()/32].setCharString(k);
			}
		}
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
