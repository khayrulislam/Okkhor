package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DataBase.DataBaseConnection;
import Utils.Util;
import Validation.RegularExpressionCheck;
import application.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController extends WindowTransition implements Initializable {
	
	@FXML
	TextField signInEmailTf;
	
	@FXML
	PasswordField signInPasswordTf;
	
	@FXML
	Label signInWrongMessageLb;
	
	private DataBaseConnection dbc = null;
	
	public void signInButtonClick() {
		
		signInWrongMessageLb.setVisible(false);
		if( dbc.isUserExist(signInEmailTf.getText(), signInPasswordTf.getText()) ) loadWindow(Util.OKKHOR_FXML);
		else signInWrongMessageLb.setVisible(true);
	}
	
	public void signUpLableClick() {
		loadWindow(Util.SIGN_UP_FXML);
	}
	
	public void skipButtonClick() {
		loadWindow(Util.OKKHOR_FXML);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		RegularExpressionCheck rec = new RegularExpressionCheck();
		dbc = DataBaseConnection.getDateBaseInstance();
		
		signInEmailTf.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				
				if(newValue) signInEmailTf.getStyleClass().remove("error");
				else
					if( rec.isValidEmail( signInEmailTf.getText() ) ) signInEmailTf.getStyleClass().remove("error");
					else signInEmailTf.getStyleClass().add("error");
				
			}
		});
		
	}

}
