package gui.svemir;

import java.awt.Color;
import java.awt.Graphics;

public class Letelica extends Objekat {

	int L=0;
	int H=0;
	int prov=0;
	private int xpoz[]= new int[3];
	private int ypoz[]= new int[3];
	
	public Letelica(int x, int y, Color c,int duzina,int visina) {
		super(x, y, c);
		this.L=duzina;
		this.H=visina;
	}

	public boolean preklapanje(NebeskoTelo nt) {
		//double duzinaStranice=Math.sqrt(Math.pow(this.L/2,2)+Math.pow(this.H, 2));
		//double radius=Math.pow(duzinaStranice, 2)/(2*this.H);
		if(this.rastojanje(nt)<nt.r+((this.H+this.L)/2))
		return true;
		else return false;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		if(prov==0) {
		this.getXpoz()[0]=this.getX();
		this.ypoz[0]=this.getY()-this.H;
		this.getXpoz()[1]=this.getX()-(this.L/2);
		this.ypoz[1]=this.getY();
		this.getXpoz()[2]=this.getX()+(this.L/2);
		this.ypoz[2]=this.getY();
		prov=1;
		}
		
		g.fillPolygon(getXpoz(), ypoz, 3);
		g.drawPolygon(getXpoz(), ypoz, 3);

	}

	public int[] getXpoz() {
		return xpoz;
	}

	public void setXpoz(int[] xx) {
		xpoz=xx;
	}
	
}
