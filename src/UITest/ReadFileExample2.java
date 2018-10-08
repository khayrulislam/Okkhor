package UITest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileExample2 {

	private static final String FILENAME = "test.txt";

	public static void main(String[] args) {
		
		ArrayList<String> allSantence = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				//String temp[] = sCurrentLine.split('।');
				//System.out.println(sCurrentLine);
				allSantence.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(allSantence.size());
		ArrayList<String> allSantence2 = new ArrayList<>();
		
		for(int i = 0; i < allSantence.size(); i++) {
			String arr[] = allSantence.get(i).split(",");
			//System.out.println(arr.length);
			for(int j = 0; j < arr.length; j++) {
				allSantence2.add(arr[j]);
			}
		}
		
ArrayList<String> allSantence3 = new ArrayList<>();
		
		for(int i = 0; i < allSantence2.size(); i++) {
			String arr[] = allSantence2.get(i).split("।");
			//System.out.println(arr.length);
			for(int j = 0; j < arr.length; j++) {
				allSantence3.add(arr[j]);
			}
		}
		
		System.out.println(allSantence2.size());
		System.out.println(allSantence3.size());
		
		//for(int i = 0; i < allSantence3.size(); i++) 
			//System.out.println(allSantence3.get(i));
		
ArrayList<String> allSantence4 = new ArrayList<>();
		
		for(int i = 0; i < allSantence3.size(); i++) {
			String arr[] = allSantence3.get(i).split(" ");
			//System.out.println(arr.length);
			for(int j = 0; j < arr.length; j++) {
				allSantence4.add(arr[j]);
			}
		}
		
		System.out.println(allSantence4.size());
		for(int i = 0; i < allSantence4.size(); i++) 
		System.out.println(allSantence4.get(i));
	}

}
