package normalizer;

import java.util.ArrayList;

public class Normalizer {
	
	
	public void removeEnglishCharacters(ArrayList<String> allSentance) {
		for (String string: allSentance) {
			for(int i = 0; i < string.length(); i++) {
				if((string.charAt(i) <= 'z' && string.charAt(i) >= 'a') || (string.charAt(i) <= 'Z' && string.charAt(i) >= 'A')) {
					System.out.println("paichi");
				}
			}
		}
	}

	public boolean notBlankLine(String st) {
		int count = 0;
		for(int i = 0; i < st.length(); i++) {
			if(st.charAt(i) == ' ')
				continue;
			else if(st.charAt(i) == '\n')
				continue;
			else if(st.charAt(i) == '\t')
				continue;
			else 
				count++;
		}
		if(count > 0) return true;
		return false;
	}
	
	
}
