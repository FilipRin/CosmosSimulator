package gui.svemir;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

public class Generator extends Thread {

	private Svemir svemir;
	Kometa kometa;
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
				
				int x= (int) (Math.random()*201);
				int y=0;
				int r=(int) (Math.random()*21+10);
				//System.out.println("x "+x+" y "+y+" r "+r);
				kometa=new Kometa(x,y,Color.GRAY,r);
				kometa.setParam();
				svemir.dodajNebeskoTelo(kometa);
				
			}
		} catch (InterruptedException e) {}
	}
	
	public synchronized void go() {
		work=true;
		notify();
	}
	
	
}
