package ex4.bai2;

import ex4.bai2.classIdentify.Command;
import ex4.bai2.classIdentify.Phone;
import ex4.functions.checkformat.Checkformat;
import ex4.functions.processfilewithtype.Processfilewithtype;
import ex4.functions.automovefiles.Automovefiles;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        String pathInput = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex4\\FileResource\\input";
        String pathOutput = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex4\\FileResource\\output";
        String pathToWrite = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex4\\FileResource\\log";
        File fileInput = new File(pathInput);
        Checkformat check = new Checkformat();
        Processfilewithtype processType = new Processfilewithtype();
        ArrayList<Phone> listPhone = new ArrayList<>();
        Automovefiles fileMover = new Automovefiles();
        while(true)
        {
            while(fileInput.list().length <= 0);
            for(String i: fileInput.list())
            {
                String type = check.checkFormat(i, pathInput);
                if(type.contains("Command")) {
                    processType.processFileWithType(pathInput + "\\" + i, type, pathToWrite + "\\log.txt", listPhone);
                }else if(type.contains("Phone")) {
                    processType.processFileWithType(pathInput + "\\" + i, type, pathOutput + "\\balance.txt", listPhone);
                }else {
                    System.out.printf("Cannot specify type of file: %s\n", i);
                }
                fileMover.autoMoveFiles(pathInput, pathOutput);
            }
        }
    }
}
