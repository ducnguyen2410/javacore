package ex4.functions.checkformat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Checkformat {
    public String checkFormat(String fileName, String dir)
    {
        String completeFileDir = dir + "\\" + fileName;
        try {
            BufferedReader br = new BufferedReader(new FileReader(completeFileDir));
            try {
                String line = br.readLine();
                br.close();
                if(isCommand(line)) return "Command";
                else return "Phone";
            }catch (IOException e) {
                System.out.println("Cannot read in checkFormat");
            }
        }catch (FileNotFoundException e) {
            System.out.println("File not found in checkFormat");
        }
        return null;
    }

    public boolean isCommand(String line)
    {
        return (line.contains("add") || line.contains("minus") || line.contains("transfer"));
    }
}
