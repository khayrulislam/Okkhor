package user;

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

	public String getPassword() {
		return password;
	}
	
	public boolean isUser(String email, String password) {
		if(email.equals(this.email) && password.equals(this.password))
			return true;
		return false;
	}
}
