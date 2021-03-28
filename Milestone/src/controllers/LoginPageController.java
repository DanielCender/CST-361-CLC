package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.BusinessServiceInterfaceUser;
import database.ConnectToUserDB;


@ManagedBean
@ViewScoped
public class LoginPageController {

	
	//ConnectToUserDB udb = new ConnectToUserDB();
	@Inject
	BusinessServiceInterfaceUser udb;
	
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
