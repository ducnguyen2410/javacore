package ex5;

import ex5.Classes.Area;
import ex5.Classes.Position;
import ex5.functions.fileprocess.Fileprocess;
import ex5.functions.fileoperation.Operation;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pathInput = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex5\\FileResource\\input";
        String pathOutput = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex5\\FileResource\\output";
        List<Position> listPosition = new ArrayList<>();
        List<Area> listArea = new ArrayList<>();
        Fileprocess fileProcessor = new Fileprocess();
        Operation operator = new Operation();
        while (true) {
            while (!fileProcessor.checkHasFiles(pathInput)) ;
            fileProcessor.readFile(pathInput, pathOutput, listPosition, listArea);
        }
    }
}
