package com.hsbc.collections.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class ListMain {

	public static void main(String[] args) {
		
		TreeSet<String> lst = new TreeSet<String>();
		lst.add("Chennai");
		lst.add("Hyderabad");
		lst.add("Chennai");
		lst.add("Delhi");
		lst.add("Kochi");
			
 
//	Iterator<String> it = lst.iterator();
//	
//	while(it.hasNext()) {
//		System.out.println(it.next());
//	}
	
	for(String x:lst) {
		System.out.println(x);
	}
		
	
		

	}

}
