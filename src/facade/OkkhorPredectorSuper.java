package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utilities.Utilities;

public class OkkhorPredectorSuper implements OkkhorPredector {

	protected Map<String, Integer> wordCountMap;

	@Override
	public void carryPrediction() {

		//wordCountMap = new HashMap<>();
		
		wordCountMap = Utilities.READ_WRITE.getWordMap();
		
		System.out.println(wordCountMap.size());
		//System.out.println(wordCountMap.get("ফিরে"));
		
		
		maptest();
		//updateWordCountMap();

	}

	private void maptest() {
		// TODO Auto-generated method stub
		
	}

	protected void updateWordCountMap() {
		ArrayList<String> words = Utilities.READ_WRITE.readStringsFromFile(Utilities.WORD_FILE_NAME);
		
		
		// word map counter to file write 
		for (String str : words) {
			if (!wordCountMap.containsKey(str))
				wordCountMap.put(str, 1);
			else
				wordCountMap.put(str, wordCountMap.get(str) + 1);
		}

		System.out.println(wordCountMap.size());

		words = new ArrayList<>();
		for (String key : wordCountMap.keySet()) {
			words.add(key + " " + wordCountMap.get(key));
		}

		Utilities.READ_WRITE.writeOutput(words, Utilities.WORD_MAP_FILE_NAME);
		
	}

}
