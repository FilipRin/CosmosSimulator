package gui.svemir;

import java.awt.Canvas;
import java.awt.Graphics;

import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {

	private Simulator owner;
	private ArrayList<NebeskoTelo> nebeskaTela=new ArrayList<>();
	Thread nit;
	private boolean work;
	Generator generator;
	
	public Svemir(Simulator owner) {this.owner=owner;
		setVisible(true);
	}
	
	public synchronized void dodajNebeskoTelo(NebeskoTelo nt) {
		nebeskaTela.add(nt);
	}
	
	@Override
	public void paint(Graphics g) {
		drawComet();
	}

	private void drawComet() {
		if(nebeskaTela==null)return;
		for(NebeskoTelo nt:nebeskaTela) {
			nt.paint(getGraphics());
		}
		for(NebeskoTelo nt:nebeskaTela) {
			nt.PomeriY(5);
		}
	}

	@Override
	public void run() {
		try {
			while(!nit.isInterrupted()) {
				synchronized (this) {
					while(!work) {
						wait();
					}
				}
				nit.sleep(100);
				repaint();
			}
		}catch(InterruptedException e) {}
	}
	
	public synchronized void go() {
		work=true;
		notify();
	}
	
	
}
