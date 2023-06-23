package reviewDemo.model;

public class Ship {
	private String mmsi;
	private Area area;
	private Position position;
	
	public Ship(String mmsi) {
		this.mmsi = mmsi;
	}
	
	public String getMmsi() {
		return mmsi;
	}
	
	public void setMmsi(String mmsi) {
		this.mmsi = mmsi;
	}
	
	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
}
