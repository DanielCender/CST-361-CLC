package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;
import business.RegistrationFactory;
import database.ConnectToUserDB;

/**
* Controller managing Register Page.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
@ManagedBean
@ViewScoped
public class RegisterPageController {
	
	
	
	public String createAccount() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		RegistrationFactory rf = new RegistrationFactory();
		
		
		return rf.createAccount(user);
	}
	
	
	public String back() {
		return "Login.xhtml?faces-redirect=true";
	}

}
