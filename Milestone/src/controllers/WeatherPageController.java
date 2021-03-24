package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.Data;
import business.ConnectToWeatherDB;

@ManagedBean
@ViewScoped
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
