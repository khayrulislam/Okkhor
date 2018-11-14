package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
	ListView<String> previousLi,text;
	
	private UserStatus userStatus;
	
	private int currentItemNumber=-1,previousItemNumber;
	
	private WordTrie dt;
	
	
	public void logOut() {
		userStatus.setDefaultUserStatus();
		Utilities.USER_GRAM = null;
		loadWindow(Util.SIGN_IN_FXML);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		userStatus = UserStatus.getUserStausInstance();
		dt = WordTrie.getWordTrieInstance();
		
		
		if(userStatus.getStatus().equals(Util.DEFAULT)) logOutBt.setText("পিছনে যান");
		
		else if(userStatus.getStatus().equals(Util.LOGGED_IN)) {
			Utilities.USER_GRAM = Utilities.READ_WRITE.getN_Gram(userStatus.getUser().getEmail()+".txt");
			HashMap<String, Integer> mp = Utilities.READ_WRITE.getUserWordCount(userStatus.getUser().getEmail()+".txt");
			
			
			
			for(String key: mp.keySet()) {
				
				dt.insertFromOutSide(new Word(key, mp.get(key)));
				
			}
			
		}
		
		
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
		okkhorTf.positionCaret(label.getText().length());
		
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
		
		//text.getItems().add(0,okkhorTf.getText());

		if(!okkhorTf.getText().equals("")  && keyEvent.getCode()!=KeyCode.UP && keyEvent.getCode()!= KeyCode.DOWN) {
			
			ArrayList< Word > arrayList = new ArrayList<>();
			String previous;
			
			InputTextNormalize itn = new InputTextNormalize();
			itn.normalizeText(okkhorTf.getText());
			
			if(itn.isValidText()) {
				
				previous = itn.getPreviousText();	
				
				if(keyEvent.getCode() == KeyCode.SPACE) {
					
					ArrayList<String> list2 = new ArrayList<>();
					ArrayList<String> list3 = Utilities.PREDICTOR.getNextWord(itn.getWordList());
					
					if(userStatus.getStatus().equals(Util.LOGGED_IN)) {
						list2 = Utilities.PREDICTOR.getNextWordFromUserType(itn.getWordList());
					}
					
					ArrayList<String> list = new ArrayList<>();
					
					int n = Math.min(list2.size(), 4);
					for(int i = 0; i < n; i++) {
						list.add(list2.get(i));
					}
					
					for(String string: list3) 
						if(!list.contains(string))
							list.add(string);
					
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
					for(int i=0;i<Math.min(10, arrayList.size());i++) {
						
						text.getItems().add(0,arrayList.get(i).getBengaliWord()+"    "+arrayList.get(i).getCount());
						
					}
				}
				else okkhorSuggestionVb.getChildren().clear();
				
				
				
				
				currentItemNumber = -1;
			}
			
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
		InputTextNormalize itn = new InputTextNormalize();
		itn.normalizeText(okkhorTf.getText());
		if(userStatus.getStatus().equals(Util.LOGGED_IN)   && itn.isValidText() ) {
			Utilities.READ_WRITE.appendInFile(userStatus.getUser().getEmail()+".txt", okkhorTf.getText());
			Utilities.READ_WRITE.addSentanceInuserGram(okkhorTf.getText());
			
			ArrayList<String> arr = itn.getWordList();
			
			for(int i=0;i<arr.size();i++) {
				dt.insertFromOutSide(new Word(arr.get(i), 500));
			}
		}
		okkhorTf.clear();
		
		okkhorSuggestionVb.getChildren().clear();
	}
	
	
	public void removeFocus(MouseEvent event) {
		//oo.requestFocus();
	}

}
