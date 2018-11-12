package facade;

import user.User;
import utilities.Utilities;

public class Facade {
	
	public void process() {
		System.out.println("working");
		System.out.println(Utilities.ALL_USER.size());
		
		//for(User user: Utilities.ALL_USER)
		//	System.out.println(user.getEmail() + " " + user.getPassword());
		
		
	}
	
	public void addUser(User user) {
		String information = user.getEmail()+" "+user.getPassword();
		Utilities.READ_WRITE.appendInFile(Utilities.USER_INFO_FILE, information);
		Utilities.ALL_USER.add(user);
	}

}
