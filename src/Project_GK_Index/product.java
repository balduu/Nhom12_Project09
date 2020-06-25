package Project_GK_Index;

import java.io.Serializable;

public class product implements Serializable {

	private String name;
	private float price;
	private int saled;
	private float rate;
	private String addr;
	
	public product(){
	// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSaled() {
		return saled;
	}
	public void setSaled(int saled) {
		this.saled = saled;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public product(String name,float price,int saled,float rate,String addr)
	{
		this.name=name;
		this.price=price;
		this.saled=saled;
		this.rate=rate;
		this.addr=addr;
	}
	/*
	public product(String name,double price,int saled,double rate,String addr)
	{
		this.name=name;
		this.price=(float)price;
		this.saled=saled;
		this.rate=(float)rate;
		this.addr=addr;
	}
	*/
	public void Compare() {
		// TODO Auto-generated method stub
		
	}
	
}
