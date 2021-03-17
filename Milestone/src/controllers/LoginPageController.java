package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;
import business.ConnectToUserDB;


@ManagedBean
@ViewScoped
public class LoginPageController {

	
	ConnectToUserDB udb = new ConnectToUserDB();
	
	public String onSubmit() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		String nav = "Login.xhtml";
		if(udb.login(user.getUsername(), user.getPassword())) {
			System.out.println("Login successfull!! " + user.getUsername());
			nav = "WeatherPage.xhtml?faces-redirect=true";
			
		} else {
			System.out.println("Login fail.");
		}
		return nav;
	}
	
	
	
}
