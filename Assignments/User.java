package Assignments;

public class User {
	String userName;
	String password;
	
	//parameterized constructor
	public User(String userName, String password) {
		this.userName=userName;
		this.password=password;
	}
	
	public String authenticate(String userName, String password) {
		if(this.userName.equals(userName) && this.password.equals(password)) {
			return "Both username and password exits.";
		}
			return "Invalid username and password.";
	}

}
