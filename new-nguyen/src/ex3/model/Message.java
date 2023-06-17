package ex3.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Message {
    public String soDT;
    public String lenh;
    public LocalDateTime dateTime;
    public String cuPhap;
    public boolean status;
    public Message(String soDt, String lenh, LocalDateTime dateTime, String cuPhap, boolean status)
    {
        this.soDT = soDt;
        this.lenh = lenh;
        this.dateTime = dateTime;
        this.cuPhap = cuPhap;
        this.status = status;
    }

    public boolean inList(ArrayList<CuPhap> listCuPhap, String targetCuPhap)
    {
        for(CuPhap i: listCuPhap)
        {
            if(targetCuPhap.compareTo(i.cuPhap) == 0) return true;
        }
        return false;
    }
    public boolean isValid(Message newMessage)
    {
        if(newMessage.soDT.length() != 13 ||
                newMessage.lenh.length() == 0 ||
                newMessage.dateTime.compareTo(LocalDateTime.now()) > 1) return false;
        return true;
    }
}
