package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped 
public class Data {
	
	private int Time;
	private String TimeStamp;
	private double Tempature;
	private double Pressure;
	private String Location;
	
	
	public Data() {}
	
	
	//Epoch Data
	public Data(int time, double tempature, double pressure, String location) {
		this.Time = time;
		this.Tempature = tempature;
		this.Pressure = pressure;
		this.Location = location;
	}
	//TimeStamp Data
	public Data(String timeStamp, double tempature, double pressure, String location) {
		this.TimeStamp = timeStamp;
		this.Tempature = tempature;
		this.Pressure = pressure;
		this.Location = location;
	}
	

	@Override
	public String toString() {
		String r = "";
		if (TimeStamp != null) {
			r = "Data [Time=" + TimeStamp + ", Tempature=" + Tempature + ", Pressure=" + Pressure + ", Location=" + Location
					+ "]";
		} else {
			r = "Data [Time=" + Time + ", Tempature=" + Tempature + ", Pressure=" + Pressure + ", Location=" + Location
			+ "]";
		}
		
		
		return r;
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
