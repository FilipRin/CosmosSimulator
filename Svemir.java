package gui.svemir;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {

	private Simulator owner;
	private ArrayList<NebeskoTelo> nebeskaTela=new ArrayList<>();
	Letelica letelica=null;
	Thread nit;
	private int counter=0;
	private int explorationPoints=-1;
	private boolean work;
	private int crash=0,player=0;
	Generator generator;
	
	public Svemir(Simulator owner) {this.owner=owner;
		addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char key=Character.toUpperCase(e.getKeyChar());
				
				switch (key) {
				case KeyEvent.VK_A:{
					int[] niz=letelica.getXpoz();
					for(int i=0;i<3;i++) {
						niz[i]-=5;
					}
					letelica.setXpoz(niz);
					letelica.x-=5;
					break;
					
				}
				case KeyEvent.VK_D:{
					int[] niz=letelica.getXpoz();
					for(int i=0;i<3;i++) {
						niz[i]+=5;
					}
					letelica.setXpoz(niz);
					letelica.x+=5;
					break;
				}
					
			}
			}
		});
		setVisible(true);	
	}
	
	public synchronized void dodajNebeskoTelo(NebeskoTelo nt) {
		nebeskaTela.add(nt);
	}
	
	@Override
	public void paint(Graphics g) {
		
		if(crash==0)
		{
		g.setColor(Color.RED);
		if(this.player==0) {
			this.letelica=new Letelica(this.getWidth()/2,this.getHeight(),Color.CYAN,50,25);
			player++;
		}
		this.letelica.paint(getGraphics());
		g.drawString("Exploration points: "+explorationPoints, 0, 10);
		explorationPoints++;
		drawComet();
		}
		else if(crash==1){
			g.setColor(Color.RED);
			g.drawString("Exploration points: "+explorationPoints, 0, 10);
			g.setFont(new Font("default",Font.BOLD,15));
			this.letelica.paint(getGraphics());
			drawComet();
			g.drawString("GAME OVER!",this.getWidth()/2-40, this.getHeight()/2);
			g.drawString(" Score:"+explorationPoints,this.getWidth()/2-30 , this.getHeight()/2+12);
			
			this.nit.interrupt();
			this.owner.generator.interrupt();
		}
		else {}
	}

	private void drawComet() {
		if(nebeskaTela==null)return;
		for(NebeskoTelo nt:nebeskaTela) {
			nt.paint(getGraphics());
		}
		for(NebeskoTelo nt:nebeskaTela) {
			nt.PomeriY(5);
		}
		for(NebeskoTelo nt:nebeskaTela) {
			if(this.letelica.preklapanje(nt)) {
				if(nt instanceof Planeta) {
					if(((Planeta) nt).isExplored()==0) {
						this.explorationPoints+=100;
						((Planeta) nt).explore();
					}
				}
				else if(nt instanceof Kometa) {
					this.crash=1;
					nt.paint(getGraphics());
				}
			}
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
		}catch(InterruptedException e) {
		}
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
