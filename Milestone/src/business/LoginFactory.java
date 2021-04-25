package business;

import javax.faces.bean.ManagedBean;

import controllers.LoginPageController;

@ManagedBean
public class LoginFactory {
	
	
	
	public String getLogin() {
		return LoginPageController.loggedUser;
	}
	
	

}
