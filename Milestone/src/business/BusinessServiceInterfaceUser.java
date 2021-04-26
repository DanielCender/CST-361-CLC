package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.User;


/**
* This interface defines the constraints of the Authentication service methods.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
@Local
public interface BusinessServiceInterfaceUser {
	
	public void insertOne(User user);
	
	public boolean login(String u, String p);

}
