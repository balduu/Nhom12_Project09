package Project_GK_Index;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ComboBoxUI;

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
import java.util.Scanner;  

//extends ReadFile_Food
public class item_Food implements ActionListener {
	JFrame f;    
	JMenuBar mb;    
	JMenu home,search,about;   
	JMenuItem elec,food,exit,toHome;     
	JTextArea ta; 
	JTextField Text;
	JButton find,Orrate,Orcost,Orsaled;
	JPanel panel;
	JPanel panel2;
	JTable table;
	JScrollPane scrtbl;
	ArrayList<product> list = new ArrayList<product>();;
	JLabel labelfind;
	product[] Product;
	String[][] rec = new String[100][5];
	JButton b=new JButton("Show");
	String[] items = {"UP","DOWN"};
	String keyword;
	
	final JComboBox combo=new JComboBox(items);
	
	item_Food() {
		
		read_food ps = new read_food();   // tao doi tuong cua lop Product
        Product=ps.read(); // tao 2 doi tuong product
        
        
		f=new JFrame("We need Food");    
		f.setLayout(new GridLayout(1, 2));
		f.setSize(1350,700); 
		
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
		  
		Text = new JTextField(30);
		Text.setBounds(20, 200, 500, 40);
		f.add(Text);
		
		Icon icon = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\searchb2.png");
		find=new JButton(icon);
		find.setBounds(60,270,200, 40); 
		find.addActionListener(this);
		f.add(find);
		
		Orrate=new JButton("Order by rate");
		Orrate.setBounds(20,350,200, 40);
		Orrate.addActionListener(this);
		
		Orcost=new JButton("Order by cost"); 
		Orcost.setBounds(230,350,200, 40);
		Orcost.addActionListener(this);
		
		Orsaled=new JButton("Order by saled"); 
		Orsaled.setBounds(440,350,200, 40);
		Orsaled.addActionListener(this);
		
		combo.setBounds(230,400,100,40);
		
		panel = new JPanel();
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), 
        		"We need food", TitledBorder.RIGHT, TitledBorder.TOP));
        Color bgColor = new Color(229,255,204);
        panel.setBackground(bgColor);
      
        
        labelfind = new JLabel("", JLabel.CENTER);
        labelfind.setForeground(Color.blue);
		//labelfind.setText("*******************Ket qua tim kiem cho [************");
	
        
        String[][] rec = {
        { " ", " ", " ", " ", " "},
        };
        String[] header = { "*", "*", "*", "*", "*" };
        table = new JTable(rec, header);
        scrtbl = new JScrollPane(table);
        
        JLabel label = new JLabel("", JLabel.CENTER);
        ImageIcon imgThisImg0 = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\title2.png");
        label.setIcon(imgThisImg0);
        
        label.setBounds(20, 40, 600, 100);
        
        JLabel label2 = new JLabel("", JLabel.CENTER);
        ImageIcon imgThisImg = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\search2.png");
        label2.setIcon(imgThisImg);
        label2.setBounds(520, 200, 40, 40);
        
        JLabel label3 = new JLabel("", JLabel.CENTER);
        ImageIcon imgThisImg2 = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\bgfood.png");
        label3.setIcon(imgThisImg2);
        label3.setBounds(0, 0, 700, 1000);
        
        
        panel2.setLayout(null);
        panel2.add(label);
        panel2.add(label2);
        
        panel2.add(Text);
	 	panel2.add(find);
		panel2.add(Orrate);
		panel2.add(Orcost); 
		panel2.add(Orsaled);
		panel.add(labelfind);
		panel2.add(combo);
		
		panel2.add(label3);
		panel.add(scrtbl);
		
		f.add(panel);
		f.add(panel2);
	       
		f.setVisible(true); 
	}

	
	

	private product product(String string, double d, int i, double e, String string2) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==elec) {   
			new item_ELectric();
			f.dispose();  
		}
		if(e.getSource()==food)  {  
			new item_Food();
			f.dispose();    
		}
		if(e.getSource()==exit)    
			System.exit(0); 
		if(e.getSource()==toHome)  { 
			new Home();
			f.dispose();  
		}
		
		// Print result 
		
		if(e.getSource()== find) {
		
			
			String NameFind;
			int check =0;
			list = new ArrayList<product>();
			String[][] rec = new String[100][5];
			
			for(product s: Product)
			{	
					String saled = null;
					String price=null;
					String rate=null;
					if(s == null)
						break;
					NameFind=s.getName();
					if(NameFind.toLowerCase().contains(Text.getText().toLowerCase())==true)
					{
						list.add(s);
						check = 1;
					for(int a=0;a<list.size();a++)
					{
						saled=Integer.toString(list.get(a).getSaled());
						price=Float.toString(list.get(a).getPrice());
						rate=Float.toString(list.get(a).getRate());
						int i=0;
					rec[a][i]=list.get(a).getName();
					i++;
					rec[a][i]=price;
					i++;
					rec[a][i]=saled;
					i++;
					rec[a][i]=rate;
					i++;
					rec[a][i]=list.get(a).getAddr();
					}
					}
				
			}
			keyword	= Text.getText();
	    	Text.setText("");
			String[] header = {  "Name", "Price","Saled", "Rate", "Address" };
			
			JTable table = new JTable(rec, header);
			panel.remove(scrtbl);
			panel.remove(labelfind);
			
			scrtbl = new JScrollPane(table);
			labelfind.setText("*******************KET QUA TIM KIEM CHO [ "+keyword+" ]*******************");
			if(check == 0)
				{
					labelfind.setText("******************KHONG TIM THAY KET QUA !*********************");
				}
			panel.add(labelfind);
			panel.add(scrtbl);
			
			for(int a=0;a<list.size();a++)
			{
				System.out.println(list.get(a).getName());
			}
			
			f.setVisible(true); 	
			
			}
		
		// Print result order by rate ( low to high)
		
		if(e.getSource()== Orrate) {
			
			
					String[][] rec = new String[100][5];
				
					String saled = null;
					String price=null;
					String rate=null;
					Collections.sort(list,new ProductComparatorByRate());
					
					for(int a=0;a<list.size();a++)
					{
						saled=Integer.toString(list.get(a).getSaled());
						price=Float.toString(list.get(a).getPrice());
						rate=Float.toString(list.get(a).getRate());
						int i=0;
						rec[a][i]=rate;
						i++;
						rec[a][i]=list.get(a).getName();
						i++;
						rec[a][i]=price;
						i++;
						rec[a][i]=saled;
						i++;
						rec[a][i]=list.get(a).getAddr();
						
					}
			
			String[] header = { "Rate", "Name", "Price","Saled", "Address" };
			
			JTable table = new JTable(rec, header);
			panel.remove(scrtbl);
			
			scrtbl = new JScrollPane(table);
			panel.add(scrtbl);
			
			labelfind.setText("******************* SAP XEP THEO DANH GIA CHO KET QUA TIM KEM  ["+keyword+"]******************");
			f.setVisible(true); 	
			
		}
		// Print result order by cost ( low to high)
		
		if(e.getSource()== Orcost) {
			panel.remove(combo);
			
			if(combo.getSelectedItem()=="UP")	
			{
					String[][] rec = new String[100][5];	
					String saled = null;
					String price=null;
					String rate=null;
					Collections.sort(list,new ProductComparatorByPrice());
					
					for(int a=0;a<list.size();a++)
					{
						saled=Integer.toString(list.get(a).getSaled());
						price=Float.toString(list.get(a).getPrice());
						rate=Float.toString(list.get(a).getRate());
						int i=0;
						rec[a][i]=price;
						i++;
						rec[a][i]=list.get(a).getName();
						i++;
						rec[a][i]=saled;
						i++;
						rec[a][i]=rate;
						i++;
						rec[a][i]=list.get(a).getAddr();	
					}
			
			String[] header = { "Price", "Name", "Saled","Rate", "Address" };
			JTable table = new JTable(rec, header);
			panel.remove(scrtbl);
			scrtbl = new JScrollPane(table);
			
			panel.add(scrtbl);
			
			labelfind.setText("******************* SAP XEP THEO GIA SAN PHAM CHO KET QUA TIM KEM  ["+keyword+"]****************** ");	
			
			f.setVisible(true); 	
			
			}
			if(combo.getSelectedItem()=="DOWN")
			{
				String[][] rec = new String[100][5];	
				String saled = null;
				String price=null;
				String rate=null;
				Collections.sort(list,new ProductComparatorByPriceHightoLow());
				
				for(int a=0;a<list.size();a++)
				{
					saled=Integer.toString(list.get(a).getSaled());
					price=Float.toString(list.get(a).getPrice());
					rate=Float.toString(list.get(a).getRate());
					int i=0;
					rec[a][i]=price;
					i++;
					rec[a][i]=list.get(a).getName();
					i++;
					rec[a][i]=saled;
					i++;
					rec[a][i]=rate;
					i++;
					rec[a][i]=list.get(a).getAddr();	
				}
		
		String[] header = { "Price", "Name", "Saled","Rate", "Address" };
		JTable table = new JTable(rec, header);
		panel.remove(scrtbl);
		scrtbl = new JScrollPane(table);
		
		panel.add(scrtbl);
		
		labelfind.setText("******************* SAP XEP THEO GIA SAN PHAM CHO KET QUA TIM KEM  ["+keyword+"]****************** ");	
		
		f.setVisible(true); 	
			}
		}
		// Print result order by rate ( low to high)
		
				if(e.getSource()== Orsaled) {
						
					panel.remove(combo);
					String[][] rec = new String[100][5];
						
							String saled = null;
							String price=null;
							String rate=null;
							Collections.sort(list,new ProductComparatorByRate());
							
							for(int a=0;a<list.size();a++)
							{
								saled=Integer.toString(list.get(a).getSaled());
								price=Float.toString(list.get(a).getPrice());
								rate=Float.toString(list.get(a).getRate());
								int i=0;
								rec[a][i]=saled;
								i++;
								rec[a][i]=list.get(a).getName();
								i++;
								rec[a][i]=price;
								i++;
								rec[a][i]=rate;
								i++;
								rec[a][i]=list.get(a).getAddr();
							}
					
					String[] header = { "Saled", "Name", "Price","Rate", "Address" };
					
					JTable table = new JTable(rec, header);
					panel.remove(scrtbl);
					
					scrtbl = new JScrollPane(table);
					panel.add(scrtbl);
					labelfind.setText("******************* SAP XEP THEO DOANH SO CHO KET QUA TIM KEM  ["+keyword+"]******************");
					f.setVisible(true); 	
					}
		}
	


	public static void main(String[] args) {    
		
		new item_Food();    
	}
}



	