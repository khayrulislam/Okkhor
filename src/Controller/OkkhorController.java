package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import Ai.WordTrie;
import CurrentStatus.UserStatus;
import Utils.Util;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class OkkhorController extends WindowTransition implements Initializable {
	
	@FXML
	AnchorPane okkhorAnchorPane,oo;
	
	@FXML
	TextField okkhorTf;
	
	@FXML
	VBox okkhorSuggestionVb;
	
	@FXML
	Button logOutBt;
	
	private UserStatus userStatus;
	
	private int currentItemNumber=-1,previousItemNumber;
	
	private WordTrie dt;
	
	public void logOut() {
		userStatus.setDefaultUserStatus();
		loadWindow(Util.SIGN_IN_FXML);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		userStatus = UserStatus.getUserStausInstance();
		dt = WordTrie.getDateBaseInstance();
		
		if(userStatus.getStatus().equals(Util.DEFAULT)) logOutBt.setText("পিছনে যান");
		
		
		
	}
	
	public void changeSuggestionItemOnKey(KeyEvent keyEvent) {
		
		if(okkhorSuggestionVb.getChildren().size()>0) {

			if(keyEvent.getCode() == KeyCode.DOWN) {
				
				previousItemNumber = currentItemNumber;
				currentItemNumber+=okkhorSuggestionVb.getChildren().size()+1;
				currentItemNumber %= okkhorSuggestionVb.getChildren().size();
				updateFocusing(currentItemNumber,previousItemNumber);	
			}
			
			else if (keyEvent.getCode() == KeyCode.UP) {
				
				previousItemNumber = currentItemNumber;
				currentItemNumber+=okkhorSuggestionVb.getChildren().size()-1;
				currentItemNumber %= okkhorSuggestionVb.getChildren().size();
				updateFocusing(currentItemNumber,previousItemNumber);
			}
			
			/*else if (keyEvent.getCode() == KeyCode.ENTER) {
				System.out.println("in");
				Label label = (Label) okkhorSuggestionVb.getChildren().get(currentItemNumber);
				okkhorTf.setText(label.getText());
				//okkhorTf.requestFocus();
				//okkhorTf.end();
				okkhorSuggestionVb.getChildren().clear();
				currentItemNumber = -1;
			}*/
		}	
	}
	
	
	private void updateFocusing(int currentItemNumber2, int previousItemNumber2) {

		Label label = (Label) okkhorSuggestionVb.getChildren().get(currentItemNumber);
		label.setId("okkhorSuggestionLabelFocused");
		okkhorTf.setText(label.getText());
		
		if(previousItemNumber>-1) {
			Label label2 = (Label) okkhorSuggestionVb.getChildren().get(previousItemNumber);
			label2.setId("okkhorSuggestionLabel");	
		}
	}

	private void createSuggestionList(ArrayList<String> list) {
		
		//ArrayList<String> list = new ArrayList<>(Arrays.asList("olife ddddddddddddddddddddddddd","atiq","jamil","thamid","jubair"));
		
		okkhorSuggestionVb.getChildren().clear();
		for(int i=0;i<list.size();i++) okkhorSuggestionVb.getChildren().add(getASuggestionItem(list.get(i)));
			
	}
	
	private Label getASuggestionItem(String text) {
		
		Label label = new Label(text);
		label.setId("okkhorSuggestionLabel");
		
		label.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				label.setId("okkhorSuggestionLabelFocused");
			}
		});
		
		label.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				label.setId("okkhorSuggestionLabel");
			}
		});
		
		label.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				currentItemNumber = -1;
				okkhorTf.setText(label.getText());
				okkhorTf.requestFocus();
				okkhorTf.end();
				okkhorSuggestionVb.getChildren().clear();
			}
		});
		
		return label;
	}
	
	public void startSuggestion(KeyEvent keyEvent) {
		//okkhorSuggestionVb.getChildren().clear();
		if(!okkhorTf.getText().equals("")  && keyEvent.getCode()!=KeyCode.UP && keyEvent.getCode()!= KeyCode.DOWN) {

			System.out.println(okkhorTf.getText());
			ArrayList< String > arrayList = dt.getSuggestionList(okkhorTf.getText());
			
			if(arrayList!=null) {

				//for(int i=0;i<arrayList.size();i++) System.out.println(arrayList.get(i));
				
				createSuggestionList(arrayList);
			}
			else okkhorSuggestionVb.getChildren().clear();
		}

		
		
		
	}
	
	
	public void ff(ActionEvent event) {
		//createSuggestionList();
	}
	
	
	public void enterKeyAction(ActionEvent event) {
		
		if(okkhorSuggestionVb.getChildren().size()>0) {
			System.out.println("in");
			Label label = (Label) okkhorSuggestionVb.getChildren().get(currentItemNumber);
			okkhorTf.setText(label.getText());
			okkhorTf.requestFocus();
			okkhorTf.end();
			okkhorSuggestionVb.getChildren().clear();
			currentItemNumber = -1;
		}
		
		else {
			okkhorAnchorPane.requestFocus();
			// TODO store
			System.out.println("out");
			okkhorTf.clear();
		}
		
		
	}
	
	public void removeFocus(MouseEvent event) {
		//oo.requestFocus();
	}

}
