package Validation;

import java.util.ArrayList;

import Utils.Util;

public class InputTextNormalize {

	private String lastWord, previousText="";
	private boolean validText;
	
	private ArrayList<String> wordArray = new ArrayList<>();
	
	private String spaceNormalization(String text) {
		return text.replaceAll("\\s+", " ");
	}
	
	public InputTextNormalize() {
		this.validText = true;
	}

	public void normalizeText(String text) {
		
		
		for(int i=0;i<text.length();i++) {
			if(!Util.BANGLE_LETTER.contains(String.valueOf(text.charAt(i)))) {
				validText = false;
				break;
			}
		}
		
		String [] array = spaceNormalization(text).split(" ");
		lastWord = array[array.length-1];
		
		for(int i=0;i<array.length-1;i++) previousText += array[i]+" ";
		
		for(int i=0;i<array.length;i++) wordArray.add(array[i]);
		
	}

	public boolean isValidText() {
		return this.validText;
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
