package business;


import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Data;
import database.ConnectToWeatherDB;

//@RequestScoped Is not needed, in the textbook examples the annotation is not present; YAY (Shad Sluiter has it in his videos)
@Path("/weather")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class WeatherRestService {
	
	/*
	*****Here are the links to show the xml and json outputs.*******
	
	
	xml
	http://localhost:8080/Milestone/rest/weather/getxml
	
	json
	http://localhost:8080/Milestone/rest/weather/getjson
	
	*/
	
	
	
	ConnectToWeatherDB wdb = new ConnectToWeatherDB();
	
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Data> getDataAsJson(){
		return wdb.getAllWeatherData();
	}
	
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Data[] getDataAsXml(){
		List<Data> allData = wdb.getAllWeatherData();
		
		return allData.toArray(new Data[allData.size()]);
	}

}
