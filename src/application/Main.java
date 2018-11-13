package application;
	

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

import Ai.WordTrie;
import Factory.FactoryClass;
import Utils.Util;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	
	
	public static Stage primaryStage;
	
	public void start(Stage stage) {
		try {
			primaryStage = stage;
			Parent root = FXMLLoader.load(getClass().getResource(Util.SIGN_IN_FXML));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Util.STYLE_CSS).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		
		
		
		
		
		
	/*	
		
		String word,word1;
		HashMap<String, Integer> wordMap = new HashMap<>();
		int k =0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("banglaData2.txt")));
			Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("banglaData3.txt"), "utf-8"));
			//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("banglaData2.txt","UTF-8")));
			while ( (word = br.readLine() )!= null) {
				
				word1 = word.replaceAll(Util.dot1, Util.original1);
				word = word1.replaceAll(Util.dot2, Util.original2);
				word1 = word.replaceAll(Util.dot3, Util.original3);
				word = word1.replaceAll(Util.dot4, Util.original4);
				
				if(wordMap.containsKey(word)) wordMap.put(word, wordMap.get(word)+1);
				else wordMap.put(word, 1);
				//writer.write(word+"\n");
				//System.out.println(word);
				StringBuilder bulid = new StringBuilder(word);
				
				for(int i=0;i<bulid.length();i++) {
					if(bulid.codePointAt(i)==8205 ||bulid.codePointAt(i)==8204 || bulid.codePointAt(i)==2551) bulid.deleteCharAt(i);
				}
				
				boolean flag = true;
				for(int i=0;i<word.length();i++) {
					if(!Util.BANGLE_LETTER.contains(String.valueOf(word.charAt(i)) )) {flag = false;
					break;} 
				}
				if(flag)writer.write(word+"\n");
				k++;
				//if(k>20000)break;
			}
			
			
			System.out.println("end");
			writer.close();	
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		Thread thread = new Thread(){
		    public void run(){
		    	new FactoryClass();
		    	WordTrie dt = WordTrie.getDateBaseInstance();
				dt.builtTrie();
				System.out.println("done");
		    }
		};
	
		thread.start();
		launch(args);
		
		//DataBaseConnection dbc = new DataBaseConnection();
		//dbc.createNewDatabase();
		//dbc.createNewTable();
		
	}
	
	
	
	/*String word = "সাক্ষাত্‍";
	
	//for(int i=0;i<word.length();i++) System.out.println(word.codePointAt(i));
	char ch = '৷';
	System.out.println((int) ch);
	
	
	String word1;
	HashMap<String, Integer> wordMap = new HashMap<>();
	int k =0;
	try {
		BufferedReader br = new BufferedReader(new FileReader(new File("banglaData.txt")));
		Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("banglaData2.txt"), "utf-8"));
		//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("banglaData2.txt","UTF-8")));
		while ( (word = br.readLine() )!= null) {
			
			word1 = word.replaceAll(Util.dot1, Util.original1);
			word = word1.replaceAll(Util.dot2, Util.original2);
			word1 = word.replaceAll(Util.dot3, Util.original3);
			word = word1.replaceAll(Util.dot4, Util.original4);
			
			if(wordMap.containsKey(word)) wordMap.put(word, wordMap.get(word)+1);
			else wordMap.put(word, 1);
			//writer.write(word+"\n");
			//System.out.println(word);
			StringBuilder bulid = new StringBuilder(word);
			for(int i=0;i<bulid.length();i++) {
				if(bulid.codePointAt(i)==8205 ||bulid.codePointAt(i)==8204 || bulid.codePointAt(i)==2551) bulid.deleteCharAt(i);
			}
			writer.write(bulid+"\n");
			k++;
			if(k>20000)break;
		}
		
		
		System.out.println("end");
		writer.close();	
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	*/
	
	
	
	
	/*
	 * 
	 * 
	 * 
		
		String word,word1;
		
		HashMap<String, Integer> wordMap = new HashMap<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("banglaWords.txt")));
			Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("banglaData.txt"), "utf-8"));
			//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("banglaData2.txt","UTF-8")));
			while ( (word = br.readLine() )!= null) {
				
				word1 = word.replaceAll(Util.dot1, Util.original1);
				word = word1.replaceAll(Util.dot2, Util.original2);
				word1 = word.replaceAll(Util.dot3, Util.original3);
				word = word1.replaceAll(Util.dot4, Util.original4);
				
				if(wordMap.containsKey(word)) wordMap.put(word, wordMap.get(word)+1);
				else wordMap.put(word, 1);
				//writer.write(word+"\n");
				//System.out.println(word);
			}
			
			for(String key:wordMap.keySet()) {
				writer.write(key+" "+wordMap.get(key)+"\n");
			}
			System.out.println("end");
			writer.close();	
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	 * 
	 * 
	 * 
	 * */
}
