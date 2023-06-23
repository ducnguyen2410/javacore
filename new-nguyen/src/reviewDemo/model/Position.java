package reviewDemo.model;

import java.time.LocalDateTime;

public class Position {
    private String mmsi;
    private long longitude;
    private long latitude;
    private LocalDateTime time;

    public Position(String mmsi, long longitude, long latitude, LocalDateTime time)
    {
        this.mmsi = mmsi;
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }


}
