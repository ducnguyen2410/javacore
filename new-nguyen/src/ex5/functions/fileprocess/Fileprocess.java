package ex5.functions.fileprocess;

import ex4.functions.automovefiles.Automovefiles;
import ex5.Classes.Area;
import ex5.Classes.Position;
import ex5.functions.fileoperation.Operation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fileprocess {
    public boolean checkHasFiles(String pathDir) {
        File file = new File(pathDir);
        if (file.list().length > 0) return true;
        else return false;
    }

    public String filterFileType(File path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            try {
                String line = br.readLine();
                br.close();
                Operation operator = new Operation();
                Position tempPosition = operator.filterPosition(line);
                if(tempPosition.isValid()) return "Position";
                Area tempArea = operator.filterArea(line);
                if(tempArea.isValid()) return "Area";
                else return null;
            } catch (IOException e) {
                System.out.println("Error reading file in filterFileType.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("file is not found in filterFileType.");
        }
        return null;
    }

    public void readFile(String path,String pathOut, List<Position> listPosition, List<Area> listArea) {
        Operation operator = new Operation();
        Fileprocess fileprocess = new Fileprocess();
        Automovefiles filemover = new Automovefiles();
        File dir = new File(path);
        File[] listOfFiles = dir.listFiles();
        for(File i: listOfFiles) {
            String type = fileprocess.filterFileType(i);
            if (type.contains("Position")) {
                operator.addPosition(i,pathOut, listPosition, listArea);
            } else if (type.contains("Area")) {
                operator.addArea(i, listArea);
            }
            filemover.autoMoveFiles(path, pathOut);
        }
    }
}
