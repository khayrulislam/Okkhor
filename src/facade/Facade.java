package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dataPackage.Sentence;
import user.User;
import utilities.Utilities;

public class Facade {
	
	//private
	public boolean userSet = false;
	
	public void process() {
		
		//initializeUserInformation();
		initializeALLGRAM();
		//initializeDecorator();
		
		ArrayList<String> ho = new ArrayList<>();
		ho.add("আমি");
		ho.add("তোমাকে");
		
	ArrayList<String> temp = Utilities.PREDICTOR.getNextWord(ho);
	
	for(String string: temp)
		System.err.println(string);
		
		
		/*
		Set<String> set = new HashSet<>();
		for(Sentence sentence: Utilities.ALL_GRAM.get(2)){
			String s =  sentence.words.get(0);
			for(int i = 1; i < sentence.words.size(); i++) {
				s = " "+sentence.words.get(i);
			}
			
			set.add(s);
		}*/
		
		//gramFileUpdate();
		
		//System.out.println(set.size());
		
		//for(int i = 2; i <= Utilities.MAX_GRAM; i++)
		//System.out.println(Utilities.ALL_GRAM.get(i).size());
		
		
		//new OkkhorPredectorSuper().carryPrediction();
		
		
		
		//// must done these
		
		
		
		
		
		/*
		
		System.out.println("working");
		System.out.println(Utilities.ALL_USER.size());
		
		for(User user: Utilities.ALL_USER)
			System.out.println(user.getEmail() + " " + user.getUserTypedWordFileName());
		*/
		
	}

	private void gramFileUpdate() {
		
		for(int index = 2; index < Utilities.MAX_GRAM+1; index++) {
			
			Map<String, Integer> mp = new HashMap<>();
			System.out.println(Utilities.ALL_GRAM.get(index).get(0).words.size());
			
			for(Sentence sentence: Utilities.ALL_GRAM.get(index)){
				String s =  sentence.words.get(0);
				for(int i = 1; i < sentence.words.size(); i++) {
					s = s+ " "+sentence.words.get(i);
				}
				
				if(mp.containsKey(s)) {
					mp.put(s, mp.get(s)+1);
				} else {
					mp.put(s, 1);
				}
			}
			
			ArrayList<String> output = new ArrayList<>();
			for(String str: mp.keySet()) {
				output.add(str + " "+ mp.get(str));
			}
			
			Utilities.READ_WRITE.writeOutput(output, "g_"+index+".txt");
			
			
		}
		
	}

	private void initializeALLGRAM() {
		Utilities.ALL_GRAM = Utilities.READ_WRITE.getN_Gram(Utilities.SENTENCE_FILE_NAME);
		
	}

	private void initializeDecorator() {
		// TODO Auto-generated method stub
		
	}

	private void initializeUserInformation() {
		ArrayList<String> info = Utilities.READ_WRITE.readStringsFromFile(Utilities.USER_INFO_FILE);
		for(String str: info) {
			String [] splited = str.split(" ");
			Utilities.ALL_USER.add(new User("name",splited[0], splited[1]));
		}
		System.out.println("User information initialization completed. Total user size = " + Utilities.ALL_USER.size());
	}
	
	

}
