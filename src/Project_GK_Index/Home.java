package Project_GK_Index;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.Toolkit;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.ImageObserver;   
import java.awt.Graphics2D;

public class Home implements ActionListener{
	JFrame f;    
	JPanel panel;
	JMenuBar mb;    
	JMenu home,search,about;   
	JMenuItem elec,food,exit,toHome;     
	JTextArea ta; 
	JTextField Text;
	JButton b;
	

	
	Home() {
		f=new JFrame("Home base");    		
		f.setSize(1350,700); 
		panel = new JPanel();

		elec=new JMenuItem("Electronic");    
		food=new JMenuItem("Food");       
		exit=new JMenuItem("Exit"); 
		toHome=new JMenuItem("Home"); 
		elec.addActionListener(this);    
		food.addActionListener(this);       
		exit.addActionListener(this);  
		toHome.addActionListener(this);
		
		mb=new JMenuBar();    
		home=new JMenu("Home");    
		search=new JMenu("Search");    
		about=new JMenu("About");   
		
		search.add(elec);search.add(food);
		home.add(toHome);
		home.add(exit);


		
		mb.add(home);mb.add(search);mb.add(about);       
		f.add(mb);

		f.setJMenuBar(mb);  
		
		
		
		ImageIcon image = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\bg1.png");
		JLabel label = new JLabel(image);
		panel.add(label);
		
		f.add(panel);
		f.setVisible(true); 
	}
	
	public void actionPerformed(ActionEvent e) {    
		if(e.getSource()==elec) { 
			new item_ELectric(); 
			f.dispose(); // Close a window
		}
		if(e.getSource()==food) { 
			new item_Food();
			f.dispose();  
		}
		if(e.getSource()==exit)    
			System.exit(0); // Exit all window
		if(e.getSource()==toHome)   { 
			new Home(); 
			f.dispose();  
		}
	}
	
	public static void main(String[] args) {    
	    new Home();    
	} 
}
