package dataAnalyzer;

import java.util.ArrayList;

import dataPackage.Sentence;
import sun.awt.windows.WToolkit;
import utilities.Utilities;

public class Gram_Converter {

	public void convertAndWrite(String string) {

		ArrayList<ArrayList<Sentence>> Gram = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			ArrayList<Sentence> t1 = new ArrayList<>();
			Gram.add(t1);
		}

		for (int gram = 2; gram <= Utilities.MAX_GRAM; gram++) {
			String[] splited = string.split(" ");
			for (int i = 0; i < splited.length - gram + 1; i++) {
				ArrayList<String> words = new ArrayList<>();
				Sentence sentence = new Sentence(words);
				int maxi = Math.min(splited.length, i + gram);
				for (int j = i; j < maxi; j++) {
					sentence.words.add(splited[j]);
				}

				 Gram.get(gram).add(sentence);
			}

		}

		for(int i = 2; i <= Utilities.MAX_GRAM; i++) {
			ArrayList<Sentence> tempList = Gram.get(i);
			for(Sentence sentence: tempList) {
				String strToAppend = sentence.words.get(0);
				for(int t = 1; t < sentence.words.size(); t++) 
					strToAppend = strToAppend + " " + sentence.words.get(t);
				Utilities.READ_WRITE.appendInFile(Utilities.GRAM_FILENAME.get(i), strToAppend);
			}
			
		}
	}

}
