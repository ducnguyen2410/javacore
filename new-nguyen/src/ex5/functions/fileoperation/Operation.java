package ex5.functions.fileoperation;

import ex5.Classes.Area;
import ex5.Classes.Position;
import ex5.functions.fileprocess.Fileprocess;
import ex5.functions.listlogic.Listlogic;

import javax.management.OperationsException;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
public class Operation {
    public void addPosition(File path,String pathOut, List<Position> listPosition, List<Area> listArea) {
        try {
            Operation operator = new Operation();
            BufferedReader br = new BufferedReader(new FileReader(path));
            Listlogic listlogic = new Listlogic();
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    Position tempPosition = filterPosition(line);
                    if(tempPosition.isValid()) {
                        if(listlogic.inListPostition(listPosition, tempPosition.getMmsi())) {
                            tempPosition = updatePosition(listPosition, tempPosition);
                            if(tempPosition != null) {
                                operator.notifyShip(pathOut, tempPosition, listArea);
                            }
                        }else {
                            listPosition.add(tempPosition);
                            operator.notifyShip(pathOut,tempPosition,listArea);
                        }
                    }
                }
                br.close();
            }catch (IOException e) {
                System.out.println("Cannot read file addPosition in operation.addPosition.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no file in operation.addPosition.");
        }
    }

    public void addArea(File path, List<Area> listArea) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Listlogic listlogic = new Listlogic();
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    Area tempArea = filterArea(line);
                    if(tempArea.isValid() && !listlogic.inListArea(listArea, tempArea.getAreaId())) {
                        listArea.add(tempArea);
                    }
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Cannot read file addPosition in operation.addArea.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no file in operation.addArea.");
        }
    }

    public Position filterPosition(String line) {
        int firstSign = line.indexOf("|");
        int secondSign = line.indexOf("|", firstSign + 1);
        int thirdSign = line.indexOf("|", secondSign + 1);
        if (firstSign == -1 || secondSign == -1 || thirdSign == -1) return new Position(null, 0, 0, null);
        String mmsi = line.substring(0,firstSign);
        if(mmsi.contains("Vung")) return new Position(null,0,0,null);
        int longitude = Integer.parseInt(line.substring(firstSign + 1, secondSign));
        int latitude = Integer.parseInt(line.substring(secondSign + 1, thirdSign));
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String datedate = line.substring(thirdSign+1);
        LocalDateTime dateAndTime = LocalDateTime.parse(line.substring(thirdSign + 1), df);
        return new Position(mmsi, longitude, latitude, dateAndTime);
    }

    public Area filterArea(String line) {
        String[] count = line.split("|");
        int firstSign = line.indexOf("|");
        int secondSign = line.indexOf("|", firstSign + 1);
        int thirdSign = line.indexOf("|", secondSign + 1);
        int fourthSign = line.indexOf("|", thirdSign + 1);
        if (firstSign == -1 ||
                secondSign == -1 ||
                thirdSign == -1 ||
                fourthSign == -1) return new Area(null, 0, 0, 0, 0);
        String areaId = line.substring(0, firstSign);
        if(!areaId.contains("Vung")) return new Area(null,0,0,0,0);
        int leftLongitude = Integer.parseInt(line.substring(firstSign + 1, secondSign));
        int rightLongitude = Integer.parseInt(line.substring(secondSign + 1, thirdSign));
        int topLatitude = Integer.parseInt(line.substring(thirdSign + 1, fourthSign));
        int bottomLatitude = Integer.parseInt(line.substring(fourthSign + 1));
        return new Area(areaId, leftLongitude, rightLongitude, topLatitude, bottomLatitude);
    }

    public Position updatePosition(List<Position> listPosition, Position tempPosition) {
        for(Position i: listPosition)
        {
            if(i.getMmsi().contains(tempPosition.getMmsi()))
            {
                if(tempPosition.getDateAndTime().compareTo(i.getDateAndTime()) > 0)
                {
                    i.setLatitude(tempPosition.getLatitude());
                    i.setLongitude(tempPosition.getLongitude());
                    i.setDateAndTime(tempPosition.getDateAndTime());
                    return i;
                }
                break;
            }
        }
        return null;
    }

    public void notifyShip(String pathOutput, Position position, List<Area> listArea) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathOutput + "\\" + "notify.txt", true));
            if(listArea.size() > 0) {
                if(position.invadeArea(listArea)) {
                    String line = position.getMmsi() + "|Canh bao xam nhap vung|" +
                            position.findInvadeArea(listArea) +"|"+
                            position.getLongitude()+"|"+position.getLatitude()+"|"+
                            position.getDateAndTime();
                    bw.write(line);
                    bw.write("\n");
                }
            }
            bw.close();
        }catch (IOException e) {
            System.out.println("Cannot write file in notifyShip.");
        }
    }
}
