package Controller;

import java.io.IOException;

import Utils.Util;
import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SignUpController {

	
	
	public void signUpButtonClick() {
		
		//TODO signup
		
		loadWindow(Util.OKKHOR_FXML);
	}
	
	
	public void skipButtonClick() {
		loadWindow(Util.OKKHOR_FXML);
	}
	
	public void backButtonClick() {
		loadWindow(Util.SIGN_IN_FXML);
	}
	
	private void loadWindow(String path) {
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(path));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Util.STYLE_CSS).toExternalForm());
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (IOException e) {
			System.out.println("loadWindow method in sign up controller window loading problem");
			e.printStackTrace();
		}
		
	}
	
}
