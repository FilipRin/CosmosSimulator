package gui.svemir;

import java.awt.Color;
import java.awt.Graphics;

public class Planeta extends NebeskoTelo {

	private int ring=0;
	private int explored=0;
	public Planeta(int x, int y, Color c, int r) {
		super(x, y, c, r);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillOval(this.x, this.y, this.r, this.r);
		//double check=Math.random()*10;
		if(ring==1)
		g.drawOval(this.x-this.r/2, this.y-this.r/2, this.r*2, 2*this.r);

	}
	
	public void ring(double check) {
		if(check<2.5) ring=1;
	}

	public int isExplored() {
		return this.explored;
	}
	
	public void explore() {
		explored=1;
	}
	
}
///// TREBA URADITI KOLIZIJU SA KOMETOM, KRETANJE LETELICE U OPSEGU.