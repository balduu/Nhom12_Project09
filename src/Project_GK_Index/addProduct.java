package Project_GK_Index;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;   

public class addProduct implements ActionListener{
	JFrame f;    
	JMenuBar mb;    
	JMenu home,search,about;   
	JMenuItem elec,food,exit,toHome;
	JTextField Name,Price,Saled,Rate,Address;
	JButton addFood,addDivice;
	product[] Product0, Product1;
	product[] ProductDv, ProductFd;
	private float Pricepr,Ratepr;
	private int Saledpr;
	
	addProduct() {
		read_food ps1 = new read_food();   // tao doi tuong cua lop Product
        Product1=ps1.read(); // tao 2 doi tuong product
        ProductFd = new product[100];
        System.arraycopy(Product1, 0, ProductFd, 0, Product1.length);
        
        read ps0 = new read();   // tao doi tuong cua lop Product
        Product0=ps0.read(); // tao 2 doi tuong product
        ProductDv = new product[100];
        System.arraycopy(Product0, 0, ProductDv, 0, Product0.length);
        
        f=new JFrame("Add a new product");    
		f.setLayout(null);
		f.setSize(700,700);
		
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
		
		JLabel label = new JLabel("", JLabel.CENTER);
        ImageIcon imgThisImg = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\addwpp.png");
        label.setIcon(imgThisImg);
        label.setBounds(0, 0, 700, 700);
        
		
		Name = new JTextField(30);
		Name.setBounds(180, 150, 300, 40);
		f.add(Name);
		
		Price = new JTextField(30);
		Price.setBounds(180, 200, 300, 40);
		f.add(Price);
		
		Saled = new JTextField(30);
		Saled.setBounds(180, 250, 300, 40);
		f.add(Saled);
		
		Rate = new JTextField(30);
		Rate.setBounds(180, 300, 300, 40);
		f.add(Rate);
		
		Address = new JTextField(30);
		Address.setBounds(180, 350, 300, 40);
		f.add(Address);
		
		addFood=new JButton("Add a new food");
		addFood.setBounds(110,450,200, 40);
		addFood.addActionListener(this);
		f.add(addFood);
		addDivice=new JButton("Add a new divice");
		addDivice.setBounds(360,450,200, 40);
		addDivice.addActionListener(this);
		f.add(addDivice);
		f.add(label);
		f.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
		if(e.getSource()==addFood) {
			
			if((Name.getText().length()== 0) || (Price.getText().length()== 0) || (Saled.getText().length()== 0) || 
					(Rate.getText().length()== 0) || (Address.getText().length()== 0))  {
				JOptionPane.showMessageDialog(null, "Must fill all the box");
				//System.out.println("Must fill all the box");
			}
			else {
				Pricepr = Float.parseFloat(Price.getText());
				Ratepr = Float.parseFloat(Rate.getText());
				Saledpr = Integer.parseInt(Saled.getText()); 
				for(int i = 0; i < ProductFd.length; i++) {
					if(ProductFd[i] == null) {
						ProductFd[i] = new product(Name.getText(),Pricepr,Saledpr,Ratepr, Address.getText());
						break;
					}
				}
				try {   // dat try cacth de tranh ngoai le khi tao va ghi File
					FileOutputStream f = new FileOutputStream("F:\\ZJava\\workspace\\T_virus\\store\\Food.txt");   // tao file f tro den student.dat
					ObjectOutputStream oStream = new ObjectOutputStream(f); // dung de ghi theo Object vao file f
					oStream.writeObject(ProductFd);   // ghi product electric theo kieu Object vao file
					oStream.close();
					System.out.println("New Food added");
					Name.setText("");
					Price.setText("");
					Saled.setText("");
					Rate.setText("");
					Address.setText("");
				} catch (IOException ex) {
					System.out.println("Error Write file");
				}
			}

		}
		
		if(e.getSource()==addDivice) {
			 
			if((Name.getText().length()== 0) || (Price.getText().length()== 0) || (Saled.getText().length()== 0) || 
					(Rate.getText().length()== 0) || (Address.getText().length()== 0))  {
				JOptionPane.showMessageDialog(null, "Must fill all the box");
				//System.out.println("Must fill all the box");
			}
			
			else {
				Pricepr = Float.parseFloat(Price.getText());
				Ratepr = Float.parseFloat(Rate.getText());
				Saledpr = Integer.parseInt(Saled.getText());
				for(int i = 0; i < ProductDv.length; i++) {
					if(ProductDv[i] == null) {
						ProductDv[i] = new product(Name.getText(),Pricepr,Saledpr,Ratepr, Address.getText());
						break;					
					}
				}
				try {   // dat try cacth de tranh ngoai le khi tao va ghi File
					FileOutputStream f = new FileOutputStream("F:\\ZJava\\workspace\\T_virus\\store\\Electric.txt");   // tao file f tro den student.dat
					ObjectOutputStream oStream = new ObjectOutputStream(f); // dung de ghi theo Object vao file f
					oStream.writeObject(ProductDv);   // ghi product electric theo kieu Object vao file
					oStream.close();
					System.out.println("New Divice added");
					Name.setText("");
					Price.setText("");
					Saled.setText("");
					Rate.setText("");
					Address.setText("");
	            
				} catch (IOException ex) {
					System.out.println("Error Write file");
				}				
			}
			
		}
		
	}
	
	public static void main(String[] args) {    
	    new addProduct();    
	} 
}
