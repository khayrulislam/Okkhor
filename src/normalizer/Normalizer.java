package normalizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import dataPackage.Sentence;
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
	private ArrayList<String> allSentences;
	private ArrayList<String> allWords;
	private ArrayList<Sentence> sentenceList;
	private ArrayList<String> output;
	
	public void normalize() {
		allInputedLines = Utilities.READ_WRITE.readStringsFromFile(Utilities.INPUT_FILE_NAME);
		System.out.println("Size of all inputed santences = " + allInputedLines.size());
		
		linesWithoutEmptyStrings = getLinesWithoutEmptyString(allInputedLines);
		allInputedLines.clear();
		System.out.println("Size of all lines = " + linesWithoutEmptyStrings.size());
		
		linesWithoutUnwantedCharacters = changeUnespectedCharacters();
		linesWithoutEmptyStrings.clear();
		allSentences = getSentances(linesWithoutUnwantedCharacters);
		
		sentenceList = getSentenceList(allSentences);
		allSentences.clear();
		
		writeSentancesInfile();
		writeWordsInfile();
		//Utilities.READ_WRITE.writeOutput(allSentences, Utilities.OUTPUT_FILE_NAME);
	}

	

	private void writeWordsInfile() {
		output = new ArrayList<>();
		for(Sentence sentence: sentenceList) 
			for(String word: sentence.words) 
				output.add(word);
		
		Utilities.READ_WRITE.writeOutput(output, Utilities.WORD_FILE_NAME);
	}



	private void writeSentancesInfile() {
		output = new ArrayList<>();
		for(Sentence sentence: sentenceList) {
			int n = sentence.words.size();
			String out = sentence.words.get(0);
			for(int i = 1; i < n; i++) {
				out = out + " " + sentence.words.get(i);
			}
			output.add(out);
		}
		
		Utilities.READ_WRITE.writeOutput(output, Utilities.SENTENCE_FILE_NAME);
	}



	public ArrayList<Sentence> getSentenceList(ArrayList<String> allSentences2) {
		ArrayList<Sentence> sentenceses= new ArrayList<>();

		for(String str: allSentences2) {
			ArrayList<String> words = new ArrayList<>();
			String[] tempList = str.split(" ");
			for(String tempWords: tempList) {
				if(notBlankLine(tempWords)) {
					String tw = tempWords.trim();
					words.add(tw);
				}
			}
			sentenceses.add(new Sentence(words));
		}
		
		return sentenceses;
	}



	private ArrayList<String> getWords(ArrayList<String> allSentences2) {
		ArrayList<String> splitedWordList = spliter(allSentences2, " ");
		ArrayList<String> wordList = new ArrayList<>();
		
		for(String str: splitedWordList) {
			if(notBlankLine(str)) {
				String temp = str.trim();
				wordList.add(temp);
			}
		}
		
		
		return wordList;
	}



	private ArrayList<String> getSentances(ArrayList<String> linesWithoutUnwantedCharacters2) {
		
		ArrayList<String> splitedSentances = spliter(linesWithoutUnwantedCharacters2, "।");
		ArrayList<String> allSantences = new ArrayList<>();
		
		for(String str: splitedSentances) {
			if(notBlankLine(str)) {
				String temp = str.trim();
				allSantences.add(temp);
			}
		}
		splitedSentances.clear();
		
		return allSantences;
	}
	
	private static ArrayList<String> spliter(ArrayList<String> sentence, String splitr) {
		ArrayList<String> newSetnence = new ArrayList<>();

		for (String str : sentence) {
			String [] splitedSentences = str.split(splitr);
			for(String miniSantence: splitedSentences)
				newSetnence.add(miniSantence);
		}

		return newSetnence;
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
			string = string.replace(",", "।"); 
			
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
