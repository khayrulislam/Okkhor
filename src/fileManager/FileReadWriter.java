package fileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import dataPackage.Sentence;
import utilities.Utilities;

public class FileReadWriter {

	private ArrayList<String> allStrings;
	
	
	public ArrayList<ArrayList<Sentence>> getN_Gram(String fileName) {
		
		ArrayList<String> allString = readStringsFromFile(fileName);
		//ArrayList<ArrayList<String>> StrGram = new ArrayList<>();
		ArrayList<ArrayList<Sentence>> Gram = new ArrayList<>();
		
		for(int i = 0; i < 7; i++) {
			ArrayList<Sentence> t1 = new ArrayList<>();
			ArrayList<String> t2 = new ArrayList<>();
			Gram.add(t1);
			//StrGram.add(t2);
		}
		
		int maxGram = Utilities.MAX_GRAM;
		
		for(int n = 2; n <= maxGram; n++) {
			for(String str: allString) {
				String [] splited = str.split(" ");
				for(int i = 0; i < splited.length - n +1; i++) {
					ArrayList<String> words = new ArrayList<>();
					Sentence sentence = new Sentence(words);
					
					String temp = splited[0];
					
					int maxi = Math.min(splited.length, i+n);
					
					
					for(int j = i; j < maxi; j++) {
						sentence.words.add(splited[j]);
					}
					Gram.get(n).add(sentence);
				}
			}
			
			System.out.println("Processing");
			
		}
		return Gram;
	}

	public ArrayList<String> readStringsFromFile(String fileName) {

		allStrings = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				allStrings.add(sCurrentLine);
			}
		} catch (IOException e) {
			System.out.println("file reading problm in FileReadWriter class");
		}

		System.out.println("File reading completed");
		return allStrings;
	}

	public void writeOutput(ArrayList<String> allOutput, String fileName) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
		} catch (IOException e) {
			System.out.println("problem in file writing");
		}
		PrintWriter printWriter = new PrintWriter(fileWriter);

		for (String data : allOutput) {
			printWriter.println(data);
		}

		printWriter.close();
		System.out.println("file wriing completed");
		
	}
	
	public HashMap<String, Integer> getWordMap() {
		ArrayList<String> stringsInWordMapFile = readStringsFromFile(Utilities.WORD_MAP_FILE_NAME);
		HashMap<String, Integer> wordMapCount = new HashMap<>();
		for(String str: stringsInWordMapFile) {
			String [] splited = str.split(" ");
			wordMapCount.put(splited[0], Integer.valueOf(splited[1]));
		}
		
		return wordMapCount;
	}
	
	public void appendInFile(String fileName, String textToAppend) {
		File file = new File(fileName);
		FileWriter fr = null;
		try {
			fr = new FileWriter(file, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found to append");
		}
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);
		pr.println(textToAppend);
		pr.close();
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("Could not close buffer writer");
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			System.out.println("Could not close");
			e.printStackTrace();
		}
	}
	
	public void appendInFile(String fileName, ArrayList<String> textListToAppend) {
		File file = new File(fileName);
		FileWriter fr = null;
		try {
			fr = new FileWriter(file, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found to append");
		}
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);
		
		for(String str: textListToAppend) 
			pr.println(textListToAppend);
		
		pr.close();
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("Could not close buffer writer");
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			System.out.println("Could not close");
			e.printStackTrace();
		}
	}

}
