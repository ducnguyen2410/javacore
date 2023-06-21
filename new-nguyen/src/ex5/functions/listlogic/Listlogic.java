package ex5.functions.listlogic;

import ex5.Classes.Area;
import ex5.Classes.Position;

import java.util.List;

public class Listlogic {
    public boolean inListPostition(List<Position> listPosition, String mmsi) {
        for(Position i: listPosition) {
            if (i.getMmsi().contains(mmsi)) return true;
        }
        return false;
    }

    public boolean inListArea(List<Area> listArea, String areaId) {
        for(Area i: listArea) {
            if(i.getAreaId().contains(areaId)) return true;
        }
        return false;
    }
}
