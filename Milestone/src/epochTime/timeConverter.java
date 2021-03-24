package epochTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class timeConverter {
	
	
	private static Date today = Calendar.getInstance().getTime();
	private static Calendar calendar = Calendar.getInstance(); // Returns instance with current date and time set
	//Formats the time for us :)
	private static SimpleDateFormat calanderFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	
	
	public String getCurrentTimeStamp() {
		int timeStamp = getEpochTimeInt();
		return convertTimeStamp(timeStamp);
	}
	
	
	public String convertTimeStamp(int stamp) {
		Date date = new Date((long)stamp * 1000);
		String formatted = calanderFormatter.format(date);
		return formatted;
	}
	
	
	public long getEpochTimeLong() {
		return today.getTime();
	}
	
	public int getEpochTimeInt() {
		return (int) (today.getTime() / 1000);
	}
	
	

}
