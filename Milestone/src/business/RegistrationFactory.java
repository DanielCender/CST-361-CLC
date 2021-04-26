package business;

import beans.User;
import database.ConnectToUserDB;

/**
* This factory Bean returns an encapsulation of the logic related to user creation.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
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
