package database;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.User;

/**
* Database service interface, specifically for defining the methods for the user table interactions.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
@Local
public interface DatabaseInterfaceUser {
	
public void insertOne(User user);
	
	public boolean login(String u, String p);

}
