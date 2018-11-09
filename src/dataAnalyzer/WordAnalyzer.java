package dataAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utilities.Utilities;

public class WordAnalyzer {
	
	
	public void test() {
		ArrayList<String> words = Utilities.READ_WRITE.readStringsFromFile(Utilities.WORD_FILE_NAME);
		ArrayList<String> output = new ArrayList<>();
		Map<String, Integer> wordCount = new HashMap<>();
		
		String string = "চা";
		
		for(String str: words)
			if(str.startsWith(string))
				output.add(str);
		
		for(String str: output) {
			if(!wordCount.containsKey(str)) 
				wordCount.put(str, 1);
			else wordCount.put(str, wordCount.get(str)+1);
		}
		
		
		for (String key : wordCount.keySet()) {
			int count = wordCount.get(key);
		    output.add(key + " is occured \t\t" + count );
		}
		
		
		/*
		String s = "সবচেয়ে";
		System.out.println(s);
		
		int n = s.length();
		
		System.out.println(n);
		for(int i = 0; i < n; i++) {
			System.out.println(s.charAt(i));
		}*/
		
		Utilities.READ_WRITE.writeOutput(output, Utilities.OUTPUT_FILE_NAME);
		
		
	}

}
