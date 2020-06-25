package Project_GK_Index;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;

public class ReadFile_ELectric extends JFrame { //implements Comparable {
    public static void main(String args[]) throws Exception {     
    }
    /*
	@Override
	public void compare() {
		// TODO Auto-generated method stub
		
	}
	*/
}
class  read{
 
    public product[] read() {      
    	 product[] Product = null;
        try {  
            FileInputStream f = new FileInputStream("F:\\ZJava\\workspace\\T_virus\\store\\Electric.txt"); // tao file f tro den student.dat
            ObjectInputStream inStream = new ObjectInputStream(f);  // dung de doc theo Object vao file f
            // dung inStream doc theo Object, ep kieu tra ve la product
            Product = (product[]) inStream.readObject();
            inStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error Read file");
        }
        return Product;
    }
}

