package gui.svemir;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Simulator extends Frame {

	private Svemir svemir=new Svemir(this);
	private Panel bottomPanel=new Panel();
	Panel centerPanel=new Panel();
	Generator generator;
	
	public Simulator() {
		setBounds(700,200,200,400);
		setResizable(false);
		setMinimumSize(new Dimension(200,400));
		populateWindow();
		pack();
		repaint();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(generator!=null) {
					generator.interrupt();
					
				}
				if(svemir.nit!=null) {
					svemir.nit.interrupt();
				}
				dispose();
			}
		});
		setVisible(true);
	}
	
	
	private void populateWindow() {
		
		svemir.setBackground(Color.BLACK);
		svemir.setPreferredSize(new Dimension(200,300));
		centerPanel.add(svemir);
		
		add(centerPanel,BorderLayout.CENTER);
		Button pokreni=new Button("Pokreni!");
		
		pokreni.addActionListener((ae)->{
			pokreni.disable();
			if(generator!=null) { generator.interrupt();}
			if(svemir.nit!=null) { svemir.nit.interrupt();}
			
			generator=new Generator(svemir);
			generator.start();
			
			svemir.nit=new Thread(svemir);
			svemir.nit.start();
			
			svemir.go();
			generator.go();
			svemir.repaint();
		});
		
		bottomPanel.add(pokreni);
		add(bottomPanel,BorderLayout.SOUTH);
	}


	public static void main(String[] args) {
		new Simulator();
	}

}
