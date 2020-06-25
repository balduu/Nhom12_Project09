package Project_GK_Index;

import java.util.Comparator;


public class ProductComparatorByRate implements Comparator<product> {

 public int compare(product o1, product o2) {
    if(o1.getRate()>o2.getRate()){
   return -1;
  }else if(o1.getRate()==o2.getRate()){
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