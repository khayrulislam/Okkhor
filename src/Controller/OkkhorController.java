package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import Ai.WordTrie;
import CurrentStatus.UserStatus;
import DataObject.Word;
import Utils.Util;
import Validation.InputTextNormalize;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import utilities.Utilities;

public class OkkhorController extends WindowTransition implements Initializable {
	
	@FXML
	AnchorPane okkhorAnchorPane,oo;
	
	@FXML
	TextField okkhorTf;
	
	@FXML
	VBox okkhorSuggestionVb;
	
	@FXML
	Button logOutBt;
	
	@FXML
	ListView<String> previousLi;
	
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
	
	public void changeSuggestionItemUsingUpDownKey(KeyEvent keyEvent) {
		
		if(okkhorSuggestionVb.getChildren().size()>0) {

			if(keyEvent.getCode() == KeyCode.DOWN) {
				
				previousItemNumber = currentItemNumber;
				currentItemNumber+=okkhorSuggestionVb.getChildren().size()+1;
				currentItemNumber%= okkhorSuggestionVb.getChildren().size();
				changeFocusedSuggestionItem();	
			}
			else if (keyEvent.getCode() == KeyCode.UP) {
				
				previousItemNumber = currentItemNumber;
				currentItemNumber+=okkhorSuggestionVb.getChildren().size()-1;
				currentItemNumber%= okkhorSuggestionVb.getChildren().size();
				changeFocusedSuggestionItem();
			}
		}	
	}
	
	
	private void changeFocusedSuggestionItem() {

		Label label = (Label) okkhorSuggestionVb.getChildren().get(currentItemNumber);
		label.setId("okkhorSuggestionLabelFocused");
		okkhorTf.setText(label.getText());
		
		if(previousItemNumber>-1 && currentItemNumber!=previousItemNumber) {
			Label label2 = (Label) okkhorSuggestionVb.getChildren().get(previousItemNumber);
			label2.setId("okkhorSuggestionLabel");	
		}
	}

	private void createSuggestionList(String previousText, ArrayList<Word> list) {
				
		okkhorSuggestionVb.getChildren().clear();
		for(int i=0;i<Math.min(10, list.size());i++) okkhorSuggestionVb.getChildren().add(getASuggestionItem(previousText+list.get(i).getBengaliWord()));
			
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

		if(!okkhorTf.getText().equals("")  && keyEvent.getCode()!=KeyCode.UP && keyEvent.getCode()!= KeyCode.DOWN) {
			
			ArrayList< Word > arrayList = new ArrayList<>();
			String previous;
			
			InputTextNormalize itn = new InputTextNormalize();
			itn.normalizeText(okkhorTf.getText());
			
			previous = itn.getPreviousText();	
			
			if(keyEvent.getCode() == KeyCode.SPACE) {
				ArrayList<String> list = Utilities.PREDICTOR.getNextWord(itn.getWordList());
			
				System.err.println("space");
				
				//arrayList.clear();
				
				for(int i=0;i<list.size();i++) {
					arrayList.add(new Word(list.get(i), 0));
				}
				previous = itn.getPreviousText()+itn.getLastWord()+" ";
			}
			
			else {
				arrayList = dt.getSuggestionList(itn.getLastWord());
			}
			
			if(arrayList!=null) {
				createSuggestionList(previous,arrayList);
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
			
			if(currentItemNumber==-1) currentItemNumber=0;
			Label label = (Label) okkhorSuggestionVb.getChildren().get(currentItemNumber);
			okkhorTf.setText(label.getText());
			okkhorTf.requestFocus();
			okkhorTf.end();
			okkhorSuggestionVb.getChildren().clear();
			currentItemNumber = -1;
		}
		
		else {
			previousLi.getItems().add(0, okkhorTf.getText());
			okkhorAnchorPane.requestFocus();
			System.out.println("out");
			okkhorTf.clear();
			okkhorSuggestionVb.getChildren().clear();
		}
		
		
	}
	
	
	public void storeText(ActionEvent event) {
		previousLi.getItems().add(0, okkhorTf.getText());
		okkhorAnchorPane.requestFocus();
		okkhorTf.clear();
		okkhorSuggestionVb.getChildren().clear();
	}
	
	
	public void removeFocus(MouseEvent event) {
		//oo.requestFocus();
	}

}
