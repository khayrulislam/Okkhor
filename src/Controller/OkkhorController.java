package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import CurrentStatus.UserStatus;
import Utils.Util;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class OkkhorController extends WindowTransition implements Initializable {
	
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
	

}
