package CurrentStatus;

import DataObject.User;
import Utils.Util;

public class UserStatus {

	private User user;
	private String status;
	private static UserStatus us = null;
	
	private UserStatus() {
		this.user = null;
		this.status = Util.DEFAULT;
	}
	
	public static UserStatus getUserStausInstance() {
		
		if(us==null) {
			synchronized (UserStatus.class) {
				if(us==null) us = new UserStatus();	
			}
		}
		return us;
	}
	
	public void changeUserStatus(User user, String status) {
		this.user = user;
		this.status = status;
	}
	
	public void setDefaultUserStatus() {
		us = new UserStatus();
	}

	public User getUser() {
		return user;
	}

	public String getStatus() {
		return status;
	}

}
