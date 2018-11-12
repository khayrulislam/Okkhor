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

import Ai.WordTrie;
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
	
		
		String dot1 = "য়";
		
		String dot2 = "ব়";
		
		String dot3 = "ড়";
		
		String dot4 = "ঢ়";
		
		String original1 = "য়";
		
		String original2 = "র";
				
		String original3 = "ড়";
				
		String original4 = "ঢ়";
		
		
		String dot = "য় ব় ড় ঢ় ";
		
		String original = "য়  র ড় ঢ়";
		
		
		String word,word1;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("banglaWord.txt")));
			Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("banglaData.txt"), "utf-8"));
			//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("banglaData2.txt","UTF-8")));
			while ( (word = br.readLine() )!= null) {
				
				word1 = word.replaceAll(dot1, original1);
				word = word1.replaceAll(dot2, original2);
				word1 = word.replaceAll(dot3, original3);
				word = word1.replaceAll(dot4, original4);
				writer.write(word+"\n");
				//System.out.println(word);
			}
			writer.close();	
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		Thread thread = new Thread(){
		    public void run(){
		    	WordTrie dt = WordTrie.getDateBaseInstance();
				dt.builtTrie();
				System.out.println("done");
		    }
		};
	
		thread.start();

		launch(args);*/
		
		
		
		//DataBaseConnection dbc = new DataBaseConnection();
		//dbc.createNewDatabase();
		//dbc.createNewTable();
		
	}
}
