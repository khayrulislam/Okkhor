package normalizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class NormalizerMain {

	private static final String FILENAME = "test.txt";
	public static final String OUTPUT_FILE = "output_version_001.txt";
	
	
	public static void main(String[] args) {
		ArrayList<String> allSantence = new ArrayList<>();
		ArrayList<String> sentanceWithoutEmptyStrings = new ArrayList<>();
		Normalizer normalizer = new Normalizer();
		
		ArrayList<Character> obj = new ArrayList<Character>(
			      Arrays.asList('০','১','২','৩','৪','৫','৬','৭','৮','৯','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', '0', '1', '2', '3', '4', '5', '6', '7', '8','9'));
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				allSantence.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(allSantence.size());
		
		
		
		
		for (String string: allSantence) {
			
			string=string.replace('?', '।');
			string=string.replace("-","");
			string=string.replace(".","");
			string=string.replace(":","");
			string=string.replace("'/","");
			string=string.replace("—","");
			string=string.replace("\"","");
			string=string.replace("”"," ");
			string=string.replace("“"," ");
			string=string.replace("‘"," ");
			string=string.replace("’"," ");
			string=string.replace("'"," ");
			string=string.replace("#"," ");
			string=string.replace("*"," ");
			string=string.replace(")"," ");
			string=string.replace("("," ");
			string=string.replace("(","।");
			string=string.replace(";","।");
			
			string=string.replace("…","");
			
			string=string.replace("–","");
			
			string=string.replace("Kaljoyee","");
			
			for(Character ch: obj) {
				string=string.replace(ch,' ');
			}
			
			
			
			if(normalizer.notBlankLine(string)) {
				sentanceWithoutEmptyStrings.add(string);
			}
		}
		System.out.println(sentanceWithoutEmptyStrings.size());

		
		try {
			new FileManager().givenWritingStringToFile_whenUsingPrintWriter_thenCorrect(sentanceWithoutEmptyStrings);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
