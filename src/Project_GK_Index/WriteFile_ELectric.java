package Project_GK_Index;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class WriteFile_ELectric extends product {
    public static void main(String args[]) throws Exception {
    	ProcessProduct ps = new ProcessProduct();   // tao doi tuong cua lop ProcessStudent
        product[] product1 = null; // tao 2 doi tuong product
        product1 = ps.creat();  // nhap product
        ps.write(product1);     // viet vao file
   
    }
}

class ProcessProduct{
	 
    public product[] creat() {      // Input the data from Keyboard
        int n;
        Scanner scan = new Scanner(System.in);
 
        System.out.println("Enter number of product: ");
        n = Integer.parseInt(scan.nextLine());  //nhap so luong SP
 
        product[] Product = new product[n];
 
        for (int i = 0; i < n; i++) {
        	
            System.out.println("Enter name: ");   // nhap ten sp thu i
            String name = scan.nextLine();
            System.out.println("Enter price :");
            float price= Float.parseFloat(scan.nextLine());
            System.out.println("Enter saled :");
            int saled=Integer.parseInt(scan.nextLine());
            System.out.println("Enter rate: ");    // nhap rate
            float rate = Float.parseFloat(scan.nextLine());    // tranh troi lenh nhu khi dung scan.nextInt()
            System.out.println("Enter address: ");   // nhap addr sp thu i
            String addr = scan.nextLine();
            Product[i] = new product(name,price,saled,rate, addr);    // khoi tao doi tuong product thu i
        }
        scan.close();
        return Product;
    }
 
    public void write(product[] Product) {  //ghi theo Object
        try {   // dat try cacth de tranh ngoai le khi tao va ghi File
            FileOutputStream f = new FileOutputStream("F:\\ZJava\\workspace\\T_virus\\raconcity\\Electric.txt");   // tao file f tro den student.dat
            ObjectOutputStream oStream = new ObjectOutputStream(f); // dung de ghi theo Object vao file f
            oStream.writeObject(Product);   // ghi product electric theo kieu Object vao file
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
        }
    }

}
 