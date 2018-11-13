package utilities;

import java.util.ArrayList;
import java.util.Arrays;

import dataAnalyzer.Gram_Converter;
import dataAnalyzer.Predector;
import dataPackage.Sentence;
import fileManager.FileReadWriter;


public class Utilities {

	public static String WORD_FILE_NAME = "words.txt";
	public static String SENTENCE_FILE_NAME = "sentence4.txt";
	public static String OUTPUT_FILE_NAME = "output.txt";
	public static String INPUT_FILE_NAME = "input.txt";
	public static String USER_INFO_FILE = "user.txt";
	public static String WORD_MAP_FILE_NAME = "wordMap.txt";

	//public static ArrayList<User> ALL_USER = new ArrayList<>();
	public static ArrayList<String> GRAM_FILENAME = new ArrayList<>(
			Arrays.asList("g0.txt", "g1.txt", "g2.txt", "g3.txt", "g4.txt", "g5.txt", "g6.txt"));

	public static int MAX_GRAM = 5;

	//public static User CURRENT_USER;
	public static String USER_TYPED_FILE_NAME;
	
	
	public static ArrayList<ArrayList<Sentence>> ALL_GRAM = new ArrayList<>();
	public static ArrayList<ArrayList<Sentence>> USER_GRAM = new ArrayList<>();
	
	public static java.util.Scanner SCANNER = new java.util.Scanner(System.in);
	public static FileReadWriter READ_WRITE = new FileReadWriter();
	public static Predector PREDICTOR = new Predector();
	public static Gram_Converter GRAM_CONVERTER = new Gram_Converter();
	//public static Facade FACADE = new Facade();

}
