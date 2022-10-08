package kai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    
  // to store object name
  String obj_name;
    
  public Test(String obj_name) 
  {
      this.obj_name = obj_name;
  }
    
  static void show()
  {
      //object t1 inside method becomes unreachable when show() removed
      Test t1 = new Test("t1"); 
      display();
      System.gc();
        
  }
  static void display()
  {
      //object t2 inside method becomes unreachable when display() removed
      Test t2 = new Test("t2"); 
      
  }
    
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        String name = reader.readLine();

        // Printing the read line
        System.out.println(name);
        
/*	    Test a = new Test("a");

	    List< Test > b = new ArrayList< Test >();
	    b.add( a );


	    String c = a.toString();

	    a = null;
	    b = null;	    
	    System.gc();
	    c = null;
*/


        // calling show()
        //show();
        // calling garbage collector
 	}
	
    protected void finalize() throws Throwable 
    {
        // will print name of object
        System.out.println(this.obj_name + " successfully garbage collected");
    }


}
