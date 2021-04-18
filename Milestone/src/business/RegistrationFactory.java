package business;

import beans.User;
import database.ConnectToUserDB;

public class RegistrationFactory {
	
	ConnectToUserDB udb = new ConnectToUserDB();
	
	public String createAccount(User user) {
		String nav = "Login.xhtml?faces-redirect=true";
		
		
		if (user != null && user.getEmail() != null) {
			if (!user.getEmail().contains("@") || !user.getEmail().contains(".")) {
				nav = "Register.xhtml?faces-redirect=true";
				System.out.println("Login Fail");
			} else {
				udb.insertOne(user);
			}
		} else {
			System.out.println("Login Fail");
			nav = "Register.xhtml?faces-redirect=true";
		}
		
		
		return nav;
	}
	
	

}
