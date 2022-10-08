package kai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

public class javaCollection {

	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>();  
		al.add("Viru");  
		al.add("Saurav");  
		al.add("Mukesh");  
		al.add("Tahir");  

		Iterator itr=al.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		 }  
		
		System.out.println("<== Sorted ==>");  
		
		Collections.sort(al);  
		Iterator itrs=al.iterator();  
		while(itrs.hasNext()){  
		System.out.println(itrs.next());  
		 }  

		System.out.println("<== Sorted rev==>");  

        Collections.sort(al,Collections.reverseOrder());  
		Iterator itrev=al.iterator();  
		while(itrev.hasNext()){  
		System.out.println(itrev.next());  
		 }  	
	}
		/*
		// Create a list		
        List<Domain> l = new ArrayList<Domain>();
        l.add(new Domain(10, "quiz.geeksforgeeks.org"));
        l.add(new Domain(20, "practice.geeksforgeeks.org"));
        l.add(new Domain(30, "code.geeksforgeeks.org"));
        l.add(new Domain(40, "www.geeksforgeeks.org"));
  
        l.add(new Domain(10, "A"));
        l.add(new Domain(20, "B"));
        l.add(new Domain(30, "C"));
        l.add(new Domain(40, "D"));

        Comparator<Domain> c = new Comparator<Domain>() {
            public int compare(Domain u1, Domain u2)
            {
                return u1.getId().compareTo(u2.getId());
            }
        };

        Comparator<Domain> ul = new Comparator<Domain>() {
            public int compare(Domain u1, Domain u2)
            {
                return u1.getURL().compareTo(u2.getURL());
            }
        };
  
        // Searching a domain with key value 10. To search
        // we create an object of domain with key 10.
        int index = Collections.binarySearch(l, new Domain(10, null), c);
        System.out.println("Found at index1  " + index);
  
        // Searching an item with key 5
        index = Collections.binarySearch(l, new Domain(30, null), c);
        System.out.println("Found at index2  " + index);

        index = Collections.binarySearch(l, new Domain(0, "C"), ul);
        System.out.println("Found at index3  " + index);
       */
        
}
