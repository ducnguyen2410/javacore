package reviewDemo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Alert {
	private String mmsi;
	private String alertMsg;
	private String areaName;
	private long longitude;
	private long latitude;
	private LocalDateTime time;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	public Alert(String mmsi, String alertMsg, String areaName, long longitude, long latitude, LocalDateTime time) {
		this.mmsi = mmsi;
		this.alertMsg = alertMsg;
		this.areaName = areaName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.time = time;
	}
	
	public String getMmsi() {
		return mmsi;
	}
	
	public String getAlertMsg() {
		return alertMsg;
	}
	
	public String getAreaName() {
		return areaName;
	}
	
	public long getLongitude() {
		return longitude;
	}
	
	public long getLatitude() {
		return latitude;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public String toString() {
		return new StringBuilder(this.mmsi)
				.append("|").append(this.alertMsg)
				.append("|").append(this.areaName)
				.append("|").append(this.longitude)
				.append("|").append(this.latitude)
				.append("|").append(this.time.format(formatter))
				.toString();
	}
}
