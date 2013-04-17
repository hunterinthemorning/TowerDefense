import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

public class MapEditor extends JFrame implements ActionListener, KeyListener{
	TilePanel tilePanel;
	DrawPanel panel;
	JMenuItem New, Save, Open;
	Timer timer;
	JButton button, fill, P, B, M, Start, End;
	
	public static void main(String[] args){
		new MapEditor();
	}
	
	
	public MapEditor(){
		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("File");
		button = new JButton("TogKey");
		fill = new JButton("Fill");
		P = new JButton("P");
		B = new JButton("B");
		M = new JButton("M");
		Start = new JButton("Start");
		End = new JButton("End");
		
		menuBar.add(menu);
		menuBar.add(button);
		menuBar.add(fill);
		menuBar.add(P);
		menuBar.add(B);
		menuBar.add(M);
		menuBar.add(Start);
		menuBar.add(End);
		
		Open = new JMenuItem("Open");
		Save = new JMenuItem("Save");
		New = new JMenuItem("New");
		
		New.addActionListener(this);
		Open.addActionListener(this);
		Save.addActionListener(this);
		button.addActionListener(this);
		fill.addActionListener(this);
		P.addActionListener(this);
		B.addActionListener(this);
		M.addActionListener(this);
		Start.addActionListener(this);
		End.addActionListener(this);
		
		menu.add(New);
		menu.add(Open);
		menu.add(Save);
		
		setJMenuBar(menuBar);
		
		panel = new DrawPanel();
		tilePanel = new TilePanel();
		
		setResizable(false);
		setSize(760,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(tilePanel, BorderLayout.WEST);
		setVisible(true);
		
		tilePanel.setPanel(panel);
		
		timer = new Timer(30, this);
		timer.setInitialDelay(30);
		timer.start(); 
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		if(o == timer){
			panel.repaint();
			timer.restart();
		}
		
		if(e.getSource() == New){
			clear();
		}else if(e.getSource() == Open){
			open();
		}else if(e.getSource() == Save){
			save();
		}else if(e.getSource() == button){
			panel.setKeysClicked();
		}else if(e.getSource() == fill){
			panel.fill();
		}else if(e.getSource() == P){
			panel.setKey("P");
		}else if(e.getSource() == B){
			panel.setKey("B");
		}else if(e.getSource() == M){
			panel.setKey("M");
		}else if(e.getSource() == Start){
			panel.setKey("SP");
		}else if(e.getSource() == End){
			panel.setKey("EP");
		}
	}
	
	public void clear(){
		for(int j = 0; j < 17; j++){
			for(int i = 0; i < 22; i++){
				ImageIcon im = null;
				Animation a = new Animation();
				im = new ImageIcon("./resources/Sprites/B.png");
				Image d = im.getImage();
				
				a.addScene(d, 50);
				Sprite mapSprite = new Sprite(a);
				mapSprite.setX(i * 32);
				mapSprite.setY(j * 32);
				panel.getMap(i,j).setMapSprite(mapSprite, "P");
			}
		}
	
	}
	
	public void open(){
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		
		try{
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			
			Scanner scan = null;
			try {
				scan = new Scanner(new File(file.getName()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
			}
			
			for(int j = 0; j < 17; j++){
				for(int i = 0; i < 22; i++){
					ImageIcon im = null;
					Animation a = new Animation();
					String c = scan.next();
					String tileClicked = Character.toString(c.charAt(0));
					switch(tileClicked){
					case "D": im = new ImageIcon("./resources/Sprites/D.png");
						break;
					case "G": im = new ImageIcon("./resources/Sprites/G.png");
						break;
					case "W": im = new ImageIcon("./resources/Sprites/W.png");
						break;
					case "S": im = new ImageIcon("./resources/Sprites/S.png");
						break;
					case "B": im = new ImageIcon("./resources/Sprites/B.png");
						break;
				}
					Image d = im.getImage();
					
					a.addScene(d, 50);
					Sprite mapSprite = new Sprite(a);
					mapSprite.setX(i * 32);
					mapSprite.setY(j * 32);
					panel.getMap(i,j).setMapSprite(mapSprite, tileClicked, Character.toString(c.charAt(1)));
				}
			}
		}}catch(Exception e){System.out.println("This File does not exist");}
	}
	
	public void save(){
		FileWriter fstream;
		BufferedWriter out = null;
		JFileChooser fc = new JFileChooser();
		//In response to a button click:
		int returnVal = fc.showOpenDialog(this);
		try {
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
            
				fstream = new FileWriter(file.getName());
				out = new BufferedWriter(fstream);
            
				for(int j = 0; j < 17; j++){
					for(int i = 0; i < 22; i++){
						out.write(panel.getMap(i,j).getMapString());
						out.write(" ");
					}
					out.newLine();
				}
				out.write(panel.getStart());out.newLine();
				out.write(panel.getEnd());
				out.close();
			} else {
				
			}
			
		} catch (IOException e) {e.printStackTrace();}
	}
	
}
