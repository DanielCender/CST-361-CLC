package business;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import beans.User;


@Local
@Alternative
public class BusinessServiceUser implements BusinessServiceInterfaceUser {

	
	@Inject
	DatabaseInterfaceUser db;
	
	@Override
	public void insertOne(User user) {
		db.insertOne(user);
		
	}

	@Override
	public boolean login(String u, String p) {
		return db.login(u, p);
	}

}
