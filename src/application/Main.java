package application;
	

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
		
		Thread thread = new Thread(){
		    public void run(){
		    	WordTrie dt = WordTrie.getDateBaseInstance();
				dt.builtTrie();
				System.out.println("done");
		    }
		};
	
		thread.start();
		
		
		launch(args);
		
		
		/*
		
		ArrayList< String > arrayList = dt.getSuggestionList("c");
		
		for(int i=0;i<arrayList.size();i++) System.out.println(arrayList.get(i));
		*/
		
		
		//DataBaseConnection dbc = new DataBaseConnection();
		//dbc.createNewDatabase();
		//dbc.createNewTable();
		
	}
}
