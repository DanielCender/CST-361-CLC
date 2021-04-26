package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
* The User Bean holds metadata of the authenticated application user.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
@ManagedBean
@ViewScoped 
public class User {
	
	
	private int Id;
	@NotNull() 
	@Size(min=5, max=10) 
	private String Username;
	@NotNull() 
	@Size(min=5, max=25)
	private String Email;
	@NotNull() 
	@Size(min=5, max=10)
	private String Password;
	
	public User() {}
	
	public User(int id, String username, String email, String password) {
		this.Id = id;
		this.Username = username;
		this.Email = email;
		this.Password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	

}
