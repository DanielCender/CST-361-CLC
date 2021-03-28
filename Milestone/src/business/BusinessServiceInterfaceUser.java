package business;

import javax.ejb.Local;
import javax.enterprise.inject.Alternative;

import beans.User;


@Local
@Alternative
public interface BusinessServiceInterfaceUser {
	
	public void insertOne(User user);
	
	public boolean login(String u, String p);

}
