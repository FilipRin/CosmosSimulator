package gui.svemir;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Dialog.ModalityType;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Simulator extends Frame {

	Svemir svemir=new Svemir(this);
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
		Button zaustavi=new Button("Zaustavi!");
		zaustavi.disable();
		Button nastavi=new Button("Nastavi!");
		nastavi.disable();
		pokreni.addActionListener((ae)->{
			pokreni.disable();
			zaustavi.enable();
			if(generator!=null) { generator.interrupt();}
			if(svemir.nit!=null) { svemir.nit.interrupt();}
			
			generator=new Generator(svemir);
			generator.start();
			
			svemir.nit=new Thread(svemir);
			svemir.nit.start();
			
			svemir.go();
			generator.go();
			svemir.repaint();
			svemir.requestFocus();
		});
		
		zaustavi.addActionListener((ae)->{
			zaustavi.disable();
			nastavi.enable();
			generator.pause();
			svemir.pause();
			
		});
		nastavi.addActionListener((ae)->{
			zaustavi.enable();
			nastavi.disable();
			generator.go();
			svemir.go();
		});
		
		bottomPanel.add(pokreni);
		bottomPanel.add(zaustavi);
		bottomPanel.add(nastavi);
		add(bottomPanel,BorderLayout.SOUTH);
	}

	private void showHelpDialog() {
		Dialog help=new Dialog(this,ModalityType.APPLICATION_MODAL);
		help.setTitle("Help");
		help.add(new Label("Use a-d to move.",Label.CENTER));
		help.setBounds(700, 200, 100, 100);
		help.setResizable(false);
		
		help.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				help.dispose();
			}
		});
		
		help.setVisible(true);
	}

	public static void main(String[] args) {
		new Simulator();
	}

}
