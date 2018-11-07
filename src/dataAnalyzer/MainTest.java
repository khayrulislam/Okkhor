package dataAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utilities.Utilities;

public class MainTest {

	public static void main(String[] args) {

		ArrayList<String> allWords = Utilities.READ_WRITE.readStringsFromFile(Utilities.WORD_FILE_NAME);

		Map<String, Integer> wordCount = new HashMap<>();
		int totalWord = allWords.size();
		
		
		for(String str: allWords) {
			if(!wordCount.containsKey(str)) 
				wordCount.put(str, 1);
			else wordCount.put(str, wordCount.get(str)+1);
		}
		
		ArrayList<String> output = new ArrayList<>();
		
		
		for (String key : wordCount.keySet()) {
			int count = wordCount.get(key);
		    output.add(key + " is occured \t\t" + count + " frequency is \t\t" + ((double)count/totalWord)*100 + "%");
		}
		
		
		Utilities.READ_WRITE.writeOutput(output, Utilities.OUTPUT_FILE_NAME);

	}

}
