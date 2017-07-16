package org.myprj.beans;

public class User {

	private String mail;
	private String userfName;
	private String userLName;
	private String password;

	public User() {

	}
	

	public User(String mail, String userfName, String userLName, String password) {
		super();
		this.mail = mail;
		this.userfName = userfName;
		this.userLName = userLName;
		this.password = password;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUserfName() {
		return userfName;
	}

	public void setUserfName(String userfName) {
		this.userfName = userfName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
