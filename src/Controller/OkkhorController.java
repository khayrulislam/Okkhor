package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Utils.Util;
import javafx.fxml.Initializable;

public class OkkhorController extends WindowTransition implements Initializable {
	
	
	public void logOut() {
		loadWindow(Util.SIGN_IN_FXML);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}
