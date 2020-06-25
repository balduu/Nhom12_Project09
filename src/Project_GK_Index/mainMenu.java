package Project_GK_Index;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*; 
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class mainMenu implements ActionListener{
	JFrame f;    
	JPanel panel;    
	JLabel bglabel, label;
	JTextArea ta; 
	JTextField Text;
	JButton theme, elec, food, about, more, exit, play, add;
	
	mainMenu() {
		f=new JFrame("Console");    		
		f.setSize(630,430); 
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\ZJava\\workspace\\T_virus\\Image\\icon.png"));

		panel = new JPanel();
		panel.setLayout(null);
		
		ImageIcon bgimage = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\bgmenu.png");
		bglabel = new JLabel(bgimage);
		bglabel.setBounds(0, 0, 630, 430);

		Icon icon0 = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\playb.png");
		play=new JButton(icon0);
		play.setBounds(0,0,450, 200); 
		play.addActionListener(this);
		
		Icon icon1 = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\menutheme.png");
		theme=new JButton(icon1);
		theme.setBounds(480,0,100, 100); 
		theme.addActionListener(this);
		
		Icon icon2 = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\menuelec.png");
		elec=new JButton(icon2);
		elec.setBounds(0,230,150, 150); 
		elec.addActionListener(this);
		
		Icon icon3 = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\menufood.png");
		food=new JButton(icon3);
		food.setBounds(150,230,150, 150); 
		food.addActionListener(this);
		
		Icon icon4 = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\menuexit.png");
		exit=new JButton(icon4);
		exit.setBounds(480,200,100, 100); 
		exit.addActionListener(this);
		
		Icon icon5 = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\menuabout.png");
		about=new JButton(icon5);
		about.setBounds(300,230,150, 150); 
		about.addActionListener(this);
		
		Icon icon6 = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\menumore.png");
		more=new JButton(icon6);
		more.setBounds(480,100,100, 100); 
		more.addActionListener(this);
		
		Icon icon7 = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\menuadd.png");
		add=new JButton(icon7);
		add.setBounds(480,300,100, 100);
		add.addActionListener(this);
		
		
		panel.add(theme);
		panel.add(elec);
		panel.add(food);
		panel.add(about);
		panel.add(more);
		panel.add(exit);
		panel.add(play);
		f.add(add);
		panel.add(bglabel);
		
		f.add(panel);
		f.setVisible(true);
 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==play) {   
			new Snake();
		}
		
		if(e.getSource()==elec) {   
			new item_ELectric();
		}
		if(e.getSource()==food) {   
			new item_Food();
		}
		if(e.getSource()==theme) {   
			new Home(); 
		}
		if(e.getSource()==about) {   
			try {
			     if (Desktop.isDesktopSupported()) {
			       Desktop.getDesktop().open(new File("C:\\Users\\PC\\Desktop\\Project Java\\BaoCaoBTL.doc"));
			     }
			   } catch (IOException ioe) {
			     ioe.printStackTrace();
			  } 
		}
		if(e.getSource()==more) {   
			try {
				   
				   URI uri= new URI("https://websosanh.vn/");
				   
				   java.awt.Desktop.getDesktop().browse(uri);
				    System.out.println("Web page opened in browser");
				 
				  } catch (Exception ex) {
				   
				   ex.printStackTrace();
				  }
			 
		}
		if(e.getSource()==add) {   
			new addProduct(); 
		}
		
		if(e.getSource()==exit) {   
			System.exit(0); 
		}
	}
	
	public static void main(String[] args) {    
	    new mainMenu();    
	} 
 
 
}

