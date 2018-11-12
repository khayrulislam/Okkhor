package user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import utilities.Utilities;

public class User {

	private String email;
	private String password;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
	public String getEmail() {
		return email;
	}

	/*
	public String getPassword() {
		return password;
	}*/
	
	public String getUserTypedWordFileName() {
		String hash = "35454B055";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    md.update(email.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter
	      .printHexBinary(digest).toUpperCase();
			    return myHash+".txt";
	}
	
	public boolean isUser(String email, String password) {
		if(email.equals(this.email) && password.equals(this.password))
			return true;
		return false;
	}
	
	public void addUserInformation() {
		String information = email+" "+password;
		Utilities.READ_WRITE.appendInFile(Utilities.USER_INFO_FILE, information);
	}
}
