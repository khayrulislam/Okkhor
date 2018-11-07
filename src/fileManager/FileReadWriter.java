package fileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileReadWriter {

	private ArrayList<String> allStrings;

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

}
