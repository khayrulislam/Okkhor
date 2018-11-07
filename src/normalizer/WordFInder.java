package normalizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordFInder {

	public static void main(String[] args) {
		
		ArrayList<String> allSantence = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		ArrayList<String> finalWords = new ArrayList<>();
		Normalizer normalizer = new Normalizer();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader("sntns.txt"))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				allSantence.add(sCurrentLine);
			}

		} catch (IOException e) {
			System.out.println("file reading problm");
			e.printStackTrace();
		}

		System.out.println("file reading completed");
		words = spliter(allSantence, " ");
		
		for(String str: words)
			if(normalizer.notBlankLine(str))
				finalWords.add(str);
		
		
		
		
		
		
		
		
		
		try {
			new MyFileWriter().writeInFile(finalWords, "myOutput.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not write in file");
		}
		
		System.out.println("completed");
		System.out.println("santence found = " + finalWords.size());
		
		
		
		System.out.println(words.get(0));
		
		
		
		
		
		

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
