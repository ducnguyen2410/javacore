package reviewDemo.model;

import java.util.List;

public class Area {
	private String areaName;
	private long latTop;
	private long latBottom;
	private long longLeft;
	private long longRight;
	private List<String> shipList;
	
	public Area(String areaName, long latTop, long latBottom, long longLeft, long longRight) {
		this.areaName = areaName;
		this.latTop = latTop;
		this.latBottom = latBottom;
		this.longLeft = longLeft;
		this.longRight = longRight;
	}
	
	public String getAreaName() {
		return areaName;
	}
	
	public long getLatTop() {
		return latTop;
	}
	
	public long getLatBottom() {
		return latBottom;
	}
	
	public long getLongLeft() {
		return longLeft;
	}
	
	public long getLongRight() {
		return longRight;
	}
	
	public boolean equals(Object obj) {
		if(! (obj instanceof Area)) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		Area area = (Area)obj;
		if(this.areaName.equals(area.areaName)
			&&this.latTop == area.latTop
			&&this.latBottom == area.latBottom
			&&this.longLeft == area.longLeft
			&&this.longRight == area.longRight) {
			return true;
		}
		return false;
	}
	
	public int hashCode() { return this.areaName.hashCode(); }
	public List<String>getShipList() { return shipList; }
	public void setShipList(List<String> setListShip) { this.shipList = shipList; }
}
