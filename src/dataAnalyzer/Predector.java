package dataAnalyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Predector {
	
	
	public ArrayList<String> highestOccurence(ArrayList<String> words) {
		Map<String, Integer> wordCount = new HashMap<>();
		ArrayList<String> newList = new ArrayList<>();
		
		for(String str: words) {
			if(wordCount.containsKey(str)) {
				wordCount.put(str, wordCount.get(str)+1);
			} else {
				wordCount.put(str, 1);
				newList.add(str);
			}
		}
		
		Comparator<String> lengthComparator = new Comparator<String>() {
    		@Override    
			public int compare(String o1, String o2) {
        		return Integer.compare(wordCount.get(o2), wordCount.get(o1));
    		}
		};
		Collections.sort(newList, lengthComparator);
		
		return newList;
	}
	
}
