package List;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class character_Largest_Occurence{

	public static void main(String[] args) {
		int maxValue;
		int secondMaxValue;
		String input="Amazon India &@9 Develo123pment Centre";
		input=input.replaceAll(" ","");
		input=input.replaceAll("[^a-zA-z]+","");
		char[] inputCharArray=input.toCharArray();
		LinkedHashMap<Character,Integer> lMap=new LinkedHashMap<Character,Integer>();
		for(Character c:inputCharArray)
		{
			if(!lMap.containsKey(c))
			{
				lMap.put(c,1);
			}
			else
			{
				lMap.put(c,(lMap.get(c)+1));
			}
		}
		System.out.println(lMap);
		LinkedList<Integer> lList=new LinkedList<Integer>(lMap.values());
		Collections.sort(lList);
		Collections.reverse(lList);
		maxValue=lList.get(0);
		secondMaxValue=lList.get(1);
		System.out.println("Max Values is"+maxValue);
		for(Entry<Character,Integer> en:lMap.entrySet())
		{
			if(en.getValue()==maxValue)
			{
				System.out.println("Maximum Occurence Of Charcter is  "+en.getKey()+" occured  "+en.getValue()+"  times");
			}
			if(en.getValue()==secondMaxValue)
			{
				System.out.println("Second Maximum Occurence Of Charcter is  "+en.getKey()+" occured  "+en.getValue()+"  times");
			}
		}
	}
}


