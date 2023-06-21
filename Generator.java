package gui.svemir;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

public class Generator extends Thread {

	private Svemir svemir;
	Kometa kometa;
	Planeta planeta;
	private boolean work;
	
	public Generator(Svemir svemir) {
		this.svemir=svemir;
	}
	
	@Override
	public void run() {
		try {
			while(!interrupted()) {
				synchronized (this) {
					while(!work) {
						wait();
					}
				}
				sleep(900);
				double check=Math.random()*10;
				if(check>=2.5) {
					int x= (int) (Math.random()*201);
					int y=0;
					int r=(int) (Math.random()*21+10);
					//System.out.println("x "+x+" y "+y+" r "+r);
					kometa=new Kometa(x,y,Color.GRAY,r);
					kometa.setParam();
					svemir.dodajNebeskoTelo(kometa);
				}
				else {
					int x= (int) (Math.random()*201);
					int y=0;
					int r=(int) (Math.random()*21+10);
					double color=Math.random()*10;
					Color col=null;
					if(color<2.5) {
						col=Color.GREEN;
					}
					else if(color>=2.5 & color<5) {
						col=Color.BLUE;
					}
					else if(color>=5 & color<7.5) {
						col=Color.YELLOW;
					}
					else {
						col=Color.RED;
					}
					double ring=Math.random()*10;
					
					planeta=new Planeta(x,y,col,r);
					planeta.ring(ring);
					svemir.dodajNebeskoTelo(planeta);
				}
				
			}
		} catch (InterruptedException e) {}
	}
	
	public synchronized void go() {
		work=true;
		notify();
	}
	public synchronized void pause() {
		work=false;
		notify();
	}
	
	
}
