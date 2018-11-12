package dataAnalyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dataPackage.Sentence;
import utilities.Utilities;

public class N_Gram {

	
	
	
	public void test(){
		
		ArrayList<String> all = Utilities.READ_WRITE.readStringsFromFile(Utilities.SENTENCE_FILE_NAME);
		ArrayList<Sentence> next = new ArrayList<>();
		
		System.out.println(all.get(0));
		
		for(String str: all) {
			
			int k = 2;
			
			String [] splited = str.split(" ");
			for(int i = 0; i < splited.length - k +1; i++) {
				ArrayList<String> words = new ArrayList<>();
				Sentence sentence = new Sentence(words);
				for(int j = i; j < i + 2; j++) {
					sentence.words.add(splited[j]);
				}
				next.add(sentence);
			}
		}
		
		
		System.out.println(next.size());
		String line = null;
		
		while(true) {
			System.out.print("এখানে  লিখুন: ");
			line = Utilities.SCANNER.nextLine();
			
			ArrayList<String> nextMayBe = new ArrayList<>();
			
			for(Sentence s: next) {
				if(s.words.get(0).equals(line)) {
					nextMayBe.add(s.words.get(1));
				}
			}
			
			
			
			nextMayBe = Utilities.PREDICTOR.highestOccurence(nextMayBe);
			int k = Math.min(10, nextMayBe.size());
			
			for(int i = 0; i < k; i++)
				System.out.println(nextMayBe.get(i));
			
			System.out.println("***********************");
			
			 
		}
		
		
	}
	
	
	
	public void test3() {
		ArrayList<String> all = Utilities.READ_WRITE.readStringsFromFile(Utilities.SENTENCE_FILE_NAME);
		for(String string: all)
			Utilities.GRAM_CONVERTER.convertAndWrite(string);
		System.out.println("Done");
	}
	
	
	
	public void test2() {
		ArrayList<String> all = Utilities.READ_WRITE.readStringsFromFile(Utilities.SENTENCE_FILE_NAME);
		//ArrayList<Sentence> next = new ArrayList<>();
		
		ArrayList<ArrayList<Sentence>> Gram = new ArrayList<>();
		ArrayList<ArrayList<String>> StrGram = new ArrayList<>();
		for(int i = 0; i < 7; i++) {
			ArrayList<Sentence> t1 = new ArrayList<>();
			ArrayList<String> t2 = new ArrayList<>();
			Gram.add(t1);
			StrGram.add(t2);
		}
		
		
		
		
		int maxGram = 5;
		
		System.out.println(Gram.size());
		
		
		for(int n = 2; n <= maxGram; n++) {
			
			
			
			for(String str: all) {
				//System.out.println(n+"----");
				String [] splited = str.split(" ");
				for(int i = 0; i < splited.length - n +1; i++) {
					ArrayList<String> words = new ArrayList<>();
					Sentence sentence = new Sentence(words);
					
					String temp = splited[0];
					
					int maxi = Math.min(splited.length, i+n);
					
					
					for(int j = i; j < maxi; j++) {
						sentence.words.add(splited[j]);
					}
					
					//for(int j = 1; j < maxi; j++)
					//	temp = temp + " "+ splited[j];
					
					Gram.get(n).add(sentence);
					//StrGram.get(n).add(temp);
					//next.add(sentence);
				}
				
				//System.out.println("s " + Gram.get(n).size());
			}
			
			System.out.println("Processing");
			
		}
		
		
		for(int i = 2; i <= Utilities.MAX_GRAM; i++) {
			Utilities.READ_WRITE.writeOutput(StrGram.get(i), Utilities.GRAM_FILENAME.get(i));
			System.out.println("completed");
		}
		
		String line = null;
		
		while(true) {
			int count = 1;
			ArrayList<String> typed = new ArrayList<>();
			
			while (true) {
				System.out.print("এখানে  লিখুন: ");
				line = Utilities.SCANNER.nextLine();
				if(line.contains("।")) {
					break;
				}
				
				typed.add(line);
				ArrayList<String> nextMayBe = new ArrayList<>();
				
				for(Sentence sentence: Gram.get(count+1)) {
					
					boolean taken = true;
					
					for(int i = 0; i < count; i++) {
						if(!sentence.words.get(i).equals(typed.get(i))) {
							taken  = false;
						}
					}
					
					if(taken) {
						nextMayBe.add(sentence.words.get(count));
					}
				}
				
				nextMayBe = Utilities.PREDICTOR.highestOccurence(nextMayBe);
				
				int k = Math.min(10, nextMayBe.size());
				if(k <= 0) break;
				
				for(int i = 0; i < k; i++)
					System.out.println(nextMayBe.get(i));
				
				
				count++;
			}
		}
			
	}
}
