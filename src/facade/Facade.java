package facade;

import java.util.ArrayList;

import user.User;
import utilities.Utilities;

public class Facade {
	
	//private
	public boolean userSet = false;
	
	public void process() {
		
		initializeUserInformation();
		initializeDecorator();
		
		new OkkhorPredectorSuper().carryPrediction();
		
		
		
		//// must done these
		
		
		
		
		
		/*
		
		System.out.println("working");
		System.out.println(Utilities.ALL_USER.size());
		
		for(User user: Utilities.ALL_USER)
			System.out.println(user.getEmail() + " " + user.getUserTypedWordFileName());
		*/
		
	}

	private void initializeDecorator() {
		// TODO Auto-generated method stub
		
	}

	private void initializeUserInformation() {
		ArrayList<String> info = Utilities.READ_WRITE.readStringsFromFile(Utilities.USER_INFO_FILE);
		for(String str: info) {
			String [] splited = str.split(" ");
			Utilities.ALL_USER.add(new User(splited[0], splited[1]));
		}
		System.out.println("User information initialization completed. Total user size = " + Utilities.ALL_USER.size());
	}
	
	

}
