package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Data;
import epochTime.TimeConverter;

/**
* User data service. Connects and interfaces directly with the currentWeather table in the SQL database.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
public class ConnectToWeatherDB {
	private String dbURL = "jdbc:mysql://remotemysql.com:3306/hHOQMOQDTD?autoReconnect=true&useSSL=false";
	private String username = "hHOQMOQDTD";
	private String password = "f3HJJN4I3c";
	
	private Connection c = null;
	private Statement stmt = null;
	private ResultSet rs;
	private TimeConverter tc = new TimeConverter();
	
	public Data getCurrentData() {
		connect("select * from hHOQMOQDTD.currentweather");
		Data fd = new Data();
		try {
			while(rs.next()) {
				fd.setTimeStamp(tc.convertTimeStamp(rs.getInt("Time")));
				fd.setTempature(rs.getDouble("Tempature"));
				fd.setPressure(rs.getDouble("Pressure"));
				fd.setHumidity(rs.getDouble("Humidity"));
				fd.setLocation(rs.getString("Location"));
				//optional to make the data simple 
				fd.makeDataSimple();
				System.out.println(fd.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
		return fd;
	}
	
	public List<Data> getAllWeatherData() {
		connect("select * from hHOQMOQDTD.weatherInformation");
		List<Data> allData = new ArrayList<Data>();
		try {
			while(rs.next()) {
				Data fd = new Data();
				fd.setTimeStamp(tc.convertTimeStamp(rs.getInt("Time")));
				fd.setTempature(rs.getDouble("Tempature"));
				fd.setPressure(rs.getDouble("Pressure"));
				fd.setHumidity(rs.getDouble("Humidity"));
				fd.setLocation(rs.getString("Location"));
				//optional to make the data simple 
				fd.makeDataSimple();
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
