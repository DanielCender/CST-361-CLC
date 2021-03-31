package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.User;



@Local
public interface BusinessServiceInterfaceUser {
	
	public void insertOne(User user);
	
	public boolean login(String u, String p);

}
