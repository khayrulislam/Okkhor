package dataAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import utilities.Utilities;

public class Counter {
	private Map<String, Integer> wordCount;
	private java.util.Scanner scanner;

	public Counter() {
		wordCount = new HashMap<>();
	}
	
	
	public void wordTest() {
		initCounter();
	}


	private void initCounter() {
		ArrayList<String> words = Utilities.READ_WRITE.readStringsFromFile(Utilities.WORD_FILE_NAME);
		
		for(String str: words) {
			if(!wordCount.containsKey(str)) 
				wordCount.put(str, 1);
			else wordCount.put(str, wordCount.get(str)+1);
		}
		
		scanner = new java.util.Scanner(System.in);
		String line = null;
		
		while(true) {
			System.out.print("এখানে  লিখুন: ");
			line = scanner.nextLine();
			
			ArrayList<String> selected = new ArrayList<>();
			for (String key : wordCount.keySet()) {
				if(key.startsWith(line)) 
					selected.add(key);
			}
			
			Comparator<String> lengthComparator = new Comparator<String>() {
	    		@Override    
				public int compare(String o1, String o2) {
	        		return Integer.compare(wordCount.get(o2), wordCount.get(o1));
	    		}
			};
			
			Collections.sort(selected, lengthComparator);
			
			System.out.println("অনুমান ********");
			System.out.println("________________________");
			
			
			int limit = Math.min(20, selected.size());
			
			for(int i = 0; i < limit; i++) {
				String temp = selected.get(i);
				System.out.println(temp+ "     " + wordCount.get(temp));
			}
			
			System.out.println("***********************");
			
			 
		}
				
				
		
	}
	

}
