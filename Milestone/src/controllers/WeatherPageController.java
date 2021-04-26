package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import beans.Data;
import database.ConnectToWeatherDB;

/**
* Controller managing Weather Dashboard Page.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
@ManagedBean
public class WeatherPageController {
	
	
	ConnectToWeatherDB wdb = new ConnectToWeatherDB();
	
	public List<Data> dataList = new ArrayList<Data>();
	public Data currentData = new Data();
	
	public WeatherPageController() {
		dataList =  wdb.getAllWeatherData();
		currentData = wdb.getCurrentData();
	}
	
	
	
	public Data getCurrentData() {
		return currentData;
	}

	public void setCurrentData(Data currentData) {
		this.currentData = currentData;
	}

	public void getData() {
		setDataList(wdb.getAllWeatherData());
	}

	public List<Data> getDataList() {
		return dataList;
	}

	public void setDataList(List<Data> dataList) {
		this.dataList = dataList;
	}
	
	
	

}
