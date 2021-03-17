package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.User;

public class ConnectToUserDB {
	
	
	//Remote DB
	/*
	 * Username: hHOQMOQDTD
	 * Password: f3HJJN4I3c
	 * Database name: hHOQMOQDTD
	 * Server: remotemysql.com
	 * Port: 3306
	 * 
	 */
	
	
	private String dbURL = "jdbc:mysql://remotemysql.com:3306/hHOQMOQDTD?autoReconnect=true&useSSL=false";
	private String username = "hHOQMOQDTD";
	private String password = "f3HJJN4I3c";
	
	private Connection c = null;
	private Statement stmt = null;
	private ResultSet rs;
	
	
	public void insertOne(User user) {
		connect("select * from hHOQMOQDTD.user");
		PreparedStatement pstmt = null;
		try {
			pstmt = c.prepareStatement("insert into hHOQMOQDTD.user (id, username, email, password) values (?, ?, ?, ?)");
			pstmt.setInt(1, 0);
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
			//stmt.executeQuery("insert into hHOQMOQDTD.user values ( 2, '" + user.getUsername() + "', '" + user.getEmail()+"', '" + user.getPassword() + "'");
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
		
		
	}
	
	public boolean login(String u, String p) {
		connect("select * from hHOQMOQDTD.user");
		boolean found = false;
		try {
			while(rs.next()) {
				if (rs.getString("Username").equals(u) && rs.getString("Password").equals(p)) {
					found = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 disconnect();
		}
		
		return found;
	}
	
	
	
	
	private void connect(String query) {
		try {
			c = DriverManager.getConnection(dbURL, username, password);
			stmt = c.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private void disconnect() {
		try {
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
