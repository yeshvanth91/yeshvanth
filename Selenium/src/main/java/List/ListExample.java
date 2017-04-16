package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;


public class ListExample{

	public static void main(String[] args) {
		ArrayList<String> arrObj=new ArrayList<String>();
		LinkedList<String> linkObj=new LinkedList<String>();
		TreeSet h=new TreeSet();
		ArrayList al=new ArrayList();
		//al.add(45);
		al.add("Yeshvanth");
		al.add("A");
		//al.add(5);
		Collections.sort(al);
		Collections.reverse(al);
		for(Object count:al)
		{
			System.out.print(count+" ");
		}
		h.add("yes");
		h.add("zes");
		h.add("Yes");
		h.add("a");
		h.add("A");
		h.add("1");
		//System.out.println(h.tailSet("a"));
		System.out.println(h);
		
	}

}
