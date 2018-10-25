package DataObject;

public class User {
	
	private String username,email,password,accountCreationDate,accountCreationTime;

	public User(String username, String email, String password, String accountCreationDate,String accountCreationTime) {
		
		this.username = username;
		this.email = email;
		this.password = password;
		this.accountCreationDate = accountCreationDate;
		this.accountCreationTime = accountCreationTime;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getAccountCreationDate() {
		return accountCreationDate;
	}

	public String getAccountCreationTime() {
		return accountCreationTime;
	}
	
	public void printUser() {
		
		System.out.println("username = "+this.username+" email = "+this.email+" password = "+this.password+" date = "+this.accountCreationDate+" time = "+this.accountCreationTime);
	}
}
