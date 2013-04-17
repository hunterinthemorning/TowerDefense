import java.awt.Image;


public class Sprite {

	private Animation a;
	private float x, y, vx, vy;
	
	public Sprite(Animation a){
		this.a = a;
	}
	
	public void update(long timePassed){
		x += vx * timePassed;
		y += vy * timePassed;
		a.update(timePassed);
	}

	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	//get sprite width
	public int getWidth(){
		return a.getImage().getWidth(null);
	}
	
	//get height
	public int getHeight(){
		return a.getImage().getHeight(null);
	}
	
	//get horizontal velocity
	public float getVelocityX(){
		return vx;
	}
	
	//get y velocity
	public float getVelocityY(){
		return vy;
	}
	
	//set velocity x
	public void setVelocityX(float vx){
		System.out.println(vx);
		this.vx = vx;
	}
	
	//set velocity y
	public void setVelocityY(float vy){
		this.vy = vy;
	}
	
	//set both vx and vy velocity
	public void setVelocity(float vx, float vy){
		this.vx = vx;
		this.vy = vy;
	}
	
	//get sprite / image
	public Image getImage(){
		return a.getImage();
	}

}
