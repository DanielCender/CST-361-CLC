package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.faces.bean.RequestScoped;

import beans.User;
import database.ConnectToUserDB;

/**
* This service Bean uses data services to implement the methods in the User db interface.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
@Local
public class BusinessServiceUser implements BusinessServiceInterfaceUser {

	
	@Inject
	ConnectToUserDB db = new ConnectToUserDB();
	
	@Override
	public void insertOne(User user) {
		db.insertOne(user);
		
	}

	@Override
	public boolean login(String u, String p) {
		return db.login(u, p);
	}

}
