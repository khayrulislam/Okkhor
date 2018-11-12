package Factory;

import java.util.HashMap;

import Utils.Util;

public class FactoryClass {

	public static HashMap<Character, Integer> letterIndex = new HashMap<>();
	public static HashMap<Integer, Character> indexLetter = new HashMap<>();
	
	public FactoryClass() {
		inilialize();
	}
	
	private void inilialize() {
		
		for(int i=0;i<Util.BANGLE_LETTER.length();i++) {
			letterIndex.put(Util.BANGLE_LETTER.charAt(i), i);
			indexLetter.put(i, Util.BANGLE_LETTER.charAt(i));
		}
		
		//for(char ch : letterIndex.keySet()) System.err.println(ch + "******************"+letterIndex.get(ch));
	}
	
}
