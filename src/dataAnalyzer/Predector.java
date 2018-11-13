package dataAnalyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import dataPackage.Sentence;
import utilities.Utilities;

public class Predector {

	public ArrayList<String> highestOccurence(ArrayList<String> words) {
		Map<String, Integer> wordCount = new HashMap<>();
		ArrayList<String> newList = new ArrayList<>();

		for (String str : words) {
			if (wordCount.containsKey(str)) {
				wordCount.put(str, wordCount.get(str) + 1);
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

	public ArrayList<String> getNextWord(ArrayList<String> typed) {

		ArrayList<Sentence> Gram = Utilities.ALL_GRAM.get(typed.size() + 1);
		return getNextWordList(typed, Gram);

	}

	public ArrayList<String> getNextWordFromUserType(ArrayList<String> typed) {
		ArrayList<Sentence> Gram = Utilities.USER_GRAM.get(typed.size() + 1);
		return getNextWordList(typed, Gram);
	}

	private ArrayList<String> getNextWordList(ArrayList<String> typed, ArrayList<Sentence> Gram) {

		int count = typed.size();
		ArrayList<String> nextMayBe = new ArrayList<>();

		for (Sentence sentence : Gram) {

			boolean taken = true;

			for (int i = 0; i < count; i++) {
				if (!sentence.words.get(i).equals(typed.get(i))) {
					taken = false;
				}
			}

			if (taken) {
				nextMayBe.add(sentence.words.get(count));
			}
		}
		return highestOccurence(nextMayBe);
	}

}
