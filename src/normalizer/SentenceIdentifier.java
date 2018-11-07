package normalizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SentenceIdentifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> allSantence = new ArrayList<>();
		ArrayList<String> dariSeperated = new ArrayList<>();
		ArrayList<String> comaSeperated = new ArrayList<>();
		ArrayList<String> semiColonSeperated = new ArrayList<>();
		ArrayList<String> finalSentance = new ArrayList<>();
		ArrayList<String> exclaimSeperated = new ArrayList<>();
		Normalizer normalizer = new Normalizer();

		try (BufferedReader br = new BufferedReader(new FileReader("output_version_001.txt"))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				allSantence.add(sCurrentLine);
			}

		} catch (IOException e) {
			System.out.println("file reading problm");
			e.printStackTrace();
		}

		System.out.println("file reading completed");

		
		dariSeperated = spliter(allSantence, "।");
		comaSeperated = spliter(dariSeperated, ",");
		semiColonSeperated = spliter(comaSeperated, ";");
		exclaimSeperated = spliter(comaSeperated, "!");
		
		
		for(String str: exclaimSeperated)
			if(normalizer.notBlankLine(str))
				finalSentance.add(str);
		
		
		try {
			new MyFileWriter().writeInFile(finalSentance, "myOutput.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not write in file");
		}
		
		System.out.println("completed");
		System.out.println("santence found = " + finalSentance.size());
		
		
		
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
	

}
