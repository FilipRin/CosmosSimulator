package gui.svemir;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {

	protected int x,y;
	protected Color color;
	
	public Objekat(int x,int y,Color c) {
		this.x=x;
		this.y=y;
		this.color=c;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void PomeriX(int pomeraj) {
		this.x+=pomeraj;	
	}
	
	public void PomeriY(int pomeraj) {
		this.y+=pomeraj;	
	}
	
	public abstract void paint(Graphics g);
	
}
