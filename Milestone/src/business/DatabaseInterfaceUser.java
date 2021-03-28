package business;

import javax.ejb.Local;

import beans.User;

@Local
public interface DatabaseInterfaceUser {
	
public void insertOne(User user);
	
	public boolean login(String u, String p);

}
