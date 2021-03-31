package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.faces.bean.RequestScoped;

import beans.User;
import database.ConnectToUserDB;

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
