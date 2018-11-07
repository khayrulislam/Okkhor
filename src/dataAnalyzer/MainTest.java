package dataAnalyzer;

import java.util.ArrayList;

import utilities.Utilities;

public class MainTest {

	public static void main(String[] args) {
		
		
		ArrayList<String> allWords = Utilities.READ_WRITE.readStringsFromFile(Utilities.WORD_FILE_NAME);
		
		
		
		
		
		
		
		
		
		
		Utilities.READ_WRITE.writeOutput(allWords, Utilities.OUTPUT_FILE_NAME);
		
		
		

	}

}
