package business;

import javax.faces.bean.ManagedBean;

import controllers.LoginPageController;

/**
* This factory Bean returns an encapsulation of the logic required to retrieve the currently
* authenticated user state.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
@ManagedBean
public class LoginFactory {
	
	
	
	public String getLogin() {
		return LoginPageController.loggedUser;
	}
	
	

}
