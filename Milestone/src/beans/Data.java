package beans;

import java.text.DecimalFormat;

import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@ViewScoped
@Entity
@XmlRootElement(name = "Data")
public class Data {
	
	private int Time;
	private String TimeStamp;
	private double Tempature;
	private double Pressure;
	private double Humidity;
	private String Location;
	
	
	public Data() {}
	
	
	//Epoch Data
	public Data(int time, double tempature, double pressure, double humidity, String location) {
		this.Time = time;
		this.Tempature = tempature;
		this.Pressure = pressure;
		this.Humidity = humidity;
		this.Location = location;
	}
	//TimeStamp Data
	public Data(String timeStamp, double tempature, double pressure, double humidity, String location) {
		this.TimeStamp = timeStamp;
		this.Tempature = tempature;
		this.Pressure = pressure;
		this.Humidity = humidity;
		this.Location = location;
	}
	

	@Override
	public String toString() {
		String r = "";
		if (TimeStamp != null) {
			r = "Data [Time=" + TimeStamp + ", Tempature=" + Tempature + ", Pressure=" + Pressure
				+ ", Humidity=" + Humidity + ", Location=" + Location + "]";
		} else {
			r = "Data [Time=" + Time + ", Tempature=" + Tempature + ", Pressure=" + Pressure
					+ ", Humidity=" + Humidity + ", Location=" + Location + "]";
		}
		
		
		return r;
	}
	
	public void makeDataSimple() {
		DecimalFormat format = new DecimalFormat("#.##");
		setTempature(Double.parseDouble(format.format(getTempature())));
		setPressure(Double.parseDouble(format.format(getPressure())));
		setHumidity(Double.parseDouble(format.format(getHumidity())));
	}
	
	
	
	public double getHumidity() {
		return Humidity;
	}


	


	public void setHumidity(double humidity) {
		Humidity = humidity;
	}


	public String getTimeStamp() {
		return TimeStamp;
	}


	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}


	public int getTime() {
		return Time;
	}

	public void setTime(int time) {
		Time = time;
	}

	public double getTempature() {
		return Tempature;
	}

	public void setTempature(double tempature) {
		Tempature = tempature;
	}

	public double getPressure() {
		return Pressure;
	}

	public void setPressure(double pressure) {
		Pressure = pressure;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
	
	
	

}
