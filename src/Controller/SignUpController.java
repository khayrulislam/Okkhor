package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import CurrentStatus.UserStatus;
import DataBase.DataBaseConnection;
import DataObject.User;
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

public class SignUpController extends WindowTransition implements Initializable {

	@FXML
	TextField signUpUsernameTf,signUpEmailTf;
	
	@FXML
	PasswordField signUpPasswordTf,signUpConfirmPasswordTf;
	
	@FXML
	Label signUpErrorMessageLb;
	
	private Boolean textFieldComplete = false;
	
	private DataBaseConnection dbc = null;
	
	public void signUpButtonClick() {
		
		signUpErrorMessageLb.setVisible(false);
		
		if(textFieldComplete) {
			
			User user = new User(signUpUsernameTf.getText(), signUpEmailTf.getText(), signUpPasswordTf.getText(), Util.getDateTime(Util.DATE_FORMAT), Util.getDateTime(Util.TIME_FORMAT));
			if( dbc.insert(user) ) {
				System.out.println("successfully insert");
				loadWindow(Util.OKKHOR_FXML);
			}
			else {
				System.out.println(" DataBase insert problem ");
			}
			
		}
		else signUpErrorMessageLb.setVisible(true);	
	}
	
	public void skipButtonClick() {
		UserStatus us = UserStatus.getUserStausInstance();
		us.setDefaultUserStatus();
		loadWindow(Util.OKKHOR_FXML);
	}
	
	public void backButtonClick() {
		loadWindow(Util.SIGN_IN_FXML);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		dbc = DataBaseConnection.getDateBaseInstance();
		RegularExpressionCheck rec = new RegularExpressionCheck();
		
		signUpUsernameTf.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				
				if(newValue) signUpUsernameTf.getStyleClass().remove("error");
				else
					if( !signUpUsernameTf.getText().equals("") ) {
						signUpUsernameTf.getStyleClass().remove("error");
						textFieldComplete = true;
					}
					else {
						signUpUsernameTf.getStyleClass().add("error");
						textFieldComplete = false;
					}
				
			}
		});		
		
		
		signUpEmailTf.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				
				if(newValue) signUpEmailTf.getStyleClass().remove("error");
				else
					if( rec.isValidEmail( signUpEmailTf.getText() )  && !dbc.isEmailExist(signUpEmailTf.getText())) {
						signUpEmailTf.getStyleClass().remove("error");
						textFieldComplete = true;
					}
					else {
						signUpEmailTf.getStyleClass().add("error");
						textFieldComplete = false;
					}
				
			}
		});
		
		signUpPasswordTf.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				
				if(newValue) signUpPasswordTf.getStyleClass().remove("error");
				else
					if( !signUpPasswordTf.getText().equals("") && signUpPasswordTf.getText().length()>3 && signUpPasswordTf.getText().length()<8 ) {
						signUpPasswordTf.getStyleClass().remove("error");
						textFieldComplete = true;
					}
					else {
						signUpPasswordTf.getStyleClass().add("error");
						textFieldComplete = false;
					}
				
			}
		});
		
		
		signUpConfirmPasswordTf.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				
				if(newValue) signUpConfirmPasswordTf.getStyleClass().remove("error");
				else
					if( signUpConfirmPasswordTf.getText().equals(signUpPasswordTf.getText()) && !signUpPasswordTf.getText().equals("")) {
						signUpConfirmPasswordTf.getStyleClass().remove("error");
						textFieldComplete = true;
					}
					else {
						signUpConfirmPasswordTf.getStyleClass().add("error");
						textFieldComplete = false;
					}
				
			}
		});
		
		
	}
	
}
