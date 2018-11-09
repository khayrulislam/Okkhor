package normalizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import fileManager.FileReadWriter;
import utilities.Utilities;

public class Normalizer {

	private ArrayList<Character> obj = new ArrayList<Character>(
			Arrays.asList('০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
					'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C',
					'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
					'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

	private ArrayList<String> allInputedLines;
	private ArrayList<String> linesWithoutEmptyStrings;
	private ArrayList<String> linesWithoutUnwantedCharacters;

	public void normalize() {
		allInputedLines = Utilities.READ_WRITE.readStringsFromFile(Utilities.INPUT_FILE_NAME);
		System.out.println("Size of all inputed santences = " + allInputedLines.size());
		linesWithoutEmptyStrings = getLinesWithoutEmptyString(allInputedLines);
		allInputedLines.clear();
		System.out.println("Size of all lines = " + linesWithoutEmptyStrings.size());

		
		linesWithoutUnwantedCharacters = changeUnespectedCharacters();
		

		
		Utilities.READ_WRITE.writeOutput(linesWithoutUnwantedCharacters, Utilities.OUTPUT_FILE_NAME);
		System.out.println("file writing completed");

		

	}

	private ArrayList<String> changeUnespectedCharacters() {
		
		ArrayList<String> newCorrectedVersion = new ArrayList<>();
		
		for (String string : linesWithoutEmptyStrings) {

			string = string.replace('’', ' ');
			string = string.replace('?', '।');
			string = string.replace("-", "");
			string = string.replace(".", " ");
			string = string.replace(":", "");
			string = string.replace("'/", "");
			string = string.replace("—", "");
			string = string.replace("\"", "");
			string = string.replace("”", " ");
			string = string.replace("“", " ");
			string = string.replace("‘", " ");
			string = string.replace("’", " ");
			string = string.replace("'", " ");
			string = string.replace("#", " ");
			string = string.replace("*", " ");
			string = string.replace(")", " ");
			string = string.replace("(", " ");
			string = string.replace("(", "।");
			string = string.replace(";", "।");
			string = string.replace(">", " ");
			string = string.replace("<", " ");
			string = string.replace("]", " ");
			string = string.replace("[", " ");
			string = string.replace("_", " ");
			string = string.replace("|", "।");
			string = string.replace("+", " "); 
			string = string.replace("…", "");  
			string = string.replace(";", "।");
			string = string.replace("/", " ");
			string = string.replace("=", " "); 
			string = string.replace("!", "।"); 
			string = string.replace("–", " "); 
			string = string.replace("%", " "); 

			string = string.replace("Kaljoyee", "");

			for (Character ch : obj) {
				string = string.replace(ch, ' ');
			}
			
			if(notBlankLine(string)) {
				newCorrectedVersion.add(string);
			}
		}
		
		return newCorrectedVersion;
	}

	public ArrayList<String> getLinesWithoutEmptyString(ArrayList<String> allInputedLines2) {
		ArrayList<String> lines = new ArrayList<>();
		for (String line : allInputedLines2)
			if (notBlankLine(line))
				lines.add(line);

		return lines;
	}

	public boolean notBlankLine(String st) {
		int count = 0;
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) == ' ')
				continue;
			else if (st.charAt(i) == '\n')
				continue;
			else if (st.charAt(i) == '\t')
				continue;
			else
				count++;
		}
		if (count > 0)
			return true;
		return false;
	}

	public void removeEnglishCharacters(ArrayList<String> allSentance) {
		for (String string : allSentance) {
			for (int i = 0; i < string.length(); i++) {
				if ((string.charAt(i) <= 'z' && string.charAt(i) >= 'a')
						|| (string.charAt(i) <= 'Z' && string.charAt(i) >= 'A')) {
					System.out.println("paichi");
				}
			}
		}
	}

}
