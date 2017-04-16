package List;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;

class countCharacter_String{
	public static void main(String[] args)
	{
		String input="&Amazon India1 PVT LTD";
		input=input.toLowerCase();
		input=input.replaceAll(" ","");
		LinkedList<String> s=new LinkedList<String>();
		String[] c=input.split("");
		for(String temp:c)
		{
			s.add(temp);
		}
		Collections.sort(s);
		/*Collections.reverse(s);*/
		System.out.println(Collections.binarySearch(s,"z"));
		System.out.println(s);
		System.out.println("Duplicate Occurence in the given String is"+(c.length-s.size()));
	}
}