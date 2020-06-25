package Project_GK_Index;

import java.util.Comparator;


public class ProductComparatorByPriceHightoLow implements Comparator<product> {

 public int compare(product o1, product o2) {
    if(o1.getPrice()>o2.getPrice()){
   return -1;
  }else if(o1.getPrice()==o2.getPrice()){
   return 0;
  }else{
   return 1;
  }
 }
public int compare1(product o1, product o2) {
	// TODO Auto-generated method stub
	return 0;
}
}