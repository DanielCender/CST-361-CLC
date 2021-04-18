package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;
import business.RegistrationFactory;
import database.ConnectToUserDB;

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
