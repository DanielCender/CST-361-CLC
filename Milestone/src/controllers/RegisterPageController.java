package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;
import business.ConnectToUserDB;

@ManagedBean
@ViewScoped
public class RegisterPageController {
	
	ConnectToUserDB udb = new ConnectToUserDB();
	
	public String createAccount() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
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
	
	
	public String back() {
		return "Login.xhtml?faces-redirect=true";
	}

}
