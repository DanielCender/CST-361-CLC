package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.BusinessServiceInterfaceUser;
import business.LoginFactory;
import database.ConnectToUserDB;

/**
* Controller managing Login Page.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
@ManagedBean
@ViewScoped
public class LoginPageController {

	public static String loggedUser = "Login";
	//
	ConnectToUserDB udb = new ConnectToUserDB();
	//BusinessServiceInterfaceUser udb;
	public String onSubmit() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		String nav = "Login.xhtml";
		if(udb.login(user.getUsername(), user.getPassword())) {
			System.out.println("Login successfull!! " + loggedUser);
			loggedUser = user.getUsername();
			nav = "WeatherPage.xhtml?faces-redirect=true";
			
		} else {
			System.out.println("Login fail.");
		}
		return nav;
	}
	
	public String logOut() {
		loggedUser = "Login";
		return "Login.xhtml?faces-redirect=true";
	}
	
	
	

	public String getLoggedUser() {
		return loggedUser;
	}

	
	
	
	
}
