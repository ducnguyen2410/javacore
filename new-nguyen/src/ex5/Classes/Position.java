package ex5.Classes;

import java.time.LocalDateTime;
import java.util.List;

public class Position {
    private String mmsi;
    private int longitude;
    private int latitude;
    private LocalDateTime dateAndTime;

    public Position(String mmsi, int longitude, int latitude, LocalDateTime dateAndTime)
    {
        this.mmsi = mmsi;
        this.longitude = longitude;
        this.latitude = latitude;
        this.dateAndTime = dateAndTime;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public boolean isValid() {
        if(this.mmsi == null ||
        this.latitude <= 0 ||
        this.longitude <= 0 ||
        this.dateAndTime == null) return false;
        return true;
    }

    public boolean invadeArea(List<Area> listArea) {
        int longitude = this.getLongitude();
        int latitude = this.getLatitude();
        for(Area i: listArea) {
            if((longitude >= i.getLeftLongitude() && longitude <= i.getRightLongitude()) &&
                    (latitude >= i.getBottomLatitude() && latitude <= i.getTopLatitude())) return true;
        }
        return false;
    }

    public String findInvadeArea(List <Area> listArea)
    {
        int longitude = this.getLongitude();
        int latitude = this.getLatitude();
        for(Area i: listArea) {
            if((longitude >= i.getLeftLongitude() && longitude <= i.getRightLongitude()) &&
                    (latitude >= i.getBottomLatitude() && latitude <= i.getTopLatitude())) return i.getAreaId();
        }
        return null;
    }
}
