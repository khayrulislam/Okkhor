package Validation;

import java.util.ArrayList;

public class InputTextNormalize {

	private String lastWord, previousText="";
	
	private ArrayList<String> wordArray = new ArrayList<>();
	
	private String spaceNormalization(String text) {
		return text.replaceAll("\\s+", " ");
	}
	
	public void normalizeText(String text) {
		
		String [] array = spaceNormalization(text).split(" ");
		lastWord = array[array.length-1];
		for(int i=0;i<array.length-1;i++) previousText += array[i]+" ";
		
		for(int i=0;i<array.length;i++) wordArray.add(array[i]);
		
	}

	public String getLastWord() {
		return lastWord;
	}

	public String getPreviousText() {
		return previousText;
	}
	
	public ArrayList<String> getWordList(){
		return this.wordArray;
	}
	
	
}
