package dataAnalyzer;

import java.util.ArrayList;
import utilities.Utilities;

public class WordAnalyzer {
	
	
	public void test() {
		ArrayList<String> words = Utilities.READ_WRITE.readStringsFromFile(Utilities.WORD_FILE_NAME);
		ArrayList<String> output = new ArrayList<>();
		
		String string = "";
		
		/*for(String str: words)
			if(str.startsWith(string))
				output.add(str);
		*/
		
		String s = "সবচেয়ে";
		System.out.println(s);
		
		int n = s.length();
		
		System.out.println(n);
		for(int i = 0; i < n; i++) {
			System.out.println(s.charAt(i));
		}
		
		//Utilities.READ_WRITE.writeOutput(output, Utilities.OUTPUT_FILE_NAME);
		
		
	}

}
