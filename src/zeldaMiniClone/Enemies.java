package zeldaMiniClone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Enemies extends Rectangle{
	
	public int right = 1, left = 0, down = 0, up = 0;
	public int spd = 4;
	public int curAnimation = 0;
	public int curFrames = 0, taregetFrames = 15;
	public static List<Bullet> bullets = new ArrayList<Bullet>();
	public boolean shoot = false;
	public int dir =1;
	
	
	public Enemies(int x, int y) {
		super(x,y,32,32);
	}
	
	public void tick() {
		boolean moved = true;
		if(right == 1 && World.isFree(x +1, y)) {
			x++;
		}
		if(moved) {
		curFrames++;
		if(curFrames == taregetFrames) {
			curFrames = 0;
			curAnimation++;
				if(curAnimation == SpriteSheet.enemie_front.length) {
					curAnimation = 0;
				}
		}
		if(shoot) {
			shoot = false;
			bullets.add(new Bullet(x, y, dir));
		}
		for(int i = 0; i < bullets.size(); i++ ) {
			bullets.get(i).tick();
		}
	}
	}
	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(x,y,width,height);
		g.drawImage(SpriteSheet.enemie_front[curAnimation], x, y, 32, 32, null);
		
		for(int i = 0; i < bullets.size(); i++ ) {
			bullets.get(i).render(g);
		}
	}
	

}

