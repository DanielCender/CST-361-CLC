package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Data;
import epochTime.timeConverter;

public class ConnectToWeatherDB {
	
	private String dbURL = "jdbc:mysql://remotemysql.com:3306/hHOQMOQDTD?autoReconnect=true&useSSL=false";
	private String username = "hHOQMOQDTD";
	private String password = "f3HJJN4I3c";
	
	private Connection c = null;
	private Statement stmt = null;
	private ResultSet rs;
	private timeConverter tc = new timeConverter();
	
	
	
	public List<Data> getAllWeatherData() {
		connect("select * from hHOQMOQDTD.weatherInformation");
		List<Data> allData = new ArrayList<Data>();
		try {
			while(rs.next()) {
				Data fd = new Data();
				fd.setTimeStamp(tc.convertTimeStamp(rs.getInt("Time")));
				fd.setTempature(rs.getDouble("Tempature"));
				fd.setPressure(rs.getDouble("Pressure"));
				fd.setLocation(rs.getString("Location"));
				allData.add(fd);
				//System.out.println(fd.toString());
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		disconnect();
		return allData;
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
