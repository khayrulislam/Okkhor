package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import CurrentStatus.UserStatus;
import Utils.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class OkkhorController extends WindowTransition implements Initializable {
	
	@FXML
	AnchorPane okkhorAnchorPane;
	
	@FXML
	TextField okkhorTf;
	
	
	@FXML
	Button logOutBt;
	
	private UserStatus userStatus;
	
	public void logOut() {
		userStatus.setDefaultUserStatus();
		loadWindow(Util.SIGN_IN_FXML);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		userStatus = UserStatus.getUserStausInstance();
		
		if(userStatus.getStatus().equals(Util.DEFAULT)) logOutBt.setText("পিছনে");
		
	}
	
	
	public void enterKeyAction(ActionEvent event) {
		
		okkhorAnchorPane.requestFocus();
		// TODO store
		okkhorTf.clear();
		
	}
	
	
	public void removeFocus(MouseEvent event) {
		okkhorAnchorPane.requestFocus();
	}
	

}
