package gui.svemir;

import java.awt.Color;
import java.awt.Graphics;

public abstract class NebeskoTelo extends Objekat {

	protected int r;
	
	public NebeskoTelo(int x, int y, Color c,int r) {
		super(x, y, c);
		this.r=r;
	}

	public abstract void paint(Graphics g);
	

}
