package business;


import java.util.List;

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
//@RequestScoped This annotation breaks everything -_-
@Path("/weather")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class WeatherRestService {
	
	
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
