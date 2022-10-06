package gui.svemir;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Kometa extends NebeskoTelo {

	private int xpoz[]= new int[6];
	private int ypoz[]= new int[6];
	
	public Kometa(int x, int y, Color c, int r) {
		super(x, y, c.GRAY, r);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		for(int i=0;i<5;i++) {
			ypoz[i]+=5;
		}
		g.fillPolygon(xpoz, ypoz, 5);
		//g.drawPolygon(xpoz, ypoz, 5);
	}
	
	public void setParam() {
		double pom=2*Math.PI/5;
		int counter=0;
		/*for(int i=0;i<5;i++) {
			System.out.println("tuu sam");
			x[i]=(int)(r*Math.cos(pom*i)+p);
			y[i]=(int)(r*Math.cos(pom*i)+p);
			System.out.println("(x,y)="+x[i]+", "+y[i]);
			//offset+=Math.toRadians(p);
		}*/
		double ang = Math.random() % 2*Math.PI;
		
		for (double angle = ang; angle < 2 * Math.PI + ang; angle += pom) {
            xpoz[counter] =(int)(r*Math.cos(pom+angle));
            ypoz[counter] =(int)(r*Math.sin(pom+angle));
            counter++;
        }
		for(int i=0;i<5;i++) {
			xpoz[i]+=x;
			ypoz[i]+=y;
		}
		
	}

}
